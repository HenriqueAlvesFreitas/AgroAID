package br.com.fiap.AgroAID.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.AgroAID.model.Chat;
import br.com.fiap.AgroAID.service.ChatService;
import org.springframework.ui.Model;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    ChatService service;
    
    @GetMapping
    public String index(Model model, Chat chat){
        model.addAttribute("chatList", service.findAll());
        return "chat/index";
    }

    @PostMapping
    public String create(@Valid Chat chat, BindingResult result, RedirectAttributes redirect){

        if(result.hasErrors()) return "chat/index";

        service.save(chat);

        return "redirect:/chat";
    }
}
