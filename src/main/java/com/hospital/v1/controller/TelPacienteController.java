/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.hospital.v1.service.TelPacienteService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hospital.v1.domain.TelPaciente;
import com.hospital.v1.service.PacienteService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/telPaciente")
public class TelPacienteController {

    @Autowired
    private TelPacienteService telPacService;
    
    @Autowired
    private PacienteService pacService;

    @GetMapping("/")
    public String inicio(Model model) {
        var TelPacientes = telPacService.getTelPacienteDetails();
        var Pacientes = pacService.getPacientes();
        System.out.println(TelPacientes.get(0).getNumTelefono());
        model.addAttribute("activePage", "telPacs");
        model.addAttribute("telPacientes", TelPacientes);
        model.addAttribute("Pacientes", Pacientes);
        return "tel_paciente";
    }   

    @PostMapping("/guardar")
    public String guardarTelPaciente(@ModelAttribute TelPaciente telPac) {
        System.out.println(telPacService.insertTelPaciente(telPac.getIdTelPaciente(),telPac.getPaciente().getCedPaciente() , telPac.getNumTelefono()));
        return "redirect:/telPaciente/";
    }

    
    @PostMapping("/actualizar")
    public String actualizarPaciente(@ModelAttribute TelPaciente telPac){
        telPacService.updateTelPaciente(telPac.getIdTelPaciente(), 
                telPac.getNumTelefono());
        return "redirect:/telPaciente/";
    }
    

    @PostMapping("/borrar")
    public String borrarPaciente(@ModelAttribute TelPaciente telPacario) {
        telPacService.deleteTelPaciente(telPacario.getIdTelPaciente());
        return "redirect:/telPacario/";
    }

}