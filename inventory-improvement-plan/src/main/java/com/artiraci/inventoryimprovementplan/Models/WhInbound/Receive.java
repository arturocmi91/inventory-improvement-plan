package com.artiraci.inventoryimprovementplan.Models.WhInbound;

import com.artiraci.inventoryimprovementplan.Enums.ReceiveType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    public Receive() {
    }

    public Receive(InvoiceRegister invoiceRegister, Arrival arrivalId, TrackingControl trackingId, Integer quantityReceive, ReceiveType statements, LocalDateTime receiveDate) {
        this.invoiceRegister = invoiceRegister;
        this.arrivalId = arrivalId;
        this.trackingId = trackingId;
        this.quantityReceive = quantityReceive;
        this.statements = statements;
        this.receiveDate = receiveDate;
    }

    public Long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }

    public InvoiceRegister getInvoiceRegister() {
        return invoiceRegister;
    }

    public void setInvoiceRegister(InvoiceRegister invoiceRegister) {
        this.invoiceRegister = invoiceRegister;
    }

    public Arrival getArrivalId() {
        return arrivalId;
    }

    public void setArrivalId(Arrival arrivalId) {
        this.arrivalId = arrivalId;
    }

    public TrackingControl getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(TrackingControl trackingId) {
        this.trackingId = trackingId;
    }

    public Integer getQuantityReceive() {
        return quantityReceive;
    }

    public void setQuantityReceive(Integer quantityReceive) {
        this.quantityReceive = quantityReceive;
    }

    public ReceiveType getStatements() {
        return statements;
    }

    public void setStatements(ReceiveType statements) {
        this.statements = statements;
    }

    public LocalDateTime getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(LocalDateTime receiveDate) {
        this.receiveDate = receiveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receive receive = (Receive) o;
        return Objects.equals(receiveId, receive.receiveId) && Objects.equals(invoiceRegister, receive.invoiceRegister) && Objects.equals(arrivalId, receive.arrivalId) && Objects.equals(trackingId, receive.trackingId) && Objects.equals(quantityReceive, receive.quantityReceive) && statements == receive.statements && Objects.equals(receiveDate, receive.receiveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiveId, invoiceRegister, arrivalId, trackingId, quantityReceive, statements, receiveDate);
    }

    @Override
    public String toString() {
        return "Receive{" +
                "receiveId=" + receiveId +
                ", invoiceRegister=" + invoiceRegister +
                ", arrivalId=" + arrivalId +
                ", trackingId=" + trackingId +
                ", quantityReceive=" + quantityReceive +
                ", statements=" + statements +
                ", receiveDate=" + receiveDate +
                '}';
    }
}
