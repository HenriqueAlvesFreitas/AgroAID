package br.com.fiap.AgroAID.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.AgroAID.model.CityRequest;
import br.com.fiap.AgroAID.repository.WeatherRepository;



public class WeatherService {
    @Autowired
    WeatherRepository repository;

    public List<CityRequest> findAll(){
        return repository.findAll();
    }

    public boolean delete(Long id) {
        var task = repository.findById(id);
        if(task.isEmpty()) return false;

        repository.deleteById(id);
        return true;
    }

    public void save(CityRequest request) {
        repository.save(request);
    }
    
}
