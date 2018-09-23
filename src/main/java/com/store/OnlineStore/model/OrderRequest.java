package com.store.OnlineStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
  @NotBlank
  private String custId;
  @NotNull
  private Integer prodId;
  @NotNull
  private Integer qty;

}
