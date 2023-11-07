package br.com.fiap.AgroAID.controller;
import br.com.fiap.AgroAID.model.CityRequest;
import br.com.fiap.AgroAID.repository.WeatherRepository;
import jakarta.validation.ConstraintViolationException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/clima")
public class WeatherAPI {

    @Autowired
    WeatherRepository service;

    @Autowired
    MessageSource message;

    private OWM owm = new OWM("c0f79194c5cdfe6db72de0f4c5e49855");

    Logger log = LoggerFactory.getLogger(WeatherAPI.class);

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user){
        model.addAttribute("username", user.getAttribute("name"));
        model.addAttribute("avatar_url", user.getAttribute("avatar_url"));
        model.addAttribute("climas", service.findAll());
        return "clima/index";
    }

    
}
