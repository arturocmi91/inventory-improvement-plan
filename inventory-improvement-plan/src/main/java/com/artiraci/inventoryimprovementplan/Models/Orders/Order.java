package com.artiraci.inventoryimprovementplan.Models.Orders;

import com.artiraci.inventoryimprovementplan.Models.Customer;
import com.artiraci.inventoryimprovementplan.Models.Users.Adm;

import com.artiraci.inventoryimprovementplan.Models.ItemInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bussines_order")
@Inheritance(strategy = InheritanceType.JOINED)
public class Order {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

   //Rel Comp Item Asignado para esta Orden
   @ManyToOne
   @JoinColumn(name="item_id")
    private ItemInfo itemId;

   //Rel Comp Customer Dueño  de la Orden
    @ManyToOne
    @JoinColumn(name="Owner")
    private Customer customerId;

    @NotNull(message = "La cantidad de articulo no puede ser nula")
    @Min(value = 1, message = "Tiene que haber al menos 1 articulo")
    private Integer quantityItem;

    @NotNull
    @PastOrPresent
    private LocalDateTime joinTime;

    //Rel Agregacion Modificado, revisado por Adm
    @ManyToOne
    @JoinColumn(name="updated_by")
    private Adm actionsBy;

    public Order() {
    }

    public Order(ItemInfo itemId, Customer customerId, Integer quantityItem, LocalDateTime joinTime, Adm actionsBy) {
        this.itemId = itemId;
        this.customerId = customerId;
        this.quantityItem = quantityItem;
        this.joinTime = joinTime;
        this.actionsBy = actionsBy;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public ItemInfo getItemId() {
        return itemId;
    }

    public void setItemId(ItemInfo itemId) {
        this.itemId = itemId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Integer getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(Integer quantityItem) {
        this.quantityItem = quantityItem;
    }

    public LocalDateTime getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(LocalDateTime joinTime) {
        this.joinTime = joinTime;
    }

    public Adm getActionsBy() {
        return actionsBy;
    }

    public void setActionsBy(Adm actionsBy) {
        this.actionsBy = actionsBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(itemId, order.itemId) && Objects.equals(customerId, order.customerId) && Objects.equals(quantityItem, order.quantityItem) && Objects.equals(joinTime, order.joinTime) && Objects.equals(actionsBy, order.actionsBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, itemId, customerId, quantityItem, joinTime, actionsBy);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", itemId=" + itemId +
                ", customerId=" + customerId +
                ", quantityItem=" + quantityItem +
                ", joinTime=" + joinTime +
                ", actionsBy=" + actionsBy +
                '}';
    }
}
