package com.example.Makersharks.supplier.controller;

import com.example.Makersharks.supplier.model.Supplier;
import com.example.Makersharks.supplier.service.SupplierService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SupplierController.class)
public class SupplierControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SupplierService supplierService;

    @Test
    public void addSupplier() throws Exception {
        Supplier supplier = new Supplier();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(supplier);
        this.mockMvc.perform(post("/api/suppliers/newSupplier").content(json).contentType(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(jsonPath("$.supplierId").value("<value>")).
                andExpect(jsonPath("$.companyName").value("<value>")).
                andExpect(jsonPath("$.website").value("<value>")).
                andExpect(jsonPath("$.location").value("<value>")).
                andExpect(jsonPath("$.natureOfBusiness").value("<value>")).
                andExpect(jsonPath("$.manufacturingProcesses").value("<value>"));
    }

    @Test
    public void addSupplierTODO() throws Exception {
        Supplier supplier = new Supplier();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(supplier);
        this.mockMvc.perform(post("/api/suppliers/newSupplier").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.supplierId").value("<value>"))
                .andExpect(jsonPath("$.companyName").value("<value>"))
                .andExpect(jsonPath("$.website").value("<value>"))
                .andExpect(jsonPath("$.location").value("<value>"))
                .andExpect(jsonPath("$.natureOfBusiness").value("<value>"))
                .andExpect(jsonPath("$.manufacturingProcesses").value("<value>"));
    }
}
