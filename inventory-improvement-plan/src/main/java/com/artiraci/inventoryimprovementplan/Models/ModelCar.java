package com.artiraci.inventoryimprovementplan.Models;

import com.artiraci.inventoryimprovementplan.Enums.CarType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "model_car")
public class ModelCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_car_id")
    private Long id;

    @NotBlank(message = "Debe tener una descripcion")
    @Column(name = "model_brand")
    private String modelBrand;

    @NotBlank(message = "Debe tener una descripcion")
    @Column(name = "model_name")
    private String modelName;

    //Relacion de composicion con los Items
    @OneToMany(mappedBy = "modelCar", cascade = CascadeType.PERSIST)
    private List<ItemInfo> items;


    @Min(1900)
    @Column(name = "model_year")
    private Integer year;

    @NotNull(message = "Debe tener un tipo")
    @Enumerated(EnumType.STRING)
    @Column(name = "model_type")
    private CarType modelType;

    public ModelCar() {
    }

    public ModelCar(String modelBrand, String modelName, List<ItemInfo> items, Integer year, CarType modelType) {
        this.modelBrand = modelBrand;
        this.modelName = modelName;
        this.items = items;
        this.year = year;
        this.modelType = modelType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelBrand() {
        return modelBrand;
    }

    public void setModelBrand(String modelBrand) {
        this.modelBrand = modelBrand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public List<ItemInfo> getItems() {
        return items;
    }

    public void setItems(List<ItemInfo> items) {
        this.items = items;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public CarType getModelType() {
        return modelType;
    }

    public void setModelType(CarType modelType) {
        this.modelType = modelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelCar modelCar = (ModelCar) o;
        return Objects.equals(id, modelCar.id) && Objects.equals(modelBrand, modelCar.modelBrand) && Objects.equals(modelName, modelCar.modelName) && Objects.equals(items, modelCar.items) && Objects.equals(year, modelCar.year) && modelType == modelCar.modelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelBrand, modelName, items, year, modelType);
    }

    @Override
    public String toString() {
        return "ModelCar{" +
                "id=" + id +
                ", modelBrand='" + modelBrand + '\'' +
                ", modelName='" + modelName + '\'' +
                ", items=" + items +
                ", year=" + year +
                ", modelType=" + modelType +
                '}';
    }
}