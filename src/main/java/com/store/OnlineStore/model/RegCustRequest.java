package com.store.OnlineStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegCustRequest {
  @NotBlank
  private String custId;
  @NotBlank
  private String name;
  @NotBlank
  private String password;

}
