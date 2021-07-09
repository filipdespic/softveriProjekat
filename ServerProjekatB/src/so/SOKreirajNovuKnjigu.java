package so;

import domen.Knjiga;
import exception.ServerskiException;

public class SOKreirajNovuKnjigu extends OpstaSistemskaOperacija{

    private Knjiga knjiga;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        knjiga = new Knjiga();
        knjiga.setAutor("Unesite ime autora");
        knjiga.setISBN("Unesite ISBN");
        knjiga.setNazivKnjige("Unesite naziv knjige");
        knjiga.setGodinaObjavljivanja(0);
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

}
