/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.hospital.v1.service.ExpedienteService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hospital.v1.domain.Citas;
import com.hospital.v1.service.CitasService;
import com.hospital.v1.service.DoctorService;
import com.hospital.v1.service.PacienteService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/citas")
public class CitasController {
    
    @Autowired
    private PacienteService pacService;
    
    @Autowired
    private CitasService citaService;

    @GetMapping("/")
    public String inicio(Model model) {
        var Pacientes = pacService.getPacientes();
        var Citas = citaService.getCitas();
        model.addAttribute("activePage", "cita");
        model.addAttribute("Pacientes", Pacientes);
        model.addAttribute("Citas", Citas);
        return "citas";
    }   

    @PostMapping("/guardar")
    public String guardarCita(@ModelAttribute Citas cita) {
        System.out.println(citaService.insertarCitas(cita.getNumCita(), cita.getMotivo(), cita.getMotivo(), cita.getFecha(), cita.getHora(), cita.getPaciente().getCedPaciente()));
        return "redirect:/citas/";
    }

    
    @PostMapping("/actualizar")
    public String actualizarCitas(@ModelAttribute Citas cita){
        citaService.actualizarCitas(cita.getNumCita(), cita.getMotivo(), cita.getMotivo(), cita.getFecha(), cita.getHora(), cita.getPaciente().getCedPaciente());
        return "redirect:/telPaciente/";
    }
    



}