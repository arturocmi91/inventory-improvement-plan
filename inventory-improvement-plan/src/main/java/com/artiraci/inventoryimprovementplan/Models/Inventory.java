package com.artiraci.inventoryimprovementplan.Models;

import com.artiraci.inventoryimprovementplan.Enums.LocationType;
import com.artiraci.inventoryimprovementplan.Models.Orders.CustomerOrder;
import com.artiraci.inventoryimprovementplan.Models.Orders.Order;
import com.artiraci.inventoryimprovementplan.Models.Users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Inventory {
    @Id
    @NotBlank(message = "Debe tener una Ubicacion")

    private String InventoryId;

    @NotNull
    @PastOrPresent
    @Column(name = "join_date")

    private LocalDateTime updatedDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Debe tener un tipo de ubicacion")

    private LocationType locationType;

    // relacion Agregacion inventario-item
    @ManyToMany
    @JoinTable(
            name = "inventory_item",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemInfo> items;

    //Relacion Agregacion Lista de Usuarios que han utilizado el inventario.
    @ManyToMany(mappedBy = "inventories", cascade = CascadeType.PERSIST)
    private List<User> users;

    //Relacion Agregacion Lista de Ordenes de clientes (CustomerOrder) que estan asignadas en el Inventario.
    @ManyToMany(mappedBy = "allocations", cascade = CascadeType.PERSIST)
    private List<CustomerOrder>customerOrders;


}
