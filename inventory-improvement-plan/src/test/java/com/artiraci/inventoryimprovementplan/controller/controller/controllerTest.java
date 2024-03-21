package com.artiraci.inventoryimprovementplan.controller.controller;

import com.artiraci.inventoryimprovementplan.Enums.CarType;
import com.artiraci.inventoryimprovementplan.Enums.ItemStatus;
import com.artiraci.inventoryimprovementplan.Enums.LocationType;
import com.artiraci.inventoryimprovementplan.Enums.QualityItem;
import com.artiraci.inventoryimprovementplan.Models.Inventory;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.artiraci.inventoryimprovementplan.Models.ModelCar;
import com.artiraci.inventoryimprovementplan.Repositories.InventoryRepository;
import com.artiraci.inventoryimprovementplan.Repositories.ItemInfoRepository;
import com.artiraci.inventoryimprovementplan.Repositories.ModelCarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class controllerTest {

    /*Para falsear una llamada de la API se usa:*/
    //Nos da la instancia de la aplicacion
    @Autowired
    private WebApplicationContext webApplicationContext;
    // Nos permite falsear llamadas
    private MockMvc mockMvc;
    // Nos permite convertir objetos a Json
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    ItemInfoRepository itemInfoRepository;
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    ModelCarRepository modelCarRepository;

    List<ItemInfo> items = new ArrayList<>();
    List<Inventory> inventories = new ArrayList<>();
    List<ModelCar> cars = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        ModelCar car1;
        ModelCar car2;

        cars = modelCarRepository.saveAll(List.of(
                car1 = new ModelCar("Cherry", "TiggoV7", 2018, CarType.Pick_up),
                car2 = new ModelCar("Cherry", "TiggoSedanJo", 2021, CarType.Sedan)
        ));


        ItemInfo bujia;
        ItemInfo amortiguador;
        ItemInfo luz1;


        items = itemInfoRepository.saveAll(List.of(
                bujia = new ItemInfo("0PT", 100432000L, "bujias 2*2", "Bujias", car1, ItemStatus.Disponible, 23.00, 25.00, 12, QualityItem.Generico, 2),
                amortiguador = new ItemInfo("K001", 100532000L, "Amortiguador trasero", "Amortiguadores", car2, ItemStatus.Disponible, 43.00, 45.00, 2, QualityItem.Generico, 2),
                luz1 = new ItemInfo("LU01", 100632000L, "Luces delantera", "Luces", car2, ItemStatus.Disponible, 12.00, 18.00, 15, QualityItem.Original, 2)
        ));

        Inventory rack1;
        Inventory problemCont;

        inventories = inventoryRepository.saveAll(List.of(
                rack1 = new Inventory("QR01", LocalDateTime.of(2024, 1, 5, 8, 1, 25), LocationType.Container, null, null, null),
                problemCont = new Inventory("PQR01", LocalDateTime.of(2024, 1, 9, 1, 1, 25), LocationType.Damaged_Container, null, null, null)
        ));

        //Asignacion PICK para el rack1

        bujia.setQuantityItem(10);
        rack1.addItem(bujia, 10);

        amortiguador.setQuantityItem(2);
        rack1.addItem(amortiguador, 1);

        //Asignacion PICK para el rack1

        bujia.setQuantityItem(2);
        problemCont.addItem(bujia, 2);

        luz1.setQuantityItem(15);
        problemCont.addItem(luz1, 15);

        inventories = inventoryRepository.saveAll(List.of(rack1,problemCont));



    }
    @Test
    void updateDb(){}

}
