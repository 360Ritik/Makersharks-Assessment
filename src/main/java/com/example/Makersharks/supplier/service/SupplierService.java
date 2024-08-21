package com.example.Makersharks.supplier.service;

import com.example.Makersharks.supplier.exception.NoSuppliersFoundException;
import com.example.Makersharks.supplier.model.ManufacturingProcess;
import com.example.Makersharks.supplier.model.NatureOfBusiness;
import com.example.Makersharks.supplier.model.Supplier;
import com.example.Makersharks.supplier.repository.SupplierRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SupplierService {


    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> searchSuppliers(String location, NatureOfBusiness natureOfBusiness, ManufacturingProcess manufacturingProcess, Pageable pageable) {
        Page<Supplier> suppliers = supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(location, natureOfBusiness, manufacturingProcess, pageable);

        if (suppliers.isEmpty()) {
            throw new NoSuppliersFoundException("No suppliers found for the given criteria.");
        }

        return suppliers.getContent();
    }

    public Supplier addSupplier(Supplier supplier) {
        // Check if company already exists
        if (supplierRepository.existsByCompanyName(supplier.getCompanyName())) {
            // Throw an exception if the company already exists
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Company already registered");
        }

        // Save the new supplier if the company does not exist
        return supplierRepository.save(supplier);
    }
}

