package com.artiraci.inventoryimprovementplan.Models;

import com.artiraci.inventoryimprovementplan.Enums.LocationType;
import com.artiraci.inventoryimprovementplan.Models.Orders.CustomerOrder;
import com.artiraci.inventoryimprovementplan.Models.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Inventory {
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

    @ManyToMany
    @JoinTable(
            name = "inventory_item",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemInfo> items;

    //Relacion Agregacion Lista de Usuarios que han utilizado el inventario.
    @JsonIgnore
    @ManyToMany(mappedBy = "inventories", cascade = CascadeType.PERSIST)
    private List<User> users;

    //Relacion Agregacion Lista de Ordenes de clientes (CustomerOrder) que estan asignadas en el Inventario.
    @JsonIgnore
    @ManyToMany(mappedBy = "allocations", cascade = CascadeType.PERSIST)
    private List<CustomerOrder>customerOrders;

    public Inventory() {
    }

    public Inventory(String inventoryId, LocalDateTime updatedDate, LocationType locationType, List<ItemInfo> items, List<User> users, List<CustomerOrder> customerOrders) {
        this.inventoryId = inventoryId;
        this.updatedDate = updatedDate;
        this.locationType = locationType;
        this.items = items;
        this.users = users;
        this.customerOrders = customerOrders;
    }

  //metodo para agragar items

    public int addItem(ItemInfo item, Integer qty){

        if(items==null){
            items=new ArrayList<>();
        }

        item.setQuantityItem(qty);
        items.add(item);
        return item.getQuantityItem();

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

    public List<ItemInfo> getItems() {
        return items;
    }

    public void setItems(List<ItemInfo> items) {
        this.items = items;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(inventoryId, inventory.inventoryId) && Objects.equals(updatedDate, inventory.updatedDate) && locationType == inventory.locationType && Objects.equals(items, inventory.items) && Objects.equals(users, inventory.users) && Objects.equals(customerOrders, inventory.customerOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, updatedDate, locationType, items, users, customerOrders);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "InventoryId='" + inventoryId + '\'' +
                ", updatedDate=" + updatedDate +
                ", locationType=" + locationType +
                ", items=" + items +
                ", users=" + users +
                ", customerOrders=" + customerOrders +
                '}';
    }
}
