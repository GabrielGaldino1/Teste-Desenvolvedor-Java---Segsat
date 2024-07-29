package com.prova_segsat.projeto.repository;

import com.prova_segsat.projeto.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByLojaId(int lojaId);
    List<Vehicle> findByAnoModeloBetween(int startYear, int endYear);
}
