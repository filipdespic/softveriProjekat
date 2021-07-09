package so.pomocne;

import domen.Administrator;
import domen.OpstiDomenskiObjekat;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;

public class SOUcitajListuKorisnika extends OpstaSistemskaOperacija{

    private List<Administrator> listaKorisnika = new ArrayList<>();
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<OpstiDomenskiObjekat> lista = dbb.vratiSveObjekte(new Administrator());
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            Administrator a = (Administrator) opstiDomenskiObjekat;
            listaKorisnika.add(a);
        }
    }

    public List<Administrator> getListaKorisnika() {
        return listaKorisnika;
    }
    
}
