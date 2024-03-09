package com.artiraci.inventoryimprovementplan.Models.WhInbound;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Arrival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long arrivalId;

    //Rel Comp entre un Arrival con varios invoices
    @OneToMany(mappedBy = "arrivalId", cascade = CascadeType.ALL)
    private List<InvoiceRegister> invoiceRegisters;

    @NotBlank(message = "Debe tener un transportista")
    private String transportedBy;

    @NotNull
    @PastOrPresent
    private LocalDateTime arrivalTime;


}
