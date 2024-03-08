package com.artiraci.inventoryimprovementplan.Models.Users;

import com.artiraci.inventoryimprovementplan.Models.Customer;

import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.artiraci.inventoryimprovementplan.Models.Orders.Order;
import com.artiraci.inventoryimprovementplan.Models.Supplier;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "manager")

public class Adm extends User {

    @NotBlank(message = "Debe tener un cargo")
    private String admRole;

    //Relacion Agregacion Lista de empleados asignados o revisados.
    @OneToMany(mappedBy = "manager", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Employee> employees;

    //Relacion Agregacion Lista de items revisados o modificados.

    @OneToMany(mappedBy = "modifiedBy", cascade = CascadeType.PERSIST)
    private List<ItemInfo> items;

    //Relacion Agregacion Lista de Ordenes revisados o modificados.

    @OneToMany(mappedBy = "actionsBy", cascade = CascadeType.PERSIST)
    private List<Order> orders;

    //Relacion Agregacion lista de clientes Asignados.
    @OneToMany(mappedBy = "assignedBy", cascade = CascadeType.PERSIST)
    private List<Customer> customers;

    //Relacion Agregacion lista de proveedores Asignados.
    @OneToMany(mappedBy = "assignedBy", cascade = CascadeType.PERSIST)
    private List<Supplier> suppliers;
}
