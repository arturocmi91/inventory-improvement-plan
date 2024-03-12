package com.artiraci.inventoryimprovementplan.Models.Orders;

import com.artiraci.inventoryimprovementplan.Enums.RequestStatus;
import com.artiraci.inventoryimprovementplan.Models.Customer;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.artiraci.inventoryimprovementplan.Models.Users.Adm;
import com.artiraci.inventoryimprovementplan.Models.WhInbound.Supplier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "requested_order")
public class RequestedOrder extends Order {

    @NotNull(message = "Debe tener un campo")
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;


    //Rel Comp entre muchos pedidos y un proveedor.
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplierId;

    public RequestedOrder() {
    }

    public RequestedOrder(ItemInfo itemId, Customer customerId, Integer quantityItem, LocalDateTime joinTime, Adm actionsBy, RequestStatus requestStatus, Supplier supplierId) {
        super(itemId, customerId, quantityItem, joinTime, actionsBy);
        this.requestStatus = requestStatus;
        this.supplierId = supplierId;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RequestedOrder that = (RequestedOrder) o;
        return requestStatus == that.requestStatus && Objects.equals(supplierId, that.supplierId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), requestStatus, supplierId);
    }

    @Override
    public String toString() {
        return "RequestedOrder{" +
                "requestStatus=" + requestStatus +
                ", supplierId=" + supplierId +
                '}';
    }
}
