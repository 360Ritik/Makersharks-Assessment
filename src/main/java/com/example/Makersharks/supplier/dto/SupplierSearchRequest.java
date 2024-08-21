package com.example.Makersharks.supplier.dto;

import com.example.Makersharks.supplier.model.ManufacturingProcess;
import com.example.Makersharks.supplier.model.NatureOfBusiness;
import lombok.Data;


@Data
public class SupplierSearchRequest {

    private String location;
    private NatureOfBusiness natureOfBusiness;
    private ManufacturingProcess manufacturingProcess;
    private int page;
    private int size;
}
