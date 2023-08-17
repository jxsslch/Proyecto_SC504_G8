/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.controller;

import com.hospital.v1.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hospital.v1.service.PacienteService;
import com.hospital.v1.service.TratamientoService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/tratamiento")
public class TratamientoController {

    @Autowired
    private TratamientoService tratService;
    
    @Autowired
    private PacienteService pacService;
    
    @Autowired
    private DoctorService docService;
    

    @GetMapping("/")
    public String inicio(Model model) {
        var Tratamientos = tratService.getTratamientos();
        var Pacientes = pacService.getPacientes();
        var Doctores = docService.getDoctors();
        model.addAttribute("activePage", "trat");
        model.addAttribute("Tratamientos", Tratamientos);
        model.addAttribute("Pacientes", Pacientes);
        model.addAttribute("Doctores", Doctores);
        return "tratamiento";
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