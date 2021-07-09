package so;

import domen.Clan;
import exception.ServerskiException;
import java.util.Date;

public class SOKreirajClana extends OpstaSistemskaOperacija{

    private Clan clan;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        String sifraClana = Integer.toString(((int) (new Date().getTime() / 1000)));
        clan = new Clan();
        clan.setSifraClana(sifraClana);
        dbb.sacuvajObjekat(clan);
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
    
}
