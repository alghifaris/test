/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.api.apicrud.controllers;

import com.test.api.apicrud.dtos.MahasiswaDTO;
import com.test.api.apicrud.mahasiswaRepository.mahasiswaRepository;
import com.test.api.apicrud.models.Mahasiswa;
import io.swagger.v3.oas.annotations.Operation;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alghifaris.bagaskara
 */


@RestController()
@RequestMapping("/api/")
public class MahasiswaController {

    @Autowired
    private mahasiswaRepository mahasiswaRepository;

    ModelMapper modelMapper = new ModelMapper();

    private Mahasiswa ConvertEmployeeToEntity(MahasiswaDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Mahasiswa.class);
    }

    private MahasiswaDTO ConvertEmployeeToDTO(Mahasiswa employee) {
        return modelMapper.map(employee, MahasiswaDTO.class);
    }

     @Operation(summary = "Insert Data Mahasiswa", description = "Insert Mahasiswa Data Mahasiswa")
    @PostMapping("mahasiswa/create")
    public Map<String, Object> createMahasiswa(@RequestBody MahasiswaDTO mahasiswaDTO) {
        Map<String, Object> mapResult = new HashMap();
        Mahasiswa mahasiswa = ConvertEmployeeToEntity(mahasiswaDTO);
        mahasiswa.setName(mahasiswaDTO.getName());
        mahasiswa.setGender(mahasiswaDTO.getGender());

        mapResult.put("Message", "Data Berhasil Di input");
        mapResult.put("Data", mahasiswaRepository.save(mahasiswa));

        return mapResult;
    }

    @Operation(summary = "Get Data Mahasiswa", description = "Get Mahasiswa Data Mahasiswa")
    @GetMapping("mahasiswa/all")
    public Map<String, Object> getAll() {
        Map<String, Object> mapResult = new HashMap<>();
        List<MahasiswaDTO> listMahasiswaResult = new ArrayList<>();
        for (Mahasiswa mahasiswa : mahasiswaRepository.findAll()) {
            MahasiswaDTO mahasiswaDTO = ConvertEmployeeToDTO(mahasiswa);
            listMahasiswaResult.add(mahasiswaDTO);
        }

        String message;

        if (listMahasiswaResult.isEmpty()) {
            message = "Data Kosong";
        } else {
            message = "Show All Data";
        }

        mapResult.put("Message", message);
        mapResult.put("data", listMahasiswaResult);
        mapResult.put("Total", listMahasiswaResult.size());

        return mapResult;
    }
    
    @Operation(summary = "Update Data Mahasiswa", description = "Update Mahasiswa Data Mahasiswa")
    @PutMapping("mahasiswa/update")
    public Map<String,Object> UpdateMahasiswa(@RequestParam(value="mahasiswaId") Long id
            ,@RequestBody MahasiswaDTO mahasiswaDTO )
    { 
        Map<String,Object> mapResult = new HashMap();
        Mahasiswa mahasiswa = mahasiswaRepository.findById(id).orElse(null);
        mahasiswa.setName(mahasiswaDTO.getName());
        mahasiswa.setGender(mahasiswaDTO.getGender());
        
        mapResult.put("Message","Data Behasil Di Update");
        mapResult.put("Data", mahasiswaRepository.save(mahasiswa) );                
        return mapResult;
    
    }
    
    @Operation(summary = "Delete Data Mahasiswa", description = "Delete Mahasiswa Data Mahasiswa")
    @DeleteMapping("mahasiswa/delete/{mahasiswaId}")
    public Map<String,Object> DeleteMahasiswa(@PathVariable(value="mahasiswaId")Long Id)
    {
        Map<String,Object> mapResult = new HashMap();
        Mahasiswa mahasiswa = mahasiswaRepository.findById(Id).orElse(null);
        mahasiswaRepository.delete(mahasiswa);
        mapResult.put("Message","Data Behasil di hapus");
        
        return mapResult;

    }

}
