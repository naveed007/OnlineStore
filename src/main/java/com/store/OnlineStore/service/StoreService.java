package com.store.OnlineStore.service;

import com.store.OnlineStore.model.Bill;
import com.store.OnlineStore.model.Customer;
import com.store.OnlineStore.model.OrderRequest;
import com.store.OnlineStore.model.Product;
import com.store.OnlineStore.model.ProductRequest;
import com.store.OnlineStore.model.RegCustRequest;

import java.util.List;

public interface StoreService {
  
  List<Product> getProduct();

  Bill generateBill(String custId);

  void addToCard(OrderRequest request);

  void register(RegCustRequest request);

  List<Customer> getCustomer();

  void addProduct(ProductRequest request);

}
