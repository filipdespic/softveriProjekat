package server;

import domen.Administrator;
import domen.Clan;
import domen.Iznajmljivanje;
import domen.Knjiga;
import domen.Primerak;
import exception.ServerskiException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class ObradaKlijentskihZahtevaNit extends Thread {

    private Socket socket;
    private List<ObradaKlijentskihZahtevaNit> klijenti;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public ObradaKlijentskihZahtevaNit(Socket socket, List<ObradaKlijentskihZahtevaNit> klijenti) {
        this.socket = socket;
        this.klijenti = klijenti;
    }

    @Override
    public void run() {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                System.out.println("Cekam zahtev");
                KlijentskiZahtev kz = (KlijentskiZahtev) in.readUnshared();
                ServerskiOdgovor so = new ServerskiOdgovor();
                ArrayList<Knjiga> listaKnjiga;
                Knjiga knjiga;
                Primerak primerak;
                Clan clan;
                boolean uspesno;
                HashMap<String, String> kriterijum;
                Administrator administrator;
                String isbn;
                try {
                    int operacija = kz.getOperacija();
                    switch (operacija) {
                        case Operacije.PRIJAVI_ADMINISTRATORA:
                            administrator = (Administrator) kz.getParametar();
                            Administrator ulogovaniAdministrator = Kontroler.vratiInstancu().prijaviAdministratora(administrator);
                            so.setPodaci(ulogovaniAdministrator);
                            break;
                        case Operacije.KREIRAJ_NOVU_KNJIGU:
                            knjiga = Kontroler.vratiInstancu().kreirajNovuKnjigu();
                            so.setPodaci(knjiga);
                            break;
                        case Operacije.ZAPAMTI_KNJIGU:
                            knjiga = (Knjiga) kz.getParametar();
                            knjiga = Kontroler.vratiInstancu().zapamtiKnjigu(knjiga);
                            so.setPodaci(knjiga);
                            break;
                        case Operacije.NADJI_KNJIGE:
                            kriterijum = (HashMap<String, String>) kz.getParametar();
                            listaKnjiga = Kontroler.vratiInstancu().nadjiKnjige(kriterijum);
                            so.setPodaci(listaKnjiga);
                            break;
                        case Operacije.NADJI_KNJIGU:
                            knjiga = (Knjiga) kz.getParametar();
                            so.setPodaci(Kontroler.vratiInstancu().nadjiKnjigu(knjiga));
                            break;
                        case Operacije.ZAPAMTI_PRIMERAK:
                            primerak = (Primerak) kz.getParametar();
                            so.setPodaci(Kontroler.vratiInstancu().zapamtiPrimerak(primerak));
                            break;
                        case Operacije.NADJI_PRIMERKE:
                            isbn = (String) kz.getParametar();
                            so.setPodaci(Kontroler.vratiInstancu().nadjiPrimerke(isbn));
                            break;
                        case Operacije.IZBRISI_PRIMERAK:
                            primerak = (Primerak) kz.getParametar();
                            so.setPodaci(Kontroler.vratiInstancu().izbrisiPrimerak(primerak));
                            break;
                        case Operacije.KREIRAJ_CLANA:
                            clan = Kontroler.vratiInstancu().kreirajClana();
                            so.setPodaci(clan);
                            break;
                        case Operacije.NADJI_CLANOVE:
                            kriterijum = (HashMap<String, String>) kz.getParametar();
                            ArrayList<Clan> rezultatPretrage = Kontroler.vratiInstancu().nadjiClanove(kriterijum);
                            so.setPodaci(rezultatPretrage);
                            break;
                        case Operacije.NADJI_CLANA:
                            clan = (Clan) kz.getParametar();
                            Clan ceoClan = Kontroler.vratiInstancu().nadjiClana(clan);
                            so.setPodaci(ceoClan);
                            break;
                        case Operacije.ZAPAMTI_CLANA:
                            clan = (Clan) kz.getParametar();
                            uspesno = Kontroler.vratiInstancu().zapamtiClana(clan);
                            so.setPodaci(uspesno);
                            break;
                        case Operacije.UCITAJ_LISTU_KNJIGA:
                            listaKnjiga = Kontroler.vratiInstancu().ucitajListuKnjiga();
                            so.setPodaci(listaKnjiga);
                            break;
                        case Operacije.UCITAJ_LISTU_PRIMERAKA:
                            isbn = (String) kz.getParametar();
                            ArrayList<Primerak> listaPrimeraka = Kontroler.vratiInstancu().ucitajListuPrimeraka(isbn);
                            so.setPodaci(listaPrimeraka);
                            break;
                        case Operacije.UCITAJ_LISTU_CLANOVA:
                            ArrayList<Clan> listaClanova = Kontroler.vratiInstancu().ucitajListuClanova();
                            so.setPodaci(listaClanova);
                            break;
                        case Operacije.ZAPAMTI_IZNAJMLJIVANJE:
                            Iznajmljivanje i = (Iznajmljivanje) kz.getParametar();
                            so.setPodaci(Kontroler.vratiInstancu().zapamtiIznajmljivanje(i));
                            break;
                        case Operacije.NADJI_IZNAJMLJENE_PRIMERKE:
                            clan = (Clan) kz.getParametar();
                            so.setPodaci(Kontroler.vratiInstancu().nadjiIznajmljenePrimerke(clan));
                            break;
                        case Operacije.VRATI_PRIMERAK:
                            primerak = (Primerak) kz.getParametar();
                            so.setPodaci(Kontroler.vratiInstancu().vratiPrimerak(primerak));
                            break;
                        case Operacije.IZLOGUJ:
                            administrator = (Administrator) kz.getParametar();
                            Kontroler.vratiInstancu().izloguj(administrator);
                            break;
                    }
                    so.setUspesnost(1);
                } catch (ServerskiException ex) {
                    so.setUspesnost(-1);
                    so.setException(ex);
                }
                out.writeUnshared(so);
            }
        } catch (SocketException ex) {
            try {
                System.out.println("Klijent se iskljucuje ili logout...");
                in.close();
                out.close();
                socket.close();
                klijenti.remove(this);
            } catch (IOException ex1) {
                Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public List<ObradaKlijentskihZahtevaNit> getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(List<ObradaKlijentskihZahtevaNit> klijenti) {
        this.klijenti = klijenti;
    }

}
