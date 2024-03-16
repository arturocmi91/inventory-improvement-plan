package com.artiraci.inventoryimprovementplan.Models.WhInbound;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    public Arrival() {
    }

    public Arrival(List<InvoiceRegister> invoiceRegisters, String transportedBy, LocalDateTime arrivalTime) {
        this.invoiceRegisters = invoiceRegisters;
        this.transportedBy = transportedBy;
        this.arrivalTime = arrivalTime;
    }

    public Long getArrivalId() {
        return arrivalId;
    }

    public void setArrivalId(Long arrivalId) {
        this.arrivalId = arrivalId;
    }

    public List<InvoiceRegister> getInvoiceRegisters() {
        return invoiceRegisters;
    }

    public void setInvoiceRegisters(List<InvoiceRegister> invoiceRegisters) {
        this.invoiceRegisters = invoiceRegisters;
    }

    public String getTransportedBy() {
        return transportedBy;
    }

    public void setTransportedBy(String transportedBy) {
        this.transportedBy = transportedBy;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arrival arrival = (Arrival) o;
        return Objects.equals(arrivalId, arrival.arrivalId) && Objects.equals(invoiceRegisters, arrival.invoiceRegisters) && Objects.equals(transportedBy, arrival.transportedBy) && Objects.equals(arrivalTime, arrival.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrivalId, invoiceRegisters, transportedBy, arrivalTime);
    }

    @Override
    public String toString() {
        return "Arrival{" +
                "arrivalId=" + arrivalId +
                ", invoiceRegisters=" + invoiceRegisters +
                ", transportedBy='" + transportedBy + '\'' +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
