package com.store.OnlineStore.service;

import com.store.OnlineStore.model.Bill;
import com.store.OnlineStore.model.BillItem;
import com.store.OnlineStore.model.Customer;
import com.store.OnlineStore.model.OrderDetail;
import com.store.OnlineStore.model.OrderRequest;
import com.store.OnlineStore.model.Product;
import com.store.OnlineStore.model.ProductRequest;
import com.store.OnlineStore.model.RegCustRequest;
import com.store.OnlineStore.repository.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StoreServiceImpl implements StoreService {

  private StoreRepository repository;
  
  @Autowired
  public StoreServiceImpl(final StoreRepository repository) {
    this.repository = repository;
  }
  
  @Override
  public List<Product> getProduct() {
    return repository.getProducts();
  }

  @Transactional
  @Override
  public Bill generateBill(String custId) {
    List<OrderDetail> orders = repository.getOrderByCustId(custId);
    Bill bill = new Bill();
    List<BillItem> billItems = new ArrayList<>();
    orders.stream().forEach( order -> {
      BillItem item = new BillItem();
      item.setProdName(order.getProdName());
      item.setQty(order.getQty());
      item.setRate(order.getRate());
      item.setTax(order.getTax());
      item.setCostWithTax(
          order.getTax().compareTo(BigDecimal.ZERO) == 0 ? order.getRate() 
              :  order.getRate().add(order.getRate().multiply(order.getTax()).divide(new BigDecimal("100"))).multiply(new BigDecimal(order.getQty()).setScale(BigDecimal.ROUND_HALF_DOWN)));
      billItems.add(item);
    });
    bill.setBillItems(billItems);
    BigDecimal totalTax = BigDecimal.ZERO;
    BigDecimal totalRate = BigDecimal.ZERO;
    BigDecimal totalCost = BigDecimal.ZERO;
    for(BillItem billItem: billItems) {
      totalTax = totalTax.add(billItem.getTax());
      totalRate = totalRate.add(billItem.getRate());
      totalCost = totalCost.add(billItem.getCostWithTax());
    }
    bill.setTotalCost(totalCost);
    bill.setTotalRate(totalRate);
    bill.setTotalTax(totalTax);
    bill.setStoreName("MyStore");
    Random r = new Random();
    bill.setBillId(r.nextInt(Integer.MAX_VALUE)+1);
    repository.markOrderAsBilled(custId);
    return bill;
  }

  @Override
  public void addToCard(OrderRequest request) {
    repository.addToCard(request);
  }

  @Override
  public void register(RegCustRequest request) {
    repository.registerCust(request);
  }

  @Override
  public List<Customer> getCustomer() {
    return repository.getCustomer();
  }

  @Override
  public void addProduct(ProductRequest request) {
    repository.addProduct(request);
  }
  
  
}
