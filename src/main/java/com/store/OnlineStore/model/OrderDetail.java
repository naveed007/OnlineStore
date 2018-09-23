package com.store.OnlineStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
  private Integer prodId;
  private String prodName;
  private Integer qty;
  private BigDecimal rate; 
  private BigDecimal tax;
}
