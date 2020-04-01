package es.uma.informatica.jpa.proyect;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: login
 *
 */
@Entity

public class login implements Serializable {

	   
	@Id @GeneratedValue
	private Integer id;
	private String nick; //hace falta ponerla como clave unica
	private String contrase�a;
	private String rol;
	private static final long serialVersionUID = 1L;

	public login() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}   
	public String getContrase�a() {
		return this.contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}   
	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
   
}
