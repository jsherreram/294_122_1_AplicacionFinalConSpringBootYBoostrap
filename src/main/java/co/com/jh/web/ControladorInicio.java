/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jh.web;

import co.com.jh.service.PersonaService;
import co.com.jh.domain.Persona;
import java.util.*;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jsherreram
 */
@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        
        List<Persona> personas = (List<Persona>) personaService.listarPersonas();

        log.info("Ejecutando el controlador Spring MVC");
        log.info("Usuario que hizo login: " + user);
        model.addAttribute("personasKey", personas);    
        
        double saldoTotal = 0;
        
        for (Persona persona : personas) {
            saldoTotal += persona.getSaldo();
        }
        model.addAttribute("saldoTotalKey", saldoTotal);
        model.addAttribute("totalPersonasKey", personas.size());
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/";
    } 
    
}
