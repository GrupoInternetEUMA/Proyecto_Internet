/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Entidades.Alumno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Antonio
 */
@Local
public interface BaseDeDatosLocal {
    public List<Alumno> getAlumnos();
     public List<Alumno> getAlumnos1();        
}
