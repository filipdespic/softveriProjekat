package so;

import domen.Primerak;
import exception.ServerskiException;
import java.util.ArrayList;

public class SOUcitajListuPrimeraka extends OpstaSistemskaOperacija {

    private ArrayList<Primerak> primerci = new ArrayList<>();
    private String isbn;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        primerci = dbb.ucitajListuPrimeraka(isbn);
    }

    public ArrayList<Primerak> getPrimerci() {
        return primerci;
    }

    public void setPrimerci(ArrayList<Primerak> primerci) {
        this.primerci = primerci;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
