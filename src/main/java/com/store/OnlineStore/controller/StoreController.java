package com.store.OnlineStore.controller;

import com.store.OnlineStore.model.Bill;
import com.store.OnlineStore.model.Customer;
import com.store.OnlineStore.model.OrderRequest;
import com.store.OnlineStore.model.Product;
import com.store.OnlineStore.model.ProductRequest;
import com.store.OnlineStore.model.RegCustRequest;
import com.store.OnlineStore.service.StoreService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
  
  private final StoreService service;
  
  @Autowired
  public StoreController(final StoreService service) {
    this.service = service;
  }
  
  @ApiOperation("Register customer")
  @RequestMapping(value = "/register" , method = RequestMethod.POST)
  public void register(@RequestBody @Validated RegCustRequest request){
    service.register(request);
  } 
  
  @ApiOperation("Get All customer")
  @RequestMapping(value = "/customer" , method = RequestMethod.GET)
  public List<Customer> getCustomers(){
    return service.getCustomer();
  }
  
  @ApiOperation("Get All Products")
  @RequestMapping(value = "/product" , method = RequestMethod.GET)
  public List<Product> getProduct(){
    return service.getProduct();
  } 
  
  @ApiOperation("add product")
  @RequestMapping(value = "/product" , method = RequestMethod.POST)
  public void addProduct(@RequestBody @Validated ProductRequest request){
    service.addProduct(request);
  } 

  @ApiOperation("Get Bill")
  @RequestMapping(value = "/bill/{customerId}" , method = RequestMethod.GET)
  public Bill generateBill(@PathVariable("customerId") String custId){
    return service.generateBill(custId);
  } 
  
  @ApiOperation("add to order list/cart")
  @RequestMapping(value = "/order" , method = RequestMethod.POST)
  public void addToCart(@RequestBody @Validated OrderRequest request){
    service.addToCard(request);
  } 
}
