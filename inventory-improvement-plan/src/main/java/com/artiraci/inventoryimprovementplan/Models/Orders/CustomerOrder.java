package com.artiraci.inventoryimprovementplan.Models.Orders;

import com.artiraci.inventoryimprovementplan.Enums.SaleType;
import com.artiraci.inventoryimprovementplan.Models.Inventory;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class CustomerOrder  extends Order{

    @NotNull(message = "Debe tener un tipo de venta")
   @Enumerated(EnumType.STRING)
    private SaleType saleType;

    @NotNull(message = "Debe tener un valor")
    @DecimalMin(value = "0.0")
    private Double revenue;

    //Relacion agregacion entre Orden de Clientes y Ubicaciones en el invenatario
    @ManyToMany
    @JoinTable(
            name = "customer_Order_inventory",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_id")
    )
    private List<Inventory> allocations;



}
