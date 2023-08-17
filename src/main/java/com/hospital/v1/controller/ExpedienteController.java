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
import com.hospital.v1.domain.TelPaciente;
import com.hospital.v1.service.CitasService;
import com.hospital.v1.service.DoctorService;
import com.hospital.v1.service.PacienteService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/expediente")
public class ExpedienteController {

    @Autowired
    private ExpedienteService expedService;
    
    @Autowired
    private DoctorService docService;
    
    @Autowired
    private PacienteService pacService;
    
    @Autowired
    private CitasService citaService;

    @GetMapping("/")
    public String inicio(Model model) {
        var Expedientes = expedService.getExpedientes();
        var Doctores = docService.getDoctors();
        var Pacientes = pacService.getPacientes();
        var Citas = citaService.getCitas();
        model.addAttribute("activePage", "exped");
        model.addAttribute("Expedientes", Expedientes);
        model.addAttribute("Doctores", Doctores);
        model.addAttribute("Pacientes", Pacientes);
        model.addAttribute("Citas", Citas);
        return "expediente";
    }   

//    @PostMapping("/guardar")
//    public String guardarTelPaciente(@ModelAttribute TelPaciente telPac) {
//        System.out.println(telPacService.insertTelPaciente(telPac.getIdTelPaciente(),telPac.getPaciente().getCedPaciente() , telPac.getNumTelefono()));
//        return "redirect:/telPaciente/";
//    }
//
//    
//    @PostMapping("/actualizar")
//    public String actualizarPaciente(@ModelAttribute TelPaciente telPac){
//        telPacService.updateTelPaciente(telPac.getIdTelPaciente(), 
//                telPac.getNumTelefono());
//        return "redirect:/telPaciente/";
//    }
//    
//
//    @PostMapping("/borrar")
//    public String borrarPaciente(@ModelAttribute TelPaciente telPacario) {
//        telPacService.deleteTelPaciente(telPacario.getIdTelPaciente());
//        return "redirect:/telPacario/";
//    }

}