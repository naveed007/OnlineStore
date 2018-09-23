package com.store.OnlineStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
  @NotBlank
  private String name;
  @NotNull
  private BigDecimal rate;
  @NotBlank
  private String category; 
}