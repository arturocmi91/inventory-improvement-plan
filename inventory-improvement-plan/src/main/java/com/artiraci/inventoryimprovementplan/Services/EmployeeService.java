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

    public Inventory stowingItemInventory(InventoryDto inventoryDto)  {
        //Incializacion del Contenedor Fuente
        Inventory sourceContainer = inventoryRepository.findById(inventoryDto.getSourceInventoryId()).orElseThrow(()
                -> new  ResponseStatusException(HttpStatus.BAD_REQUEST,"La ubicación: " + "' " + inventoryDto.getSourceInventoryId() + " '" + " no existe."));
        //Incializacion del Contenedor de destino
        Inventory destinationContainer = inventoryRepository.findById(inventoryDto.getDestinationInventoryId()).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"La ubicación: " + "' " + inventoryDto.getDestinationInventoryId() + " '" + " no existe."));


        //Validacion si hay otro item con el mismo bardcode en el sourceContainer
        Long countItemsWithTheSameBardcode =sourceContainer.getItems().stream()
                .filter(item ->  item.getBarcode().equals(inventoryDto.getBarcode()))
                .count();

        if (countItemsWithTheSameBardcode >= 2){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"existen dos elementos con el mismo código de barras en el contenedor de origen. Apartar para resolver el problema.");
        }
      /**/  //Validacion del item escaneado en el sourceContainer.
        ItemInfo itemToMove = sourceContainer.getItems().stream()
                .filter(item ->  item.getBarcode().equals(inventoryDto.getBarcode()) )
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST," No esta presente en este contenedor  "));

        if (itemToMove != null) {

            itemToMove.setQuantityItem(inventoryDto.getQuantity());
           sourceContainer.getItems().remove(itemToMove);
            destinationContainer.getItems().add(itemToMove);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El artículo no existe en la base de datos");
        }


        // Actualizar el inventario en la base de datos
        inventoryRepository.saveAll(List.of(sourceContainer, destinationContainer));
        return destinationContainer;


    }


}
