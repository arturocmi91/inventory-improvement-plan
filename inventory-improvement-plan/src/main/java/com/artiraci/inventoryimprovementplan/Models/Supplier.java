package com.artiraci.inventoryimprovementplan.Models;

import com.artiraci.inventoryimprovementplan.Models.Orders.RequestedOrder;
import com.artiraci.inventoryimprovementplan.Models.Users.Adm;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @NotNull(message = "Debe tener un Identificador de Proveedor")
    @Column(name = "supplier_id")

    private String id;


    @Column(name = "supplier_name")
    private String supplierName;

    @NotBlank(message = "Debe tener un email")
    @Column(name = "email")

    private String supplierEmail;

    @NotNull
    @PastOrPresent
    @Column(name = "join_date")

    private LocalDateTime joinDate;

    //Rel Comp entre muchos pedidos y un proveedor.

    @OneToMany(mappedBy = "supplierId", cascade = CascadeType.ALL)
    private List<RequestedOrder> requestedOrders;
    // Relacion Agregacion con Adm que agrego al proveedor
    @ManyToOne
    @JoinColumn(name = "assigned_id")
    private Adm assignedBy;

    public Supplier() {
    }

    public Supplier(String supplierName, String supplierEmail, LocalDateTime joinDate, List<RequestedOrder> requestedOrders, Adm assignedBy) {
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.joinDate = joinDate;
        this.requestedOrders = requestedOrders;
        this.assignedBy = assignedBy;
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

    public List<RequestedOrder> getRequestedOrders() {
        return requestedOrders;
    }

    public void setRequestedOrders(List<RequestedOrder> requestedOrders) {
        this.requestedOrders = requestedOrders;
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
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id) && Objects.equals(supplierName, supplier.supplierName) && Objects.equals(supplierEmail, supplier.supplierEmail) && Objects.equals(joinDate, supplier.joinDate) && Objects.equals(requestedOrders, supplier.requestedOrders) && Objects.equals(assignedBy, supplier.assignedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supplierName, supplierEmail, joinDate, requestedOrders, assignedBy);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id='" + id + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", supplierEmail='" + supplierEmail + '\'' +
                ", joinDate=" + joinDate +
                ", requestedOrders=" + requestedOrders +
                ", assignedBy=" + assignedBy +
                '}';
    }
}
