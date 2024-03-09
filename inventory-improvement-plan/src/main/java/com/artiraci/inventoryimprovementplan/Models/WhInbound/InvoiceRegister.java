package com.artiraci.inventoryimprovementplan.Models.WhInbound;

import com.artiraci.inventoryimprovementplan.Models.Orders.RequestedOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

@Entity
public class InvoiceRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    //Rel Comp entre varios Pedidos con un Invoice
    @ManyToOne
    @JoinColumn(name = "requested_id")
    private RequestedOrder requestedId;

    private Double itemPrice;
    private Double subCostPrice;
    private Double tax;
    private Double deduction;
    private Double total;

    //Rel Comp entre varios invoice con un Arrival
    @ManyToOne
    @JoinColumn(name = "arrival_id")
    private Arrival arrivalId;

    @NotNull
    @PastOrPresent


    private LocalDateTime invoiceDate;

}
