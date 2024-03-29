/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.hospital.v1.service.DoctorService;
import com.hospital.v1.domain.Doctor;
import com.hospital.v1.service.HorarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService docService;
    
    @Autowired
    private HorarioService horService;
    
    
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/")
    public String listAll(Model model) {
        var Doctores = docService.getDoctors();
        var Horarios = horService.getHorarios();
        model.addAttribute("activePage", "home");
        model.addAttribute("Doctores", Doctores);
        model.addAttribute("Hors", Horarios);
        
        
        return "index";
    }
    
    @RequestMapping("/{ceddoctor}")
    public String getDoctorDetails(@PathVariable("ceddoctor") Long cedDoctor, Model model){
//        System.out.println(request.getRequestURI().substring(request.getRequestURI().indexOf('/')).endsWith("/"));

        model.addAttribute("activePage", "home");
        var Doc = docService.getDoctorByCedDoctor(cedDoctor);
        
        model.addAttribute("Doctores",Doc);
        return "index";
    }
    
    @PostMapping("/guardar")
    public String guardarDoctor(@ModelAttribute Doctor doctor){
        docService.addDoctor(doctor.getCeddoctor(), 
                doctor.getPuesto(), 
                doctor.getNomdoctor(), 
                doctor.getGenero(), 
                doctor.getHorario().getIdHorario());
        return "redirect:/";
    }

    
    @PostMapping("/actualizar")
    public String actualizarDoctor(@ModelAttribute Doctor doctor){
        docService.updateDoctor(doctor.getCeddoctor(), 
                doctor.getPuesto(), 
                doctor.getNomdoctor(), 
                doctor.getGenero(), 
                doctor.getHorario().getIdHorario());
        return "redirect:/";
    }
    
    @PostMapping("/borrar")
    public String borrarDoctor(@ModelAttribute Doctor doctor){
        docService.deleteDoctor(doctor.getCeddoctor());
        return "redirect:/";
    }
    
    
    @ModelAttribute("requestURI")
    public String getContextPath() {
        return request.getRequestURI().substring(request.getRequestURI().indexOf('/'));
    }
}

