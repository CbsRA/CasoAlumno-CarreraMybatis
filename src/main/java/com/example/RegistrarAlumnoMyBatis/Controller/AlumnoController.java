/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.RegistrarAlumnoMyBatis.Controller;

import com.example.RegistrarAlumnoMyBatis.Entity.Alumno;
import com.example.RegistrarAlumnoMyBatis.Repository.AlumnoRepository;
import com.example.RegistrarAlumnoMyBatis.Repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author Sebastian
 */
@Controller
public class AlumnoController {
    @Autowired
    private CarreraRepository carreraRepository;
    
    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @RequestMapping("/alumnos")
    public String alumnos(Model model){
        model.addAttribute("alumnos", alumnoRepository.findAll());
        return "alumno";
    }
    
    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("carreras", carreraRepository.findall());
        return "addAlumno";
    }
    
    @RequestMapping("/addAlumno")
    public String guardar(@RequestParam String nombre,@RequestParam String correo,@RequestParam int telefono,@RequestParam int idcarrera,Model model){
        Alumno alumno =new Alumno();
        alumno.setNombre(nombre);
        alumno.setCorreo(correo);
        alumno.setTelefono(telefono);
        alumno.setIdcarrera(idcarrera);
        alumnoRepository.insert(alumno);
        return "redirect:/alumnos";
    }
    
    @RequestMapping("/delalumn/{id}")
    public String deletealum(@PathVariable(value = "id") int id){
        alumnoRepository.deleteByid(id);
        return "redirect:/alumnos";
    }
    
    @RequestMapping("/editalumn/{id}")
    public String editalumn(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("carreras", carreraRepository.findall());
        model.addAttribute("alumnos", alumnoRepository.readAlumno(id));
        return "editAlumno";
    }
    
    @RequestMapping("/updatealumn")
    public String update(@RequestParam int idalumno, @RequestParam String nombre,@RequestParam String correo,@RequestParam int telefono, @RequestParam int idcarrera) {
        System.out.println(idalumno+"/"+nombre+"/"+correo+"/"+telefono+"/"+idcarrera);
        Alumno alumno = alumnoRepository.readAlumno(idalumno);
        alumno.setNombre(nombre);
        alumno.setCorreo(correo);
        alumno.setTelefono(telefono);
        alumno.setIdcarrera(idcarrera);
        alumnoRepository.update(alumno);
        return "redirect:/alumnos";
    }
    
    
}
