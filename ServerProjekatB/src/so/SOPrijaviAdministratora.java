package so;

import domen.Administrator;
import exception.ServerskiException;
import java.util.List;
import kontroler.Kontroler;

public class SOPrijaviAdministratora extends OpstaSistemskaOperacija {

    private Administrator parametar;
    private Administrator administrator;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<Administrator> listaAdministratora = Kontroler.vratiInstancu().getListaKorisnika();
        administrator = dbb.prijaviAdministratora(parametar);
        if (administrator.getKorisnickoIme() != null) {
            for (Administrator adminIzListe : listaAdministratora) {
                if (adminIzListe.equals(administrator)) {
                    if (adminIzListe.isUlogovan()) {
                        throw new ServerskiException("Administrator je već ulogovan");
                    } else {
                        int indeks = listaAdministratora.indexOf(adminIzListe);
                        Kontroler.vratiInstancu().getListaKorisnika().get(indeks).setUlogovan(true);
                    }
                }
            }
        }
    }

    public Administrator getParametar() {
        return parametar;
    }

    public void setParametar(Administrator parametar) {
        this.parametar = parametar;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

}
