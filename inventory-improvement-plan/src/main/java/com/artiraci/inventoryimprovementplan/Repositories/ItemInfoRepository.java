package com.artiraci.inventoryimprovementplan.Repositories;

import com.artiraci.inventoryimprovementplan.Models.Inventory;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.artiraci.inventoryimprovementplan.Models.Users.Adm;
import com.artiraci.inventoryimprovementplan.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemInfoRepository extends JpaRepository<ItemInfo, Long> {
    //Query JPA que consulta item por su nombre
    Optional<ItemInfo> findItemInfoByItemName(String itemName);
    //Query JPA que consulta lista de articulos por codigo de barra
    List<ItemInfo> findItemInfoByBarcode(Long bardcode);
    //Query JPA que consulta lista de articulos modificado por Adm
    List<ItemInfo> findItemInfoByModifiedBy(Adm modifiedBy);
    //Query JPA que consulta lista de item por inventarios
    List<ItemInfo> findByInventories(Inventory inventory);



}
