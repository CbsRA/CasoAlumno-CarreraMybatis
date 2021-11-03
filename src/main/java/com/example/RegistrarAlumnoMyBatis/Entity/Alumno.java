/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.RegistrarAlumnoMyBatis.Entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Sebastian
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno implements Serializable{
    private int idalumno;
    private String nombre;
    private String correo;
    private int telefono;
    private int idcarrera;
}
