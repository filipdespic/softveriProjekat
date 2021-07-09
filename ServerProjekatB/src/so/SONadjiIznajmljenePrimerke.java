package so;

import domen.Clan;
import domen.Primerak;
import exception.ServerskiException;
import java.util.ArrayList;

public class SONadjiIznajmljenePrimerke extends OpstaSistemskaOperacija{
    private Clan clan;
    private ArrayList<Primerak> listaPrimeraka;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        listaPrimeraka = dbb.nadjiIznajmljenePrimerke(clan);
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public ArrayList<Primerak> getListaPrimeraka() {
        return listaPrimeraka;
    }

    public void setListaPrimeraka(ArrayList<Primerak> listaPrimeraka) {
        this.listaPrimeraka = listaPrimeraka;
    }
    
}
