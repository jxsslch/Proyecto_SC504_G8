
package com.hospital.v1.service;

import com.hospital.v1.domain.Doctor;
import java.util.List;
import java.util.HashMap;
import java.util.Optional;

public interface DoctorService {
    public Doctor getDoctorDetails(Long cedDoctor);
    
    public Doctor convertToDoctor(List<HashMap<String, Object>> map);
    
    public Doctor getDoctorByCedDoctor(Long cedDoctor);
    
    public List<Doctor> getDoctors();
    
    public void addDoctor( Long cedDoctor, 
            String puesto,
            String nombre,
            String genero,
            Long idHorario);
    
    public void updateDoctor( Long cedDoctor, 
            String puesto,
            String nombre,
            String genero,
            Long idHorario);
    
    public void deleteDoctor(Long cedDoctor);
}
