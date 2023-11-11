package br.com.fiap.AgroAID.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.AgroAID.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    
} 
