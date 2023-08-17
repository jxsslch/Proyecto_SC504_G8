/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.service.impl;

import com.hospital.v1.dao.MedicamentoDao;
import com.hospital.v1.domain.Medicamento;
import com.hospital.v1.service.MedicamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MedicamentoServiceImpl implements MedicamentoService {
    
    @Autowired
    private MedicamentoDao medDao;

    @Override
    @Transactional(readOnly = true)
    public List<Medicamento> getMedicamentos() {
        return medDao.getMedicamentos();
    }
    
    
}
