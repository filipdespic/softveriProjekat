package so;

import domen.Primerak;
import exception.ServerskiException;

public class SOIzbrisiPrimerak extends OpstaSistemskaOperacija{

    private Primerak primerak;
    private boolean uspesnost;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        if(dbb.obrisiObjekat(primerak) != null) uspesnost = true;
    }

    public Primerak getPrimerak() {
        return primerak;
    }

    public void setPrimerak(Primerak primerak) {
        this.primerak = primerak;
    }

    public boolean isUspesnost() {
        return uspesnost;
    }

    public void setUspesnost(boolean uspesnost) {
        this.uspesnost = uspesnost;
    }
    
    
    
}
