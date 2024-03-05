package com.artiraci.inventoryimprovementplan.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "employees")
public class Employee extends User{

    @NotBlank(message = "Debe tener un cargo")
    private  String role;
    @ManyToOne
    @JoinColumn(name = "manager")
    private Adm manager;/**/


}
