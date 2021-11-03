/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.RegistrarAlumnoMyBatis.Repository;

import com.example.RegistrarAlumnoMyBatis.Entity.Carrera;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Sebastian
 */
@Mapper
public interface CarreraRepository {
    @Select("select * from carrera")
    public List<Carrera> findall();
}
