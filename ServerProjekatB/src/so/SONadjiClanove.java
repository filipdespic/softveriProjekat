package so;

import domen.Clan;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.HashMap;

public class SONadjiClanove extends OpstaSistemskaOperacija{

    private HashMap<String, String> kriterijum;
    private ArrayList<Clan> clanovi;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        clanovi = dbb.nadjiClanove(kriterijum);
    }

    public ArrayList<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(ArrayList<Clan> clanovi) {
        this.clanovi = clanovi;
    }

    public HashMap<String, String> getKriterijum() {
        return kriterijum;
    }

    public void setKriterijum(HashMap<String, String> kriterijum) {
        this.kriterijum = kriterijum;
    }

}
