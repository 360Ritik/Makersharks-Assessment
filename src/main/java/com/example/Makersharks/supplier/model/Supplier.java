package com.example.Makersharks.supplier.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "suppliers")
@Data
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    @NotBlank(message = "Company name must not be blank")
    private String companyName;

    @Pattern(regexp = "^(http://|https://|ftp://)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}(/[^\\s]*)?$", message = "Invalid URL format")
    private String website;


    @NotBlank(message = "Location must not be blank")
    private String location;

    @Enumerated(EnumType.STRING)
    private NatureOfBusiness natureOfBusiness;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "manufacturing_processes", joinColumns = @JoinColumn(name = "supplier_id"))
    @Column(name = "process")
    private Set<ManufacturingProcess> manufacturingProcesses;


}

