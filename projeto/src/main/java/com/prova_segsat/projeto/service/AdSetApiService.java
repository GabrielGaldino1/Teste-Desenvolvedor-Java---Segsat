package com.prova_segsat.projeto.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prova_segsat.projeto.model.Vehicle;
import com.prova_segsat.projeto.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Optional;

@Component
public class AdSetApiService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public String consumeAndStoreData() {
        String url = "https://www.adset.com.br/integrador/api/estoqueveiculos";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String email = "anuncios@segsat.com";
        String senha = "SeSaT%9";
        String cnpj = "21.698.946/0020-06";
        String portal = "SiteProprio";

        String payload = "\"{ 'Email': '" + email + "', 'Senha': '" + senha + "', 'CNPJ': '" + cnpj + "', 'Portal': '" + portal + "' }\"";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            HttpEntity<String> entity = new HttpEntity<>(payload, headers);

            RestTemplate restTemplate = new RestTemplate();
            

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                String responseBody = response.getBody();
                Vehicle[] vehicles = objectMapper.readValue(responseBody, Vehicle[].class);
                if (vehicles != null) {
                    for (Vehicle vehicle : vehicles) {
                        Optional<Vehicle> existingVehicle = vehicleRepository.findById(vehicle.getId());
                        if (existingVehicle.isPresent()) {
                            System.out.println("Vehicle with ID " + vehicle.getId() + " already exists. Skipping...");
                        } else {
                            vehicleRepository.save(vehicle);
                        }
                    }
                }
                return "Data imported successfully.";
            } else {
                System.out.println("Failed to fetch data from API: " + response.getStatusCode());
                return "Failed to fetch data from API: " + response.getStatusCode();
            }
        } catch (Exception e) {
            System.out.println("Error consuming API: " + e.getMessage());
            return "Error consuming API: " + e.getMessage();
        }
    }
}
