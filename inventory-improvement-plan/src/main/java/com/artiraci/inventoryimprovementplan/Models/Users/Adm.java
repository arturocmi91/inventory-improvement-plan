package com.artiraci.inventoryimprovementplan.Models.Users;

import com.artiraci.inventoryimprovementplan.Models.Customer;

import com.artiraci.inventoryimprovementplan.Models.Inventory;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.artiraci.inventoryimprovementplan.Models.Orders.Order;
import com.artiraci.inventoryimprovementplan.Models.Supplier;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "manager")

public class Adm extends User {

    @NotBlank(message = "Debe tener un cargo")
    private String admRole;

    //Relacion Agregacion Lista de empleados asignados o revisados.
    @OneToMany(mappedBy = "manager", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Employee> employees;

    //Relacion Agregacion Lista de items revisados o modificados.

    @OneToMany(mappedBy = "modifiedBy", cascade = CascadeType.PERSIST)
    private List<ItemInfo> items;

    //Relacion Agregacion Lista de Ordenes revisados o modificados.

    @OneToMany(mappedBy = "actionsBy", cascade = CascadeType.PERSIST)
    private List<Order> orders;

    //Relacion Agregacion lista de clientes Asignados.
    @OneToMany(mappedBy = "assignedBy", cascade = CascadeType.PERSIST)
    private List<Customer> customers;

    //Relacion Agregacion lista de proveedores Asignados.
    @OneToMany(mappedBy = "assignedBy", cascade = CascadeType.PERSIST)
    private List<Supplier> suppliers;

    public Adm() {
    }

    public Adm(String userName, String userEmail, String password, LocalDateTime registeredDate, List<Inventory> inventories, List<ItemInfo> items, String admRole, List<Employee> employees, List<ItemInfo> items1, List<Order> orders, List<Customer> customers, List<Supplier> suppliers) {
        super(userName, userEmail, password, registeredDate, inventories, items);
        this.admRole = admRole;
        this.employees = employees;
        this.items = items1;
        this.orders = orders;
        this.customers = customers;
        this.suppliers = suppliers;
    }


    public String getAdmRole() {
        return admRole;
    }

    public void setAdmRole(String admRole) {
        this.admRole = admRole;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public List<ItemInfo> getItems() {
        return items;
    }

    @Override
    public void setItems(List<ItemInfo> items) {
        this.items = items;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Adm adm = (Adm) o;
        return Objects.equals(admRole, adm.admRole) && Objects.equals(employees, adm.employees) && Objects.equals(items, adm.items) && Objects.equals(orders, adm.orders) && Objects.equals(customers, adm.customers) && Objects.equals(suppliers, adm.suppliers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), admRole, employees, items, orders, customers, suppliers);
    }

    @Override
    public String toString() {
        return "Adm{" +
                "admRole='" + admRole + '\'' +
                ", employees=" + employees +
                ", items=" + items +
                ", orders=" + orders +
                ", customers=" + customers +
                ", suppliers=" + suppliers +
                '}';
    }
}
