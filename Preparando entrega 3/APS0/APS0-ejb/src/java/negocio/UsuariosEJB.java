package negocio;


import Entidades.Usuario;
import java.util.List;
import javax.ejb.Local;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josea
 */
@Local
public interface UsuariosEJB {
        public List<Usuario> findAll();
        public void insertar(Usuario u);
        public void editar(Usuario u);
        public void borrar(Usuario u);

}
