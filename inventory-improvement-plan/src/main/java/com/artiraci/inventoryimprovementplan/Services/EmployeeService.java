package com.artiraci.inventoryimprovementplan.Services;

import com.artiraci.inventoryimprovementplan.DTO.InventoryDto;
import com.artiraci.inventoryimprovementplan.Enums.ItemStatus;
import com.artiraci.inventoryimprovementplan.Models.Inventory;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.artiraci.inventoryimprovementplan.Repositories.InventoryRepository;
import com.artiraci.inventoryimprovementplan.Repositories.ItemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    ItemInfoRepository itemInfoRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    //<<<ITEMS SERVICE>>>

    public List<ItemInfo> showAllItems() {
        return itemInfoRepository.findAll();
    }


    public List<ItemInfo> showAllRef(String reference) {
        return itemInfoRepository.findItemInfoByReference(reference);
    }

    public List<ItemInfo> showAllItemByInventoryId(String inventoryId) {
        return itemInfoRepository.findByInventoriesInventoryId(inventoryId);
    }


    //-------Status-------

    //Disponible
    public List<ItemInfo> showAvailableStatus(ItemStatus status) {
        return itemInfoRepository.findByItemStatus(ItemStatus.Disponible);
    }

    //<<<INVENTORIES SERVICE>>>

    public List<Inventory> showAllInventory() {
        return inventoryRepository.findAll();
    }


    public Inventory showLocation(String inventoryId) {
        return inventoryRepository.findById(inventoryId).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, " La ubicacion del inventario " + "'" + inventoryId + "'" + " Es incorrecta o no existe"));
    }

    public Inventory addItemInventory(InventoryDto inventoryDto) throws IllegalAccessException {

       Inventory inventory = inventoryRepository.findById(inventoryDto.getInventoryId()).orElseThrow(()
                -> new IllegalArgumentException("La ubicación: " + "' " + inventoryDto.getInventoryId() + " '" + " no existe."));

        ItemInfo item = itemInfoRepository.findItemInfoByBarcode(inventoryDto.getBarcode())
                .stream()
                .findFirst()
                .orElse(null);

        if (item != null) {
            // Manejar la multiplicidad de elementos con el mismo código de barras
            if (inventory.getItems().contains(item)) {
                throw new IllegalStateException("El artículo ya existe en el inventario");
            }
        } else {
            throw new IllegalArgumentException("El artículo no existe en la base de datos");
        }
        item.setQuantityItem(inventoryDto.getQuantity());
        inventory.getItems().add(item);

        // Actualizar el inventario en la base de datos
        return inventoryRepository.save(inventory);


    }


}
