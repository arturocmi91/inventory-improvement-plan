package com.artiraci.inventoryimprovementplan.Models.Users;

import com.artiraci.inventoryimprovementplan.Models.Users.Adm;
import com.artiraci.inventoryimprovementplan.Models.Users.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
public class Employee extends User {

    @NotBlank(message = "Debe tener un cargo")
    private  String role;

   // Relacion Agregacion con Adm MANAGER ASIGNADO
    @ManyToOne
    @JoinColumn(name = "manager")
    private Adm manager;/**/


}
