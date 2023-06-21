/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.api.apicrud.viewcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alghifaris.bagaskara
 */
@Controller
public class MahasiswaViewConroller {
    @RequestMapping(value="/index")
    public String index(){
    return "index";
    }
}
