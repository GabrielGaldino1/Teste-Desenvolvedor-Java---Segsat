package com.prova_segsat.projeto.controller;

import com.prova_segsat.projeto.model.Vehicle;
import com.prova_segsat.projeto.repository.VehicleRepository;
import com.prova_segsat.projeto.service.AdSetApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private AdSetApiService adSetApiService;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        if (vehicle.getFotos() == null) {
            vehicle.setFotos(List.of());
        }
        if (vehicle.getObservacao() == null) {
            vehicle.setObservacao("");
        }
        return vehicleRepository.save(vehicle);
    }

    
    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setMarca(vehicleDetails.getMarca());
        vehicle.setModelo(vehicleDetails.getModelo());
        vehicle.setAnoFabricacao(vehicleDetails.getAnoFabricacao());
        return vehicleRepository.save(vehicle);
    }
    @GetMapping("/{id}")
        public Vehicle getVehicleById(@PathVariable Long id) {
            return vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        }

    @PutMapping("/{id}/dados")
    public Vehicle updateVehicleData(@PathVariable Long id, @RequestBody Vehicle vehicleDetails) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setMarca(vehicleDetails.getMarca());
        vehicle.setModelo(vehicleDetails.getModelo());
        vehicle.setAnoFabricacao(vehicleDetails.getAnoFabricacao());
        return vehicleRepository.save(vehicle);
    }

    @GetMapping("/loja/{lojaId}")
    public List<Vehicle> getVehiclesByLoja(@PathVariable int lojaId) {
        return vehicleRepository.findByLojaId(lojaId);
    }

    @GetMapping("/anos")
    public List<Vehicle> getVehiclesByYearRange(@RequestParam int startYear, @RequestParam int endYear) {
        return vehicleRepository.findByAnoModeloBetween(startYear, endYear);
    }

    @GetMapping("/import")
    public String importVehiclesFromApi() {
        return adSetApiService.consumeAndStoreData();
    }
}
