/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.hospital.v1.service.PacienteService;
import com.hospital.v1.domain.Paciente;
import com.hospital.v1.service.PacienteNacionalidadService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacService;
    
    @Autowired
    private PacienteNacionalidadService pacNacService;

    @GetMapping("/")
    public String listAll(Model model) {
        var Pacientes = pacService.getPacientes();
        var PacNac = pacNacService.getPacientes();
        model.addAttribute("activePage", "paciente");
        model.addAttribute("Pacientes", Pacientes);
        return "paciente";
    }
    
    @RequestMapping("/{cedPaciente}")
    public String getPacienteDetails(@PathVariable("cedPaciente") Long cedPaciente, Model model){
        var Pac = pacService.getPacienteByCedPaciente(cedPaciente);
        
        System.out.println(Pac.getCedPaciente());
        model.addAttribute("Pacientes",Pac);
        return "paciente";
    }
    
    @PostMapping("/guardar")
    public String guardarPaciente(@ModelAttribute Paciente paciente){
        pacService.addPaciente(paciente.getCedPaciente(),
                paciente.getNomPaciente(),
                paciente.getFechaNacimiento(),
                paciente.getEdad(),
                paciente.getGenero());
        return "redirect:/paciente/";
    }

    
    @PostMapping("/actualizar")
    public String actualizarPaciente(@ModelAttribute Paciente paciente){
        System.out.println(paciente.getNomPaciente());
        pacService.updatePaciente(paciente.getCedPaciente(),
                paciente.getNomPaciente(),
                paciente.getFechaNacimiento(),
                paciente.getEdad(),
                paciente.getGenero());
        return "redirect:/paciente/";
    }
    
    @PostMapping("/borrar")
    public String borrarPaciente(@ModelAttribute Paciente paciente){
        pacService.deletePaciente(paciente.getCedPaciente());
        return "redirect:/paciente/";
    }
}

