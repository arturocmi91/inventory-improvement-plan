package com.artiraci.inventoryimprovementplan.Models;


import com.artiraci.inventoryimprovementplan.Enums.ItemStatus;
import com.artiraci.inventoryimprovementplan.Enums.QualityItem;
import com.artiraci.inventoryimprovementplan.Models.Orders.Order;
import com.artiraci.inventoryimprovementplan.Models.Users.Adm;
import com.artiraci.inventoryimprovementplan.Models.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "item_info")
public class ItemInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @NotBlank(message = "Debe tener Referencia")
    @Column(name = "ref")
    private String Refence;

    @NotNull
    @Column(name = "barcode")
    @Pattern(regexp = "\\d{12}", message = "El código de barras no valido")
    private Long barcode;

    @NotBlank(message = "Debe tener nombre/descripcion")
    @Column(name = "spare_name")
    private String itemName;

    @NotBlank(message = "Debe tener categoria")
    @Column(name = "category")
    private String category;

    //Relacion modelo con items
    @ManyToOne
    @JoinColumn(name = "model_car_id")

    private ModelCar modelCar;

    @NotNull(message = "Debe tener un status")
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "status")
    private ItemStatus itemStatus;

    @JoinColumn(name = "wholesale_price")
    private Double wholesalePrice;

    @JoinColumn(name = "retail_price")
    private Double retailPrice;


    @JoinColumn(name = "quantity")
    private Integer quantityItem;

    @NotNull(message = "Debe tener un tipo de calidad")
    @Enumerated(EnumType.STRING)
    @Column(name = "quality")
    private QualityItem qualityItem;

    @NotNull(message = "La cantidad de sets no puede ser nula")
    @Min(value = 1, message = "La cantidad de sets debe ser mayor que 0")
    @Column(name = "quantity_set")
    private Integer quantitySet;

    @ManyToOne
    @JoinColumn(name = "modified_by")

    private Adm modifiedBy;
    // relacion Agregacion inventario-item
   /* @JsonIgnore
    @ManyToMany(mappedBy = "items", cascade = CascadeType.PERSIST)
    private List<Inventory> inventories;*/
    // relacion Agregacion Usuario-item


    @ManyToMany(mappedBy = "items", cascade = CascadeType.PERSIST)
    private List<User> users;


    //Relacion composicion con Lista de Order
    @OneToMany(mappedBy = "itemId",cascade = CascadeType.ALL)
    private List<Order> Orders;

    public ItemInfo() {
    }


}
