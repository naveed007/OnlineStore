package com.store.OnlineStore.repository;

import com.store.OnlineStore.model.Customer;
import com.store.OnlineStore.model.OrderDetail;
import com.store.OnlineStore.model.OrderRequest;
import com.store.OnlineStore.model.Product;
import com.store.OnlineStore.model.ProductRequest;
import com.store.OnlineStore.model.RegCustRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class StoreRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public List<Product> getProducts(){
    List<Product> prods = new ArrayList<>();
    jdbcTemplate.query("select p.id, p.name, p.rate, c.name as cat_name from product p , category c where p.cat_id = c.id",
        (ResultSet rs, int arg1) -> prods.add(
            new Product(rs.getInt("ID"), rs.getString("NAME"), rs.getBigDecimal("RATE"), rs.getString("CAT_NAME"))));
    return prods;
  }

  public List<OrderDetail> getOrderByCustId(String custId) {
    List<OrderDetail> orders = new ArrayList<>();
    jdbcTemplate.query("select o.prod_id, p.name as prod_name, o.qty , p.rate, ct.tax from cust_order o, product p, customer c, category ct "
        + " where o.cust_id = c.id and o.prod_id = p.id and p.cat_id = ct.id and o.is_billed = 'N'", 
    (ResultSet rs, int arg1) -> orders.add(
        new OrderDetail(rs.getInt("PROD_ID"), rs.getString("PROD_NAME"), rs.getInt("QTY"), rs.getBigDecimal("RATE"), rs.getBigDecimal("TAX"))));
   return orders;
  }

  public void addToCard(OrderRequest request) {
    jdbcTemplate.update("insert into cust_order(cust_id, prod_id, qty) values (?,?,?)",
        request.getCustId(), request.getProdId(),request.getQty());
  }

  public void registerCust(RegCustRequest request) {
    jdbcTemplate.update("insert into customer(id, name, password) values (?,?,?)",
        request.getCustId(), request.getName(),request.getPassword());
  }

  public List<Customer> getCustomer() {
    List<Customer> custs = new ArrayList<>();
    jdbcTemplate.query("select c.id, c.name from customer c",
    (ResultSet rs, int arg1) -> custs.add(
        new Customer(rs.getString("ID"), rs.getString("NAME"))));
   return custs;
  }

  public void markOrderAsBilled(String custId) {
    jdbcTemplate.update("update cust_order set is_billed = 'Y' where cust_id = ?", custId);
  }

  public void addProduct(ProductRequest request) {
    Random r = new Random();
    int id = r.nextInt(Integer.MAX_VALUE) + 10;
    jdbcTemplate.update("insert into product(id, name, rate, cat_id) values (?,?,?,?)",
        id,request.getName(), request.getRate(), request.getCategory());
  }
}
