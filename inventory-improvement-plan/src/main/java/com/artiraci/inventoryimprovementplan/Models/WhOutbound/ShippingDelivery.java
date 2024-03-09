package com.artiraci.inventoryimprovementplan.Models.WhOutbound;

import com.artiraci.inventoryimprovementplan.Enums.ShippingStatus;
import com.artiraci.inventoryimprovementplan.Models.Orders.CustomerOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

@Entity
public class ShippingDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingId;


    //Relacion Composicion de muchos envios con las ordenes de clientes
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private CustomerOrder assignedTo;

    @NotNull(message = "Debe la Orden de carga tener un estatus")
    @Enumerated(EnumType.STRING)
    private ShippingStatus shippingDelivery;

    private String transportedBy;

    @NotNull
    @PastOrPresent
    private LocalDateTime joinTime;






}
