/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.hospital.v1.service.TelDoctorService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hospital.v1.domain.TelDoctor;
import com.hospital.v1.service.DoctorService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/telDoctor")
public class TelDoctorController {

    @Autowired
    private TelDoctorService telDocService;
    
    @Autowired
    private DoctorService docService;

    @GetMapping("/")
    public String inicio(Model model) {
        var TelDoctors = telDocService.getTelDoctorDetails();
        var Doctores = docService.getDoctors();
        model.addAttribute("activePage", "telDocs");
        model.addAttribute("telDoctors", TelDoctors);
        model.addAttribute("Doctores", Doctores);
        return "tel_doctor";
    }   

    @PostMapping("/guardar")
    public String guardarTelDoctor(@ModelAttribute TelDoctor telDoc) {
        System.out.println(telDocService.insertTelDoctor(telDoc.getIdTelDoctor(),telDoc.getDoctor().getCeddoctor() , telDoc.getNumTelefono()));
        return "redirect:/telDoctor/";
    }

    
    @PostMapping("/actualizar")
    public String actualizarDoctor(@ModelAttribute TelDoctor telDoc){
        telDocService.updateTelDoctor(telDoc.getIdTelDoctor(), 
                telDoc.getNumTelefono());
        return "redirect:/telDoctor/";
    }
    

    @PostMapping("/borrar")
    public String borrarDoctor(@ModelAttribute TelDoctor telDocario) {
        telDocService.deleteTelDoctor(telDocario.getIdTelDoctor());
        return "redirect:/telDocario/";
    }

}