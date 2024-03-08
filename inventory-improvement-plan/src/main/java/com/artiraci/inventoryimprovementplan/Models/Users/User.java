package com.artiraci.inventoryimprovementplan.Models.Users;

import com.artiraci.inventoryimprovementplan.Models.Inventory;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Debe tener un nombre")
    private String userName;

    @NotBlank(message = "Debe tener un email")
    private String userEmail;

    @NotBlank(message = "Debe tener una contraseña")
    @Size(min = 8)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$")
    private String password;

    @NotNull
    private LocalDateTime registeredDate;

    //muestra relacion usuario-inventario.
    @ManyToMany
    @JoinTable(
            name = "user_inventory",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Inventory> inventories;

    //muestra relacion item-User .
    @ManyToMany
    @JoinTable(
            name = "user_item",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<ItemInfo> items;



    public User() {
    }


}
