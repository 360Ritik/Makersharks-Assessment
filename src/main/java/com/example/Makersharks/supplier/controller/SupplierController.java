package com.example.Makersharks.supplier.controller;

import com.example.Makersharks.supplier.dto.SupplierSearchRequest;
import com.example.Makersharks.supplier.model.Supplier;
import com.example.Makersharks.supplier.service.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {


    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Operation(summary = "Search for suppliers",
            description = "Retrieves a list of suppliers based on search criteria such as location, nature of business, and manufacturing process.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of suppliers matching the search criteria",
                            content = @Content(schema = @Schema(implementation = Supplier.class)))
            })
    @PostMapping("/query")
    public ResponseEntity<List<Supplier>> searchSuppliers(@RequestBody SupplierSearchRequest suppRequest) {

        Pageable pageable = PageRequest.of(suppRequest.getPage(), suppRequest.getSize());
        List<Supplier> resultPage = supplierService.searchSuppliers(suppRequest.getLocation(), suppRequest.getNatureOfBusiness(), suppRequest.getManufacturingProcess(), pageable);

        return ResponseEntity.ok(resultPage);
    }


    @Operation(summary = "Add a new supplier",
            description = "Creates a new supplier in the system with the provided details.",

            responses = {
                    @ApiResponse(responseCode = "201", description = "Supplier successfully created",
                            content = @Content(schema = @Schema(implementation = Supplier.class)))
            })
    @PostMapping("/newSupplier")
    public ResponseEntity<Supplier> addSupplier(@Valid @RequestBody Supplier supplier) {
        Supplier savedSupplier = supplierService.addSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSupplier);
    }
}
