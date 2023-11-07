package br.com.fiap.AgroAID.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class CityRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cidade;

    // Getter e Setter para cidade
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
