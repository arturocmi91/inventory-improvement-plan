package com.artiraci.inventoryimprovementplan.Models.Orders;

import com.artiraci.inventoryimprovementplan.Models.WhInbound.Supplier;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "requested_order")
public class RequestedOrder extends Order {

    //Rel Comp entre muchos pedidos y un proveedor.
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplierId;



}
