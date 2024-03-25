package com.artiraci.inventoryimprovementplan.DTO;

import com.artiraci.inventoryimprovementplan.Enums.LocationType;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.artiraci.inventoryimprovementplan.Models.Orders.CustomerOrder;
import com.artiraci.inventoryimprovementplan.Models.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class InventoryDto {

    @Id
    @Pattern(regexp = "[A-Za-z]{2}\\d{3}", message = "El ID del inventario debe tener dos letras seguidas de tres dígitos")
    @NotBlank(message = "Debe tener una Ubicacion")

    private String inventoryId;

    @NotNull
    @PastOrPresent
    @Column(name = "join_date")

    private LocalDateTime updatedDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Debe tener un tipo de ubicacion")

    private LocationType locationType;

    // relacion Agregacion inventario-item

    private List<Long> items;

    //Relacion Agregacion Lista de Usuarios que han utilizado el inventario.

    private List<Long> users;

    //Relacion Agregacion Lista de Ordenes de clientes (CustomerOrder) que estan asignadas en el Inventario.

    private List<Long>customerOrders;

    private Long itemId;
    private Integer quantity;

    @NotNull
    @Column(name = "barcode")
    @Digits(integer = 12, fraction = 0, message = "El código de barras debe contener exactamente 12 dígitos")
    private Long barcode;

    public InventoryDto() {
    }

    public InventoryDto(String inventoryId, LocalDateTime updatedDate, LocationType locationType, List<Long> items, List<Long> users, List<Long> customerOrders, Long itemId, Integer quantity, Long barcode) {
        this.inventoryId = inventoryId;
        this.updatedDate = updatedDate;
        this.locationType = locationType;
        this.items = items;
        this.users = users;
        this.customerOrders = customerOrders;
        this.itemId = itemId;
        this.quantity = quantity;
        this.barcode = barcode;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public List<Long> getItems() {
        return items;
    }

    public void setItems(List<Long> items) {
        this.items = items;
    }

    public List<Long> getUsers() {
        return users;
    }

    public void setUsers(List<Long> users) {
        this.users = users;
    }

    public List<Long> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<Long> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }
}
