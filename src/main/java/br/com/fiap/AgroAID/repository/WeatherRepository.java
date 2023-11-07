package br.com.fiap.AgroAID.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.AgroAID.model.CityRequest;


public interface WeatherRepository extends JpaRepository<CityRequest, Long>{
    
}
