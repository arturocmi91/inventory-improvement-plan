package com.artiraci.inventoryimprovementplan.Models.Orders;

import com.artiraci.inventoryimprovementplan.Models.Customer;
import com.artiraci.inventoryimprovementplan.Models.Users.Adm;

import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

@Entity
@Table(name = "bussines_order")
@Inheritance(strategy = InheritanceType.JOINED)
public class Order {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

   //Rel Comp Item Asignado para esta Orden
   @ManyToOne
   @JoinColumn(name="item_id")
    private ItemInfo itemId;

   //Rel Comp Customer Dueño  de la Orden
    @ManyToOne
    @JoinColumn(name="Owner")
    private Customer customerId;

    @NotNull(message = "La cantidad de articulo no puede ser nula")
    @Min(value = 1, message = "Tiene que haber al menos 1 articulo")
    private Integer quantityItem;

    @NotNull
    @PastOrPresent
    private LocalDateTime joinTime;

    //Rel Agregacion Modificado, revisado por Adm
    @ManyToOne
    @JoinColumn(name="updated_by")
    private Adm actionsBy;


}
