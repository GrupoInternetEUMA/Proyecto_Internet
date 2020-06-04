
package negocio;

import javax.ejb.Local;
import javax.ws.rs.core.UriBuilder;

import Entidades.Usuario;
import excepciones.APSException;

/**
 *
 * @author francis
 */
@Local
public interface Negocio {
    public void compruebaLogin(Usuario u) throws APSException;
    public Usuario refrescarUsuario(Usuario u) throws APSException;
    /*public void modificar(Usuario u) throws APSException;
    public void insertar(Usuario u) throws APSException;
    public void eliminarUsuario(Usuario u) throws APSException;*/
}

