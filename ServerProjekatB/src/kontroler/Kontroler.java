package kontroler;

import domen.Administrator;
import domen.Clan;
import domen.Iznajmljivanje;
import domen.Knjiga;
import domen.Primerak;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import so.SOIzbrisiPrimerak;
import so.SOKreirajClana;
import so.SOKreirajNovuKnjigu;
import so.SONadjiClana;
import so.SONadjiClanove;
import so.SONadjiIznajmljenePrimerke;
import so.SONadjiKnjige;
import so.SONadjiKnjigu;
import so.SONadjiPrimerke;
import so.SOPrijaviAdministratora;
import so.SOUcitajListuClanova;
import so.SOUcitajListuKnjiga;
import so.SOUcitajListuPrimeraka;
import so.SOVratiPrimerak;
import so.SOZapamtiClana;
import so.SOZapamtiIznajmljivanje;
import so.SOZapamtiKnjigu;
import so.SOZapamtiPrimerak;
import so.pomocne.SOKreirajAdministratora;
import so.pomocne.SOIzlogujSe;
import so.pomocne.SOUcitajListuKorisnika;

public class Kontroler {

    private static Kontroler instanca;
    private List<Administrator> listaKorisnika;

    private Kontroler() {
    }

    public static Kontroler vratiInstancu() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public Administrator prijaviAdministratora(Administrator administrator) throws ServerskiException {
        SOPrijaviAdministratora sopa = new SOPrijaviAdministratora();
        sopa.setParametar(administrator);
        sopa.izvrsiOperaciju();
        return sopa.getAdministrator();
    }

    public Knjiga kreirajNovuKnjigu() throws ServerskiException {
        SOKreirajNovuKnjigu soknk = new SOKreirajNovuKnjigu();
        soknk.izvrsiOperaciju();
        return soknk.getKnjiga();
    }

    public Knjiga zapamtiKnjigu(Knjiga knjiga) throws ServerskiException {
        SOZapamtiKnjigu sozk = new SOZapamtiKnjigu();
        sozk.setKnjiga(knjiga);
        sozk.izvrsiOperaciju();
        return sozk.getKnjiga();
    }

    public ArrayList<Knjiga> nadjiKnjige(HashMap<String, String> kriterijum) throws ServerskiException {
        SONadjiKnjige sonk = new SONadjiKnjige();
        sonk.setKriterijum(kriterijum);
        sonk.izvrsiOperaciju();
        return sonk.getKnjige();
    }

    public Knjiga nadjiKnjigu(Knjiga knjiga) throws ServerskiException {
        SONadjiKnjigu sonk = new SONadjiKnjigu();
        sonk.setParametar(knjiga);
        sonk.izvrsiOperaciju();
        return sonk.getKnjiga();
    }

    public Primerak zapamtiPrimerak(Primerak primerak) throws ServerskiException {
        SOZapamtiPrimerak sozp = new SOZapamtiPrimerak();
        sozp.setPrimerak(primerak);
        sozp.izvrsiOperaciju();
        return sozp.getPrimerak();
    }

    public ArrayList<Primerak> nadjiPrimerke(String isbn) throws ServerskiException {
        SONadjiPrimerke sonp = new SONadjiPrimerke();
        sonp.setISBN(isbn);
        sonp.izvrsiOperaciju();
        return sonp.getPrimerci();
    }

    public boolean izbrisiPrimerak(Primerak primerak) throws ServerskiException {
        SOIzbrisiPrimerak soip = new SOIzbrisiPrimerak();
        soip.setPrimerak(primerak);
        soip.izvrsiOperaciju();
        return soip.isUspesnost();
    }

    public Clan kreirajClana() throws ServerskiException {
        SOKreirajClana sokc = new SOKreirajClana();
        sokc.izvrsiOperaciju();
        return sokc.getClan();
    }


    public ArrayList<Clan> nadjiClanove(HashMap<String, String> kriterijum) throws ServerskiException {
        SONadjiClanove sonc = new SONadjiClanove();
        sonc.setKriterijum(kriterijum);
        sonc.izvrsiOperaciju();
        return sonc.getClanovi();
    }

    public Clan nadjiClana(Clan clan) throws ServerskiException {
        SONadjiClana sonc = new SONadjiClana();
        sonc.setClan(clan);
        sonc.izvrsiOperaciju();
        return sonc.getCeoClan();
    }

    public boolean zapamtiClana(Clan clan) throws ServerskiException {
        SOZapamtiClana sozc = new SOZapamtiClana();
        sozc.setClan(clan);
        sozc.izvrsiOperaciju();
        return sozc.isUspesno();
    }

    public ArrayList<Knjiga> ucitajListuKnjiga() throws ServerskiException {
        SOUcitajListuKnjiga soulk = new SOUcitajListuKnjiga();
        soulk.izvrsiOperaciju();
        return soulk.getKnjige();
    }

    public ArrayList<Primerak> ucitajListuPrimeraka(String isbn) throws ServerskiException {
        SOUcitajListuPrimeraka soulp = new SOUcitajListuPrimeraka();
        soulp.setIsbn(isbn);
        soulp.izvrsiOperaciju();
        return soulp.getPrimerci();
    }

    public ArrayList<Clan> ucitajListuClanova() throws ServerskiException {
        SOUcitajListuClanova soulc = new SOUcitajListuClanova();
        soulc.izvrsiOperaciju();
        return soulc.getClanovi();
    }

    public boolean zapamtiIznajmljivanje(Iznajmljivanje i) throws ServerskiException {
        SOZapamtiIznajmljivanje sozi = new SOZapamtiIznajmljivanje();
        sozi.setIznajmljivanje(i);
        sozi.izvrsiOperaciju();
        return sozi.isUspesno();
    }

    public ArrayList<Primerak> nadjiIznajmljenePrimerke(Clan clan) throws ServerskiException {
        SONadjiIznajmljenePrimerke sonip = new SONadjiIznajmljenePrimerke();
        sonip.setClan(clan);
        sonip.izvrsiOperaciju();
        return sonip.getListaPrimeraka();
    }

    public boolean vratiPrimerak(Primerak primerak) throws ServerskiException {
        SOVratiPrimerak sovp = new SOVratiPrimerak();
        sovp.setPrimerak(primerak);
        sovp.izvrsiOperaciju();
        return sovp.isUspesno();
    }

    public void izloguj(Administrator administrator) throws ServerskiException {
        SOIzlogujSe sois = new SOIzlogujSe();
        sois.setAdministrator(administrator);
        sois.izvrsiOperaciju();
    }

    // pomoćne
    
    public List<Administrator> getListaKorisnika() throws ServerskiException {
        if (listaKorisnika == null) {
            listaKorisnika = vratiListuKorisnika();
        }
        return listaKorisnika;
    }

    private List<Administrator> vratiListuKorisnika() throws ServerskiException {
        SOUcitajListuKorisnika souk = new SOUcitajListuKorisnika();
        souk.izvrsiOperaciju();
        return souk.getListaKorisnika();
    }

    public void kreirajAdministratora(Administrator a) throws ServerskiException {
        so.pomocne.SOKreirajAdministratora ka = new SOKreirajAdministratora();
        ka.setAdmin(a);
        ka.izvrsiOperaciju();
        System.out.println("Kreiran je novi administrator");
    }
    
}
