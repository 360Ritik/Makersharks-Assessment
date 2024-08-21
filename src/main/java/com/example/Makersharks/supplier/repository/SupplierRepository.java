package com.example.Makersharks.supplier.repository;


import com.example.Makersharks.supplier.model.ManufacturingProcess;
import com.example.Makersharks.supplier.model.NatureOfBusiness;
import com.example.Makersharks.supplier.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Page<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(
            String location,
            NatureOfBusiness natureOfBusiness,
            ManufacturingProcess manufacturingProcess,
            Pageable pageable);

    boolean existsByCompanyName(String companyName);
}


