package com.artiraci.inventoryimprovementplan.Models.Users;

import com.artiraci.inventoryimprovementplan.Models.Inventory;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.artiraci.inventoryimprovementplan.Models.Users.Adm;
import com.artiraci.inventoryimprovementplan.Models.Users.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee extends User {

    @NotBlank(message = "Debe tener un cargo")
    private  String role;

   // Relacion Agregacion con Adm MANAGER ASIGNADO
    @ManyToOne
    @JoinColumn(name = "manager")
    private Adm manager;/**/

    public Employee() {
    }

    public Employee(String userName, String userEmail, String password, LocalDateTime registeredDate, List<Inventory> inventories, List<ItemInfo> items, String role, Adm manager) {
        super(userName, userEmail, password, registeredDate, inventories, items);
        this.role = role;
        this.manager = manager;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Adm getManager() {
        return manager;
    }

    public void setManager(Adm manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(role, employee.role) && Objects.equals(manager, employee.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), role, manager);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "role='" + role + '\'' +
                ", manager=" + manager +
                '}';
    }
}
