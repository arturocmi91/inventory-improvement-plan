package com.artiraci.inventoryimprovementplan.Models.WhInbound;

import com.artiraci.inventoryimprovementplan.Models.Orders.RequestedOrder;
import com.artiraci.inventoryimprovementplan.Models.Users.Adm;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.List;
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

    //Rel Comp entre muchos pedidos y un proveedor.

    @OneToMany(mappedBy = "supplierId", cascade = CascadeType.ALL)
    private List<RequestedOrder> requestedOrders;
    // Relacion Agregacion con Adm que agrego al proveedor
    @ManyToOne
    @JoinColumn(name = "assigned_id")
    private Adm assignedBy;

    public Supplier() {
    }

}
