
package com.hospital.v1.service;

import com.hospital.v1.domain.Doctor;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public interface DoctorService {
    //Obtiene la lista de registros de la tabla doctor y
    //lo coloca en una lista de objetos doctor.
    public List<Doctor> getDoctors();
    
    //Obtiene el registro de la tabla doctor que tiene el
    //id doctor pasado por el objeto doctor.
    public Doctor getDoctor(Doctor doctor);
    
    //Elimina el registro de la tabla doctor que tiene el
    //id doctor pasado por el objeto.
    public void deleteDoctor(Doctor doctor);
    
    //Si el iddoctor pasado no existe o es nulo se crea un registro nuevo
    //en la tabla doctor
    //Si el iddoctor existe, se actualiza la informacion.
    public void saveDoctor(Doctor doctor);
    
    public Doctor getDoctorDetails(Long cedDoctor);
    
    
    public Doctor convertToDoctor(List<HashMap<String, Object>> map);
}
