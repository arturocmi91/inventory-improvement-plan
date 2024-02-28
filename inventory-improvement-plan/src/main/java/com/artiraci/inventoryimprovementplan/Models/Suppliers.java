package com.artiraci.inventoryimprovementplan.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "suppliers")
public class Suppliers {

    @Id
    @NotBlank
    @Column(name = "supplier_id")

    private String id;

    @NotBlank
    @Column(name = "supplier_name")

    private String supplierName;

    @NotBlank
    @Column(name = "email")

    private String supplierEmail;

    @NotNull
    @PastOrPresent
    @Column(name = "join_date")

    private LocalDateTime joinDate;

    public Suppliers() {
    }

    public Suppliers(String id, String supplierName, String supplierEmail, LocalDateTime joinDate) {
        this.id = id;
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.joinDate = joinDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
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
        Suppliers suppliers = (Suppliers) o;
        return Objects.equals(id, suppliers.id) && Objects.equals(supplierName, suppliers.supplierName) && Objects.equals(supplierEmail, suppliers.supplierEmail) && Objects.equals(joinDate, suppliers.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supplierName, supplierEmail, joinDate);
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "id='" + id + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", supplierEmail='" + supplierEmail + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }
}
