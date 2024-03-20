package com.artiraci.inventoryimprovementplan.Controllers;

import com.artiraci.inventoryimprovementplan.Models.Inventory;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.artiraci.inventoryimprovementplan.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeControl {
    @Autowired
    EmployeeService employeeService;


//<<Metodos Get>>

    //---ITEMS---
    //Mostrar todos los items.

    @GetMapping(value = "/item/all-items")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemInfo> GetAllItems() {
        return employeeService.showAllItems();
    }

    //Mostrar items  por ref en caso de estar duplicado

    @GetMapping(value = "/item/reference/{reference}")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemInfo> GetReference(@PathVariable String reference) {
        return employeeService.showAllRef(reference);
    }


    //Mostrar contenido del Inventario
    @GetMapping(value = "/item/inventory/{inventoryId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemInfo> GetItemsByLocation(@PathVariable String inventoryId) {
        return employeeService.showAllItemByInventoryId(inventoryId);
    }

    //---INVENTARIO---

    
}
