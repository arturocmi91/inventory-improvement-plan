package com.artiraci.inventoryimprovementplan.Models.WhInbound;

import com.artiraci.inventoryimprovementplan.Enums.ReceiveType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Receive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long receiveId;

    //rel UNO A UNO Con invoice

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="invoice_register")

    private InvoiceRegister invoiceRegister;

    //rel UNO A UNO Con arrival

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="arrival_id")

    private Arrival arrivalId;

    //rel comp entre  muchos receive un tracking
    @ManyToOne
    @JoinColumn(name ="trackin_id")

    private TrackingControl trackingId;



    @NotNull(message = "La cantidad recibida no puede ser nula")
    @Min(value = 1, message = "La cantidad  recibida debe ser mayor que 0")

    private Integer quantityReceive;

    @NotNull(message = "Debe tener una sentencia ")
    @Enumerated(EnumType.STRING)
    private ReceiveType statements;

    @NotNull
    @PastOrPresent
    @Column(name = "join_date")

    private LocalDateTime receiveDate;

}
