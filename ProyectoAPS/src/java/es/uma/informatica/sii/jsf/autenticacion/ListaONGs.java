package es.uma.informatica.sii.jsf.autenticacion;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import es.uma.informatica.sii.acoes.*;




@Named(value = "ListaONGs")
@SessionScoped

public class ListaONGs implements Serializable {

    private final ArrayList<ONG> ongs;
    private ONG ong;

    public ListaONGs() {
        ongs = new ArrayList<>();
        ongs.add(new ONG(1, "Unicef", "Organizacion...", "unicef@info.com", 99999999, "C/Europa", "Spain", "unicef"));
        ongs.add(new ONG(2, "Unesco", "Organizacion...", "Unesco@info.com", 99999998, "C/Europa", "Spain", "unesco"));
        ong = new ONG();
    }

    public ArrayList<ONG> getONGs() {
        return ongs;
    }

    public ONG getONG() {
        return ong;
    }

    public void setONG(ONG ong) {
        this.ong = ong;
    }

    public String crearInforme() {
        return "anadirONG.xhtml";
    }

}
