package com.artiraci.inventoryimprovementplan.Models;

import com.artiraci.inventoryimprovementplan.Enums.CustomerType;
import com.artiraci.inventoryimprovementplan.Models.Orders.Order;
import com.artiraci.inventoryimprovementplan.Models.Users.Adm;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customer")

public class Customer {
    @Id
    @NotNull(message = "Debe tener un Identificador de Cliente")
    @Column(name = "customer_id")
    private String id;


    @NotBlank
    @Column(name = "customer_name")
    private String customerName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type")
    private CustomerType customerType;

    @NotBlank
    @Column(name = "address")
    private String customerAddress;

    @NotBlank
    @Column(name = "email")
    private String customerEmail;

    @NotBlank
    @PastOrPresent
    @Column(name = "join_date")

    private LocalDateTime joinDate;

    //Relacion de composicion Customer con Lista de Ordenes
    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL)
    private List<Order> orders;

    //Realacion Agregacion con Adm(quien lo asigna al negocio)
    @ManyToOne
    @JoinColumn(name="assignedBy")

    private Adm assignedBy;


    public Customer() {
    }

}
