package so;

import domen.Clan;
import domen.OpstiDomenskiObjekat;
import exception.ServerskiException;
import java.util.ArrayList;

public class SOUcitajListuClanova extends OpstaSistemskaOperacija{

       private ArrayList<Clan> clanovi = new ArrayList<>();
     
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
         ArrayList<OpstiDomenskiObjekat> lista = (ArrayList<OpstiDomenskiObjekat>) dbb.vratiSveObjekte(new Clan());
         for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            clanovi.add((Clan) opstiDomenskiObjekat);
        }
    }

    public ArrayList<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(ArrayList<Clan> clanovi) {
        this.clanovi = clanovi;
    }
    
}
