package com.artiraci.inventoryimprovementplan.Models.WhInbound;

import com.artiraci.inventoryimprovementplan.Models.Orders.RequestedOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public InvoiceRegister() {
    }

    public InvoiceRegister(RequestedOrder requestedId, Double itemPrice, Double subCostPrice, Double tax, Double deduction, Double total, Arrival arrivalId, LocalDateTime invoiceDate) {
        this.requestedId = requestedId;
        this.itemPrice = itemPrice;
        this.subCostPrice = subCostPrice;
        this.tax = tax;
        this.deduction = deduction;
        this.total = total;
        this.arrivalId = arrivalId;
        this.invoiceDate = invoiceDate;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public RequestedOrder getRequestedId() {
        return requestedId;
    }

    public void setRequestedId(RequestedOrder requestedId) {
        this.requestedId = requestedId;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getSubCostPrice() {
        return subCostPrice;
    }

    public void setSubCostPrice(Double subCostPrice) {
        this.subCostPrice = subCostPrice;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getDeduction() {
        return deduction;
    }

    public void setDeduction(Double deduction) {
        this.deduction = deduction;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Arrival getArrivalId() {
        return arrivalId;
    }

    public void setArrivalId(Arrival arrivalId) {
        this.arrivalId = arrivalId;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceRegister that = (InvoiceRegister) o;
        return Objects.equals(invoiceId, that.invoiceId) && Objects.equals(requestedId, that.requestedId) && Objects.equals(itemPrice, that.itemPrice) && Objects.equals(subCostPrice, that.subCostPrice) && Objects.equals(tax, that.tax) && Objects.equals(deduction, that.deduction) && Objects.equals(total, that.total) && Objects.equals(arrivalId, that.arrivalId) && Objects.equals(invoiceDate, that.invoiceDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, requestedId, itemPrice, subCostPrice, tax, deduction, total, arrivalId, invoiceDate);
    }

    @Override
    public String toString() {
        return "InvoiceRegister{" +
                "invoiceId=" + invoiceId +
                ", requestedId=" + requestedId +
                ", itemPrice=" + itemPrice +
                ", subCostPrice=" + subCostPrice +
                ", tax=" + tax +
                ", deduction=" + deduction +
                ", total=" + total +
                ", arrivalId=" + arrivalId +
                ", invoiceDate=" + invoiceDate +
                '}';
    }
}
