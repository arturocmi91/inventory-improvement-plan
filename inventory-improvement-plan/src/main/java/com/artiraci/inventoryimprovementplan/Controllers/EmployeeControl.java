package com.artiraci.inventoryimprovementplan.Controllers;

import com.artiraci.inventoryimprovementplan.Models.Inventory;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.artiraci.inventoryimprovementplan.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/employee")
public class EmployeeControl {
    @Autowired
    EmployeeService employeeService;


//<<Metodos Get>>

    //Mostrar todos los items .

    @GetMapping(value = "/items")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemInfo> GetAllItems(){
        return employeeService.showAllItems();}

//Mostrar todos los items por Ubicación.
  /*  @GetMapping(value = "/Locations/{inventoryId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemInfo> GetItemsByLocation(@PathVariable String inventoryId){
return employeeService.showAllItemByInventoryId(inventoryId);}*/

}
