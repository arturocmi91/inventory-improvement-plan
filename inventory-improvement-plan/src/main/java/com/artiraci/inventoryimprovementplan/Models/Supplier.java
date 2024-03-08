package com.artiraci.inventoryimprovementplan.Models;

import com.artiraci.inventoryimprovementplan.Models.Users.Adm;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @NotNull(message = "Debe tener un Identificador de Proveedor")
    @Column(name = "supplier_id")

    private String id;


    @Column(name = "supplier_name")
    private String supplierName;

    @NotBlank(message = "Debe tener un email")
    @Column(name = "email")

    private String supplierEmail;

    @NotNull
    @PastOrPresent
    @Column(name = "join_date")

    private LocalDateTime joinDate;

    // Relacion Agregacion con Adm que agrego al proveedor
    @ManyToOne
    @JoinColumn(name = "assigned_id")
    private Adm assignedBy;

    public Supplier() {
    }

}
