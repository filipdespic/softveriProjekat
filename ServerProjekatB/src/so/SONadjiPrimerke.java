package so;

import domen.Primerak;
import exception.ServerskiException;
import java.util.ArrayList;

public class SONadjiPrimerke extends OpstaSistemskaOperacija{

    private String ISBN;
    private ArrayList<Primerak> primerci;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
         primerci = dbb.nadjiPrimerke(ISBN);
    }

    public ArrayList<Primerak> getPrimerci() {
        return primerci;
    }

    public void setPrimerci(ArrayList<Primerak> primerci) {
        this.primerci = primerci;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
}
