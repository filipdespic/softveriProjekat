package so;

import domen.Primerak;
import exception.ServerskiException;
import java.util.Date;
import zastita.HashFunkcija;

public class SOZapamtiPrimerak extends OpstaSistemskaOperacija{

    private Primerak primerak;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        String sifraPrimerka = Integer.toString(((int) (new Date().getTime() / 1000))) + HashFunkcija.napraviHash(primerak.getIzdavac());
        primerak.setSifraPrimerka(sifraPrimerka);
        primerak = (Primerak) dbb.sacuvajObjekat(primerak);
    }

    public Primerak getPrimerak() {
        return primerak;
    }

    public void setPrimerak(Primerak primerak) {
        this.primerak = primerak;
    }
    
    
}


