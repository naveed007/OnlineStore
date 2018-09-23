package com.store.OnlineStore.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.store.OnlineStore.service.StoreServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {StoreController.class})
public class StoreControllerTest {
  
    @Autowired
	private MockMvc mockmvc;
    
    @MockBean
    private StoreServiceImpl service;
    
    @Test
    public void generateBillTest() throws Exception {
      MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/store/bill/abc@test.com").accept(MediaType.APPLICATION_JSON);
      mockmvc.perform(builder).andExpect(status().isOk());   
    }

}
