package so;

import domen.Knjiga;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.HashMap;

public class SONadjiKnjige extends OpstaSistemskaOperacija{

    private HashMap<String, String> kriterijum;
    private ArrayList<Knjiga> knjige;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        knjige = dbb.nadjiKnjige(kriterijum);
    }

    public ArrayList<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(ArrayList<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public HashMap<String, String> getKriterijum() {
        return kriterijum;
    }

    public void setKriterijum(HashMap<String, String> kriterijum) {
        this.kriterijum = kriterijum;
    }
    
}
