package so.pomocne;

import domen.Administrator;
import exception.ServerskiException;
import java.util.List;
import kontroler.Kontroler;
import so.OpstaSistemskaOperacija;

public class SOIzlogujSe extends OpstaSistemskaOperacija{

    private Administrator administrator;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<Administrator> lista = Kontroler.vratiInstancu().getListaKorisnika();
        for (Administrator adminIzListe : lista) {
            if(adminIzListe.getKorisnickoIme().equals(administrator.getKorisnickoIme())){
                adminIzListe.setUlogovan(false);
            }
        }
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
    
}
