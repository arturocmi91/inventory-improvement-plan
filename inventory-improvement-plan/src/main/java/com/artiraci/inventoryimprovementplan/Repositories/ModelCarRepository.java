package com.artiraci.inventoryimprovementplan.Repositories;

import com.artiraci.inventoryimprovementplan.Models.ModelCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelCarRepository extends JpaRepository<ModelCar,Long> {
}
