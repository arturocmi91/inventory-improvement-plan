package com.artiraci.inventoryimprovementplan.Models.WhInbound;

import com.artiraci.inventoryimprovementplan.Models.Orders.RequestedOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class TrackingControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackingId;

    //rel UNO A UNO Con Requested

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="requested_id")

    private RequestedOrder requestedId;

    //rel comp entre un track y muchos receive

    @OneToMany(mappedBy = "trackingId",cascade = CascadeType.ALL)

    private List<Receive> received;

    @NotNull(message = "La cantidad recibida no puede ser nula")
    @Min(value = 1, message = "La cantidad  recibida debe ser mayor que 0")

    private Integer quantityRequested;
    private Integer quantityArrived;
    private Integer quantityOverage;
    private Integer quantityShortage;
    private Integer quantityCancelled;


}
