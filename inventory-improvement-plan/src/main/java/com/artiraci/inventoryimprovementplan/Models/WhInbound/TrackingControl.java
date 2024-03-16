package com.artiraci.inventoryimprovementplan.Models.WhInbound;

import com.artiraci.inventoryimprovementplan.Models.Orders.RequestedOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

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

    public TrackingControl() {
    }

    public TrackingControl(RequestedOrder requestedId, List<Receive> received, Integer quantityRequested, Integer quantityArrived, Integer quantityOverage, Integer quantityShortage, Integer quantityCancelled) {
        this.requestedId = requestedId;
        this.received = received;
        this.quantityRequested = quantityRequested;
        this.quantityArrived = quantityArrived;
        this.quantityOverage = quantityOverage;
        this.quantityShortage = quantityShortage;
        this.quantityCancelled = quantityCancelled;
    }

    public Long getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(Long trackingId) {
        this.trackingId = trackingId;
    }

    public RequestedOrder getRequestedId() {
        return requestedId;
    }

    public void setRequestedId(RequestedOrder requestedId) {
        this.requestedId = requestedId;
    }

    public List<Receive> getReceived() {
        return received;
    }

    public void setReceived(List<Receive> received) {
        this.received = received;
    }

    public Integer getQuantityRequested() {
        return quantityRequested;
    }

    public void setQuantityRequested(Integer quantityRequested) {
        this.quantityRequested = quantityRequested;
    }

    public Integer getQuantityArrived() {
        return quantityArrived;
    }

    public void setQuantityArrived(Integer quantityArrived) {
        this.quantityArrived = quantityArrived;
    }

    public Integer getQuantityOverage() {
        return quantityOverage;
    }

    public void setQuantityOverage(Integer quantityOverage) {
        this.quantityOverage = quantityOverage;
    }

    public Integer getQuantityShortage() {
        return quantityShortage;
    }

    public void setQuantityShortage(Integer quantityShortage) {
        this.quantityShortage = quantityShortage;
    }

    public Integer getQuantityCancelled() {
        return quantityCancelled;
    }

    public void setQuantityCancelled(Integer quantityCancelled) {
        this.quantityCancelled = quantityCancelled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackingControl that = (TrackingControl) o;
        return Objects.equals(trackingId, that.trackingId) && Objects.equals(requestedId, that.requestedId) && Objects.equals(received, that.received) && Objects.equals(quantityRequested, that.quantityRequested) && Objects.equals(quantityArrived, that.quantityArrived) && Objects.equals(quantityOverage, that.quantityOverage) && Objects.equals(quantityShortage, that.quantityShortage) && Objects.equals(quantityCancelled, that.quantityCancelled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackingId, requestedId, received, quantityRequested, quantityArrived, quantityOverage, quantityShortage, quantityCancelled);
    }

    @Override
    public String toString() {
        return "TrackingControl{" +
                "trackingId=" + trackingId +
                ", requestedId=" + requestedId +
                ", received=" + received +
                ", quantityRequested=" + quantityRequested +
                ", quantityArrived=" + quantityArrived +
                ", quantityOverage=" + quantityOverage +
                ", quantityShortage=" + quantityShortage +
                ", quantityCancelled=" + quantityCancelled +
                '}';
    }
}
