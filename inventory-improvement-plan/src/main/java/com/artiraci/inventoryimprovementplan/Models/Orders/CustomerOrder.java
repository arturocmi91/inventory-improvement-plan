package com.artiraci.inventoryimprovementplan.Models.Orders;

import com.artiraci.inventoryimprovementplan.Enums.SaleType;
import com.artiraci.inventoryimprovementplan.Models.Customer;
import com.artiraci.inventoryimprovementplan.Models.Inventory;
import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import com.artiraci.inventoryimprovementplan.Models.Users.Adm;
import com.artiraci.inventoryimprovementplan.Models.WhOutbound.ShippingDelivery;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customer_order")
public class CustomerOrder  extends Order{

    @NotNull(message = "Debe tener un tipo de venta")
   @Enumerated(EnumType.STRING)
    private SaleType saleType;

    @NotNull(message = "Debe tener un valor")
    @DecimalMin(value = "0.0")
    private Double revenue;

    //Relacion agregacion entre Orden de Clientes y Ubicaciones en el invenatario
    @ManyToMany
    @JoinTable(
            name = "customer_Order_inventory",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_id")
    )

    //Realcion de composicion de Una Orden cliente con varias Ordenes de clientes.
    private List<Inventory> allocations;

    @OneToMany(mappedBy = "assignedTo")
 private List<ShippingDelivery> shippins;

 public CustomerOrder() {
 }

 public CustomerOrder(ItemInfo itemId, Customer customerId, Integer quantityItem, LocalDateTime joinTime, Adm actionsBy, SaleType saleType, Double revenue, List<Inventory> allocations, List<ShippingDelivery> shippins) {
  super(itemId, customerId, quantityItem, joinTime, actionsBy);
  this.saleType = saleType;
  this.revenue = revenue;
  this.allocations = allocations;
  this.shippins = shippins;
 }

 public SaleType getSaleType() {
  return saleType;
 }

 public void setSaleType(SaleType saleType) {
  this.saleType = saleType;
 }

 public Double getRevenue() {
  return revenue;
 }

 public void setRevenue(Double revenue) {
  this.revenue = revenue;
 }

 public List<Inventory> getAllocations() {
  return allocations;
 }

 public void setAllocations(List<Inventory> allocations) {
  this.allocations = allocations;
 }

 public List<ShippingDelivery> getShippins() {
  return shippins;
 }

 public void setShippins(List<ShippingDelivery> shippins) {
  this.shippins = shippins;
 }

 @Override
 public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || getClass() != o.getClass()) return false;
  if (!super.equals(o)) return false;
  CustomerOrder that = (CustomerOrder) o;
  return saleType == that.saleType && Objects.equals(revenue, that.revenue) && Objects.equals(allocations, that.allocations) && Objects.equals(shippins, that.shippins);
 }

 @Override
 public int hashCode() {
  return Objects.hash(super.hashCode(), saleType, revenue, allocations, shippins);
 }

 @Override
 public String toString() {
  return "CustomerOrder{" +
          "saleType=" + saleType +
          ", revenue=" + revenue +
          ", allocations=" + allocations +
          ", shippins=" + shippins +
          '}';
 }
}
