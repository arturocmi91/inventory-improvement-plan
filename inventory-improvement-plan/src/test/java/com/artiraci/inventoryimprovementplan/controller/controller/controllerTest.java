package com.artiraci.inventoryimprovementplan.controller.controller;

import com.artiraci.inventoryimprovementplan.Enums.CarType;
import com.artiraci.inventoryimprovementplan.Enums.ItemStatus;
import com.artiraci.inventoryimprovementplan.Enums.QualityItem;
import com.artiraci.inventoryimprovementplan.Models.Inventory;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.artiraci.inventoryimprovementplan.Models.ModelCar;
import com.artiraci.inventoryimprovementplan.Repositories.InventoryRepository;
import com.artiraci.inventoryimprovementplan.Repositories.ItemInfoRepository;
import com.artiraci.inventoryimprovementplan.Repositories.ModelCarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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
    InventoryRepository inventoryRepository;
    ModelCarRepository modelCarRepository;

    List<ItemInfo> items = new ArrayList<>();
    List<Inventory> inventories = new ArrayList<>();
    List<ModelCar> cars = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        ModelCar car1;
        ModelCar car2;

        cars= modelCarRepository.saveAll(List.of(
                car1=new ModelCar("Cherry","TiggoV7",null,2018, CarType.Pick_up),
                car2=new ModelCar("Cherry","TiggoSedanJo",null,2021, CarType.Sedan)
        ));


        ItemInfo bujia;
        ItemInfo amortiguador;
        ItemInfo luces;


        items = itemInfoRepository.saveAll(List.of(
                bujia = new ItemInfo("PPT", 10043200L, "bujias 2*2", "Bujias", car1, ItemStatus.Disponible, 23.00, 25.00, 12, QualityItem.Generico, 2),
                amortiguador = new ItemInfo("K001", 10023400L, "Amortiguador trasero", "Amortiguadores", car2, ItemStatus.Disponible, 43.00, 45.00, 12, QualityItem.Generico, 2)
        ));


    }
}
