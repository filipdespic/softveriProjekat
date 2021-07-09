package so;

import domen.Clan;
import exception.ServerskiException;

public class SOZapamtiClana extends OpstaSistemskaOperacija{

    private Clan clan;
    private boolean uspesno;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
         clan = (Clan) dbb.izmeniObjekat(clan);
         if(clan != null) uspesno = true;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }
    
}
