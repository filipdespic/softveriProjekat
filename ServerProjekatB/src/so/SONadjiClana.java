package so;

import domen.Clan;
import exception.ServerskiException;

public class SONadjiClana extends OpstaSistemskaOperacija{

    private Clan clan;
    private Clan ceoClan;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        ceoClan = (Clan) dbb.vratiObjekatPoKljucu(clan, clan.getSifraClana());
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Clan getCeoClan() {
        return ceoClan;
    }

    public void setCeoClan(Clan ceoClan) {
        this.ceoClan = ceoClan;
    }
    
}
