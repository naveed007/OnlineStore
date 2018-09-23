package com.store.OnlineStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
  private Integer billId;
  private List<BillItem> billItems;
  private String storeName;
  private BigDecimal totalRate;
  private BigDecimal totalTax;
  private BigDecimal totalCost;
}
