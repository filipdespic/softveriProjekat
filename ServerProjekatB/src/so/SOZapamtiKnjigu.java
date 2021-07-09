package so;

import domen.Knjiga;
import exception.ServerskiException;

public class SOZapamtiKnjigu extends OpstaSistemskaOperacija {

    private Knjiga knjiga;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        knjiga = (Knjiga) dbb.sacuvajObjekat(knjiga);
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

}
