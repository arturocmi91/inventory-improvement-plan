package com.artiraci.inventoryimprovementplan.Models;


import com.artiraci.inventoryimprovementplan.Enums.CarType;
import com.artiraci.inventoryimprovementplan.Enums.QualityItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
@Table(name = "item_info")
public class ItemInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @NotBlank(message = "Debe tener Referencia")
    @Column(name = "ref")
    private String Refence;

    @NotNull
    @Column(name = "barcode")
    @Pattern(regexp = "\\d{12}", message = "El código de barras no valido")
    private Long barcode;

    @NotBlank(message = "Debe tener nombre/descripcion")
    @Column(name = "spare_name")
    private String itemName;

    @NotBlank(message = "Debe tener categoria")
    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "model_car_id")

    private ModelCar modelCar;

    @NotNull(message ="Debe tener un tipo de calidad")
    @Enumerated(EnumType.STRING)
    @Column(name = "quality")
    private QualityItem qualityItem;

    @NotNull(message = "La cantidad de sets no puede ser nula")
    @Min(value = 1, message = "La cantidad de sets debe ser mayor que 0")
    @Column(name = "quantity_set")
    private Integer quantitySet;

    public ItemInfo() {
    }

    public ItemInfo(String refence, Long barcode, String itemName, String category, ModelCar modelCar, QualityItem qualityItem, Integer quantitySet) {
        Refence = refence;
        this.barcode = barcode;
        this.itemName = itemName;
        this.category = category;
        this.modelCar = modelCar;
        this.qualityItem = qualityItem;
        this.quantitySet = quantitySet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefence() {
        return Refence;
    }

    public void setRefence(String refence) {
        Refence = refence;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemInfo itemInfo = (ItemInfo) o;
        return Objects.equals(id, itemInfo.id) && Objects.equals(Refence, itemInfo.Refence) && Objects.equals(barcode, itemInfo.barcode) && Objects.equals(itemName, itemInfo.itemName) && Objects.equals(category, itemInfo.category) && Objects.equals(modelCar, itemInfo.modelCar) && qualityItem == itemInfo.qualityItem && Objects.equals(quantitySet, itemInfo.quantitySet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Refence, barcode, itemName, category, modelCar, qualityItem, quantitySet);
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "id=" + id +
                ", Refence='" + Refence + '\'' +
                ", barcode=" + barcode +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", modelCar=" + modelCar +
                ", qualityItem=" + qualityItem +
                ", quantitySet=" + quantitySet +
                '}';
    }
}
