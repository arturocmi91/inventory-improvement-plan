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

    public Customer(String id, String customerName, CustomerType customerType, String customerAddress, String customerEmail, LocalDateTime joinDate, List<Order> orders, Adm assignedBy) {
        this.id = id;
        this.customerName = customerName;
        this.customerType = customerType;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.joinDate = joinDate;
        this.orders = orders;
        this.assignedBy = assignedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Adm getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Adm assignedBy) {
        this.assignedBy = assignedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(customerName, customer.customerName) && customerType == customer.customerType && Objects.equals(customerAddress, customer.customerAddress) && Objects.equals(customerEmail, customer.customerEmail) && Objects.equals(joinDate, customer.joinDate) && Objects.equals(orders, customer.orders) && Objects.equals(assignedBy, customer.assignedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, customerType, customerAddress, customerEmail, joinDate, orders, assignedBy);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerType=" + customerType +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", joinDate=" + joinDate +
                ", orders=" + orders +
                ", assignedBy=" + assignedBy +
                '}';
    }
}
