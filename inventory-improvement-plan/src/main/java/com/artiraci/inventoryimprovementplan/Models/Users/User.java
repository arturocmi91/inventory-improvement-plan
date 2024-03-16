package com.artiraci.inventoryimprovementplan.Models.Users;

import com.artiraci.inventoryimprovementplan.Models.Inventory;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    protected String userName;

    @NotBlank(message = "Debe tener un email")
    protected String userEmail;

    @NotBlank(message = "Debe tener una contraseña")
    @Size(min = 8)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$")
    protected String password;

    @NotNull
    protected LocalDateTime registeredDate;

    //muestra relacion usuario-inventario.
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_inventory",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Inventory> inventories;

    //muestra relacion item-User .
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_item",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<ItemInfo> items;



    public User() {
    }

    public User(String userName, String userEmail, String password, LocalDateTime registeredDate, List<Inventory> inventories, List<ItemInfo> items) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        this.registeredDate = registeredDate;
        this.inventories = inventories;
        this.items = items;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public List<ItemInfo> getItems() {
        return items;
    }

    public void setItems(List<ItemInfo> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userName, user.userName) && Objects.equals(userEmail, user.userEmail) && Objects.equals(password, user.password) && Objects.equals(registeredDate, user.registeredDate) && Objects.equals(inventories, user.inventories) && Objects.equals(items, user.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userEmail, password, registeredDate, inventories, items);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                ", registeredDate=" + registeredDate +
                ", inventories=" + inventories +
                ", items=" + items +
                '}';
    }
}
