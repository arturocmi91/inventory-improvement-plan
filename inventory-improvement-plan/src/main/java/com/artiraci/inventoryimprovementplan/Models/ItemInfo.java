package com.artiraci.inventoryimprovementplan.Models;


import com.artiraci.inventoryimprovementplan.Enums.ItemStatus;
import com.artiraci.inventoryimprovementplan.Enums.QualityItem;
import com.artiraci.inventoryimprovementplan.Models.Orders.Order;
import com.artiraci.inventoryimprovementplan.Models.Users.Adm;
import com.artiraci.inventoryimprovementplan.Models.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.Objects;
@JsonPropertyOrder({"id", "barcode", "reference", "itemName", "category", "itemStatus", "wholesalePrice", "retailPrice", "quantityItem", "qualityItem", "quantitySet","model_car_id", "modified_by"})
@Entity
@Table(name = "item_info")
public class ItemInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @NotBlank(message = "Debe tener Referencia")
    @Column(name = "ref")
    private String reference;

    @NotNull
    @Column(name = "barcode")
    @Digits(integer = 12, fraction = 0, message = "El código de barras debe contener exactamente 12 dígitos")
    private Long barcode;

    @NotBlank(message = "Debe tener nombre/descripcion")
    @Column(name = "spare_name")
    private String itemName;

    @NotBlank(message = "Debe tener categoria")
    @Column(name = "category")
    private String category;

    //Relacion modelo con items

    @ManyToOne
    @JoinColumn(name = "model_car_id")

    private ModelCar modelCar;

    @NotNull(message = "Debe tener un status")
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "status")
    private ItemStatus itemStatus;

    @JoinColumn(name = "wholesale_price")
    private Double wholesalePrice;

    @JoinColumn(name = "retail_price")
    private Double retailPrice;


    @JoinColumn(name = "quantity")
    private Integer quantityItem;

    @NotNull(message = "Debe tener un tipo de calidad")
    @Enumerated(EnumType.STRING)
    @Column(name = "quality")
    private QualityItem qualityItem;

    @NotNull(message = "La cantidad de sets no puede ser nula")
    @Min(value = 1, message = "La cantidad de sets debe ser mayor que 0")
    @Column(name = "quantity_set")
    private Integer quantitySet;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private Adm modifiedBy;

  // relacion Agregacion inventario-item
   @JsonIgnore
    @ManyToMany(mappedBy = "items", cascade = CascadeType.PERSIST)
    private List<Inventory> inventories;
    // relacion Agregacion Usuario-item

    @JsonIgnore
    @ManyToMany(mappedBy = "items", cascade = CascadeType.PERSIST)
    private List<User> users;


    //Relacion composicion con Lista de Order
    @JsonIgnore
    @OneToMany(mappedBy = "itemId",cascade = CascadeType.ALL)
    private List<Order> Orders;

    public ItemInfo() {
    }



    public ItemInfo(String reference, Long barcode, String itemName, String category, ModelCar modelCar, ItemStatus itemStatus, Double wholesalePrice, Double retailPrice, Integer quantityItem, QualityItem qualityItem, Integer quantitySet) {
        this.reference = reference;
        this.barcode = barcode;
        this.itemName = itemName;
        this.category = category;
        this.modelCar = modelCar;
        this.itemStatus = itemStatus;
        this.wholesalePrice = wholesalePrice;
        this.retailPrice = retailPrice;
        this.quantityItem = quantityItem;
        this.qualityItem = qualityItem;
        this.quantitySet = quantitySet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ModelCar getModelCar() {
        return modelCar;
    }

    public void setModelCar(ModelCar modelCar) {
        this.modelCar = modelCar;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(Double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(Integer quantityItem) {
        this.quantityItem = quantityItem;
    }

    public QualityItem getQualityItem() {
        return qualityItem;
    }

    public void setQualityItem(QualityItem qualityItem) {
        this.qualityItem = qualityItem;
    }

    public Integer getQuantitySet() {
        return quantitySet;
    }

    public void setQuantitySet(Integer quantitySet) {
        this.quantitySet = quantitySet;
    }

    public Adm getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Adm modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Order> getOrders() {
        return Orders;
    }

    public void setOrders(List<Order> orders) {
        Orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemInfo itemInfo = (ItemInfo) o;
        return Objects.equals(id, itemInfo.id) && Objects.equals(reference, itemInfo.reference) && Objects.equals(barcode, itemInfo.barcode) && Objects.equals(itemName, itemInfo.itemName) && Objects.equals(category, itemInfo.category) && Objects.equals(modelCar, itemInfo.modelCar) && itemStatus == itemInfo.itemStatus && Objects.equals(wholesalePrice, itemInfo.wholesalePrice) && Objects.equals(retailPrice, itemInfo.retailPrice) && Objects.equals(quantityItem, itemInfo.quantityItem) && qualityItem == itemInfo.qualityItem && Objects.equals(quantitySet, itemInfo.quantitySet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reference, barcode, itemName, category, modelCar, itemStatus, wholesalePrice, retailPrice, quantityItem, qualityItem, quantitySet);
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "id=" + id +
                ", Reference='" + reference + '\'' +
                ", barcode=" + barcode +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", modelCar=" + modelCar +
                ", itemStatus=" + itemStatus +
                ", wholesalePrice=" + wholesalePrice +
                ", retailPrice=" + retailPrice +
                ", quantityItem=" + quantityItem +
                ", qualityItem=" + qualityItem +
                ", quantitySet=" + quantitySet +
                '}';
    }
}
