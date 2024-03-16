package com.artiraci.inventoryimprovementplan.Services;

import com.artiraci.inventoryimprovementplan.Models.Inventory;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.artiraci.inventoryimprovementplan.Repositories.InventoryRepository;
import com.artiraci.inventoryimprovementplan.Repositories.ItemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    ItemInfoRepository itemInfoRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    public List<ItemInfo> showAllItems() {
        return itemInfoRepository.findAll();
    }


    public List<ItemInfo> showAllRef(String reference) {
        return  itemInfoRepository.findItemInfoByReference( reference);
    }
}
