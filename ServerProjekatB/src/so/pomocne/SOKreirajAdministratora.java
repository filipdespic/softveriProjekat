package so.pomocne;

import domen.Administrator;
import domen.OpstiDomenskiObjekat;
import exception.ServerskiException;
import so.OpstaSistemskaOperacija;

public class SOKreirajAdministratora extends OpstaSistemskaOperacija{

    private OpstiDomenskiObjekat admin;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        dbb.sacuvajObjekat(admin);
    }

    public OpstiDomenskiObjekat getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }
    
}
