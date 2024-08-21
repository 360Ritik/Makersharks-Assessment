package com.example.Makersharks.supplier.service;

import com.example.Makersharks.supplier.model.Supplier;
import com.example.Makersharks.supplier.repository.SupplierRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class SupplierServiceTest {
    @Autowired
    private SupplierService supplierService;

    @MockBean
    private SupplierRepository supplierRepository;

    @Test
    public void SupplierService() {
        SupplierRepository supplierRepository = null;
        SupplierService expected = new SupplierService(null);
        SupplierService actual = new SupplierService(supplierRepository);

        assertEquals(expected, actual);
    }

    @Test
    public void SupplierServiceTODO() {
        SupplierRepository supplierRepository = null;
        SupplierService expected = new SupplierService(null);
        SupplierService actual = new SupplierService(supplierRepository);

        assertEquals(expected, actual);
    }

    @Test
    public void addSupplier() {
        Supplier supplier = new Supplier();
        Supplier expected = new Supplier();
        Supplier actual = supplierService.addSupplier(supplier);

        assertEquals(expected, actual);
    }

    @Test
    public void addSupplierTODO() {
        Supplier supplier = new Supplier();
        Supplier expected = new Supplier();
        Supplier actual = supplierService.addSupplier(supplier);

        assertEquals(expected, actual);
    }
}
