/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.service.impl;

import com.hospital.v1.dao.TratamientoDao;
import com.hospital.v1.domain.Tratamiento;
import com.hospital.v1.service.TratamientoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TratamientoServiceImpl implements TratamientoService {
    
    @Autowired
    private TratamientoDao tratDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tratamiento> getTratamientos() {
       return tratDao.getTratamientos();
    }

    @Override
    public void guardarTratamiento(Tratamiento trat) {
       tratDao.save(trat);
    }

    @Override
    public void eliminarTratamiento(Tratamiento trat) {
       tratDao.delete(trat);
    }

    @Override
    public void actualizarTratamiento(Tratamiento trat) {
        tratDao.save(trat);
    }
    
    
}
