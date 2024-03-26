package com.artiraci.inventoryimprovementplan.controller;

import com.artiraci.inventoryimprovementplan.DTO.InventoryDto;
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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        Inventory rack2;
        Inventory problemCont;

        inventories = inventoryRepository.saveAll(List.of(
                rack1 = new Inventory("QR001", LocalDateTime.of(2024, 1, 5, 8, 1, 25), LocationType.Container, null, null, null),
                rack2 = new Inventory("QR002", LocalDateTime.of(2024, 1, 5, 8, 1, 25), LocationType.Container, null, null, null),


                problemCont = new Inventory("PQ001", LocalDateTime.of(2024, 1, 9, 1, 1, 25), LocationType.Damaged_Container, null, null, null)
        ));

        //Asignacion  para el rack1

        bujia.setQuantityItem(10);
        rack1.addItem(bujia, 10);

        amortiguador.setQuantityItem(2);
        rack1.addItem(amortiguador, 1);

        //Asignacion  para el rack1

        bujia.setQuantityItem(2);
        problemCont.addItem(bujia, 2);
        System.out.println(rack1);
        luz1.setQuantityItem(10);
        problemCont.addItem(luz1, 10);



        inventories = inventoryRepository.saveAll(List.of(rack1, problemCont));


    }

    @AfterEach
    void tearDown() {
        inventoryRepository.deleteAll();
        itemInfoRepository.deleteAll();
        modelCarRepository.deleteAll();

    }

    //Test Unitario del metodo de Inventory addItems
    @Test
    void shouldAddItemInContainer() {

        ModelCar cherry = new ModelCar("Cherry", "TiggoXD", 2018, CarType.Pick_up);
        //modelCarRepository.save(cherry);
        ItemInfo item1 = new ItemInfo("2DD", 100232000L, "Meseta 2*2", "Meseta", cherry, ItemStatus.Disponible, 23.00, 25.00, 5, QualityItem.Generico, 2);
        Inventory rack2 = new Inventory("QR002", LocalDateTime.of(2024, 1, 5, 8, 1, 25), LocationType.Container, null, null, null);

        item1.setQuantityItem(2);
        rack2.addItem(item1, 2);


        assertEquals(2, rack2.addItem(item1, 2));

    }
//-------------------------------------------- Test GET method-----------------------------------------------------------
    //EMPLOYEE>>>> Test GET All ITEMS
    @Test
    void shouldReturnAllItems_whenGetMethodsIsCalled() throws Exception {
        MvcResult result = mockMvc.perform(get("/employee/item/all-items"))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("bujias 2*2"));

    }

    //-------------------------------------------- Test POST method-----------------------------------------------------------
    //EMPLOYEE>>>> Test Post Agregar Articulo
    @Test
    void shouldAddItemToInventory_WhenPostMethodIsCalled() throws Exception {
        ModelCar carroChino = new ModelCar("Cherry", "TiggoV7", 2018, CarType.Pick_up);
         cars= modelCarRepository.saveAll(List.of(carroChino));

         ItemInfo item3  = new ItemInfo("2DD", 100542000L, "Meseta 2*2", "Meseta",carroChino, ItemStatus.Disponible, 23.00, 25.00, 2, QualityItem.Original, 2);
         ItemInfo item4  = new ItemInfo("2DDP", 100542000L, "Meseta 2*2", "Meseta",carroChino, ItemStatus.Disponible, 23.00, 25.00, 2, QualityItem.Generico, 2);
        Inventory source = new Inventory("QR004", LocalDateTime.of(2024, 1, 5, 8, 1, 25), LocationType.Container, null, null, null);
        items = itemInfoRepository.saveAll(List.of(item3));
        item3.setQuantityItem(2);
        source.addItem(item3, 2);
        Inventory destination = new Inventory("QR005", LocalDateTime.of(2024, 1, 5, 8, 1, 25), LocationType.Container, null, null, null);
        inventories = inventoryRepository.saveAll(List.of(source, destination));
        System.out.println(source);

        System.out.println(destination);



        InventoryDto location= new InventoryDto();
                location.setSourceInventoryId("QR004" +
                        "");
                location.setDestinationInventoryId("QR005");
                location.setBarcode(100542000L);
                location.setQuantity(2);

        String body = objectMapper.writeValueAsString(location);
        MvcResult result = mockMvc.perform(post("/employee/acción/ubicar")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }


}

