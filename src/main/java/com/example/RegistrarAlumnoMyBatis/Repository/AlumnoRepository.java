/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.RegistrarAlumnoMyBatis.Repository;

import com.example.RegistrarAlumnoMyBatis.Entity.Alumno;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Sebastian
 */
@Mapper
public interface AlumnoRepository {
    @Select("select a.idalumno, a.nombre, a.correo, a.telefono, c.idcarrera, c.nombre as carrera from alumno as a inner join carrera as c on a.idcarrera = c.idcarrera;")
    public List<Map<String,Object>> findAll();
    
    @Select("select * from alumno where idalumno=#{id}")
    public Alumno readAlumno(int id);
    
    @Delete("delete from alumno where idalumno=#{id}")
    public int deleteByid(int id);
    
    @Insert("insert into alumno(nombre, correo, telefono, idcarrera) values (#{nombre},#{correo},#{telefono},#{idcarrera})")
    public int insert(Alumno alumno);
    
    @Update("update alumno set nombre =#{nombre},correo =#{correo},telefono =#{telefono},idcarrera =#{idcarrera} where idalumno =#{idalumno}")
    public int update(Alumno alumno);
}
