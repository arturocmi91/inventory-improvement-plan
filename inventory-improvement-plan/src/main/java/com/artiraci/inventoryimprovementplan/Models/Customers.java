package com.artiraci.inventoryimprovementplan.Models;

import com.artiraci.inventoryimprovementplan.Enums.CustomerType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "customers")

public class Customers {
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

    public Customers() {
    }

    public Customers(String id, String customerName, CustomerType customerType, String customerAddress, String customerEmail, LocalDateTime joinDate) {
        this.id = id;
        this.customerName = customerName;
        this.customerType = customerType;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.joinDate = joinDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return Objects.equals(id, customers.id) && Objects.equals(customerName, customers.customerName) && customerType == customers.customerType && Objects.equals(customerAddress, customers.customerAddress) && Objects.equals(customerEmail, customers.customerEmail) && Objects.equals(joinDate, customers.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, customerType, customerAddress, customerEmail, joinDate);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerType=" + customerType +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }
}
