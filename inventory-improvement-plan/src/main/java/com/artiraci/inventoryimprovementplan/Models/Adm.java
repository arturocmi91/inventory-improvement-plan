package com.artiraci.inventoryimprovementplan.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "manager")

public class Adm extends User{
    @OneToMany(mappedBy = "manager", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
private List<Employee>employees;

    @OneToMany(mappedBy = "modifiedBy",cascade = CascadeType.PERSIST)
    private List<ItemInfo> items;
}
