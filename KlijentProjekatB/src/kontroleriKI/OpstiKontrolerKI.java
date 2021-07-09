package kontroleriKI;

import domen.Administrator;
import domen.Clan;
import domen.Iznajmljivanje;
import domen.Knjiga;
import domen.Primerak;
import exception.ServerskiException;
import forme.EkranskaFormaClanovi;
import forme.EkranskaFormaIznajmljivanje;
import forme.EkranskaFormaPrimerak;
import forme.EkranskaFormaVracanje;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;
import konstante.Operacije;
import modeli.ModelTabeleClanovi;
import modeli.ModelTabeleKnjige;
import modeli.ModelTabelePrimerci;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class OpstiKontrolerKI {

    public static OpstiKontrolerKI instanca;

    private OpstiKontrolerKI() {
    }

    public static OpstiKontrolerKI vratiInstancu() {
        if (instanca == null) {
            instanca = new OpstiKontrolerKI();
        }
        return instanca;
    }

    public HashMap<String, String> prijaviAdministratora(String korisnickoIme, String korisnickaLozinka) throws ServerskiException, Exception {
        Administrator administrator = new Administrator();
        administrator.setKorisnickoIme(korisnickoIme);
        administrator.setKorisnickaLozinka(korisnickaLozinka);

        Administrator ulogovaniAdministrator = (Administrator) posaljiZahtev(Operacije.PRIJAVI_ADMINISTRATORA, administrator);
        if (ulogovaniAdministrator.getSifraAdmina() != null) {
            HashMap<String, String> ulogovaniAdministratorHash = new HashMap<>();
            ulogovaniAdministratorHash.put("SifraAdmina", ulogovaniAdministrator.getSifraAdmina());
            ulogovaniAdministratorHash.put("Ime", ulogovaniAdministrator.getIme());
            ulogovaniAdministratorHash.put("Prezime", ulogovaniAdministrator.getPrezime());
            ulogovaniAdministratorHash.put("KorisnickoIme", ulogovaniAdministrator.getKorisnickoIme());
            return ulogovaniAdministratorHash;
        }
        return null;
    }

    public HashMap<String, String> kreirajObjekat(String nazivObjekta) throws Exception {
        switch (nazivObjekta) {
            case "knjiga":
                Knjiga novaKnjiga = (Knjiga) posaljiZahtev(Operacije.KREIRAJ_NOVU_KNJIGU, null);
                HashMap<String, String> hashMapNoveKnjige = new HashMap<>();
                hashMapNoveKnjige.put("isbn", novaKnjiga.getISBN());
                hashMapNoveKnjige.put("naziv", novaKnjiga.getNazivKnjige());
                hashMapNoveKnjige.put("autor", novaKnjiga.getAutor());
                hashMapNoveKnjige.put("godina", Integer.toString(novaKnjiga.getGodinaObjavljivanja()));
                return hashMapNoveKnjige;
            case "clan":
                Clan noviClan = (Clan) posaljiZahtev(Operacije.KREIRAJ_CLANA, null);
                HashMap<String, String> hashMapNovogClana = new HashMap<>();
                hashMapNovogClana.put("sifra", noviClan.getSifraClana());
                return hashMapNovogClana;
            default:
                throw new Exception("Pokušavate da kreirate nepoznat objekta.");
        }
    }

    public boolean zapamtiObjekat(HashMap<String, String> objekatZaPamcenje) throws Exception {
        switch (objekatZaPamcenje.get("tip")) {
            case "knjiga":
                Knjiga knjigaZaPamcenje = new Knjiga();
                knjigaZaPamcenje.setNazivKnjige(objekatZaPamcenje.get("naziv"));
                knjigaZaPamcenje.setISBN(objekatZaPamcenje.get("isbn"));
                knjigaZaPamcenje.setGodinaObjavljivanja(Integer.parseInt(objekatZaPamcenje.get("godina")));
                knjigaZaPamcenje.setAutor(objekatZaPamcenje.get("autor"));
                if (posaljiZahtev(Operacije.ZAPAMTI_KNJIGU, knjigaZaPamcenje) != null) {
                    return true;
                }
                break;
            case "primerak":
                Primerak primerakZaPamcenje = new Primerak();
                primerakZaPamcenje.setISBN(objekatZaPamcenje.get("isbn"));
                primerakZaPamcenje.setIzdavac(objekatZaPamcenje.get("izdavac"));
                if (posaljiZahtev(Operacije.ZAPAMTI_PRIMERAK, primerakZaPamcenje) != null) {
                    return true;
                }
                break;
            default:
                throw new Exception("Pokušavate da zapamtite nepoznat objekta.");
        }
        return false;
    }

    public void nadjiKnjige(HashMap kriterijum, EkranskaFormaPrimerak efp) throws Exception {
        ArrayList<Knjiga> listaKnjiga = (ArrayList<Knjiga>) posaljiZahtev(Operacije.NADJI_KNJIGE, kriterijum);
        ModelTabeleKnjige mtk = new ModelTabeleKnjige();
        mtk.setLista(listaKnjiga);
        efp.getModelTabeleKnjige().setLista(listaKnjiga);
        efp.getTabelaKnjige().setModel(mtk);
    }

    public HashMap<String, String> nadjiKnjigu(String isbn) throws Exception {
        Knjiga knjiga = new Knjiga();
        knjiga.setISBN(isbn);
        knjiga = (Knjiga) posaljiZahtev(Operacije.NADJI_KNJIGU, knjiga);
        HashMap<String, String> hashMapKnjige = new HashMap<>();
        hashMapKnjige.put("isbn", knjiga.getISBN());
        hashMapKnjige.put("naziv", knjiga.getNazivKnjige());
        hashMapKnjige.put("autor", knjiga.getAutor());
        hashMapKnjige.put("godina", Integer.toString(knjiga.getGodinaObjavljivanja()));
        return hashMapKnjige;
    }

    public boolean nadjiPrimerke(String isbn, EkranskaFormaPrimerak efp) throws Exception {
        ArrayList<Primerak> listaPrimeraka = (ArrayList<Primerak>) posaljiZahtev(Operacije.NADJI_PRIMERKE, isbn);
        if (listaPrimeraka != null) {
            ModelTabelePrimerci mtp = new ModelTabelePrimerci();
            mtp.setLista(listaPrimeraka);
            efp.setModelTabelePrimerci(mtp);
            efp.getTabelaPrimerci().setModel(mtp);
            return true;
        } else {
            return false;
        }
    }

    public boolean izbrisiPrimerak(String sifraPrimerka) throws Exception {
        Primerak primerak = new Primerak();
        primerak.setSifraPrimerka(sifraPrimerka);
        return (boolean) posaljiZahtev(Operacije.IZBRISI_PRIMERAK, primerak);
    }

    public boolean zapamtiNovogClana(HashMap<String, String> podaciOClanu) throws Exception {
        Clan clan = new Clan();
        clan.setSifraClana(podaciOClanu.get("sifra"));
        clan.setIme(podaciOClanu.get("ime"));
        clan.setPrezime(podaciOClanu.get("prezime"));
        clan.setJMBG(podaciOClanu.get("jmbg"));
        clan.setTelefon(podaciOClanu.get("telefon"));
        clan.setEmail(podaciOClanu.get("email"));
        return (boolean) posaljiZahtev(Operacije.ZAPAMTI_CLANA, clan);
    }

    public void nadjiClanove(HashMap<String, String> kriterijum, EkranskaFormaClanovi efc) throws Exception {
        ArrayList<Clan> listaClanova = (ArrayList<Clan>) posaljiZahtev(Operacije.NADJI_CLANOVE, kriterijum);
        ModelTabeleClanovi mtc = new ModelTabeleClanovi();
        mtc.setLista(listaClanova);
        efc.getTabelaClanovi().setModel(mtc);
        efc.setModelTabeleClanovi(mtc);
    }

    public void osveziTabeluClanova(HashMap<String, String> kriterijum, EkranskaFormaVracanje efv) throws Exception {
        ArrayList<Clan> listaClanova = (ArrayList<Clan>) posaljiZahtev(Operacije.NADJI_CLANOVE, kriterijum);
        ModelTabeleClanovi mtc = new ModelTabeleClanovi();
        mtc.setLista(listaClanova);
        efv.getTabelaClanovi().setModel(mtc);
        efv.setModelTabeleClanovi(mtc);
        if (listaClanova.isEmpty()) {
            efv.getLabelaUspesno().setText("Sistem ne može da nađe članove po zadatoj vrednosti.");
        } else {
            efv.getLabelaUspesno().setText("Sistem je našao članove.");
        }

    }

    public boolean zapamtiClana(HashMap<String, String> podaci) throws Exception {
        Clan clan = new Clan();
        clan.setSifraClana(podaci.get("sifra"));
        clan.setEmail(podaci.get("email"));
        clan.setIme(podaci.get("ime"));
        clan.setPrezime(podaci.get("prezime"));
        clan.setEmail(podaci.get("email"));
        clan.setTelefon(podaci.get("telefon"));
        clan.setJMBG(podaci.get("jmbg"));
        return (boolean) posaljiZahtev(Operacije.ZAPAMTI_CLANA, clan);
    }

    public HashMap<String, String> nadjiClana(String sifraClana) throws Exception {
        HashMap<String, String> hashMapClana = new HashMap<>();
        Clan clan = new Clan();
        clan.setSifraClana(sifraClana);
        clan = (Clan) posaljiZahtev(Operacije.NADJI_CLANA, clan);
        hashMapClana.put("sifra", clan.getSifraClana());
        hashMapClana.put("jmbg", clan.getJMBG());
        hashMapClana.put("ime", clan.getIme());
        hashMapClana.put("prezime", clan.getPrezime());
        hashMapClana.put("telefon", clan.getTelefon());
        hashMapClana.put("email", clan.getEmail());
        return hashMapClana;
    }

    public ArrayList<Knjiga> ucitajListuKnjiga() throws Exception {
        return (ArrayList<Knjiga>) posaljiZahtev(Operacije.UCITAJ_LISTU_KNJIGA, null);
    }

    public ArrayList<Primerak> ucitajListuPrimeraka() throws Exception {
        return (ArrayList<Primerak>) posaljiZahtev(Operacije.UCITAJ_LISTU_PRIMERAKA, null);
    }

    public ArrayList<Clan> ucitajListuClanova() throws Exception {
        return (ArrayList<Clan>) posaljiZahtev(Operacije.UCITAJ_LISTU_CLANOVA, null);
    }

    public boolean kreirajIznajmljivanje(HashMap<String, String> podaci) throws Exception {
        Primerak p = new Primerak();
        p.setSifraPrimerka(podaci.get("sifraPrimerka"));
        Clan c = new Clan();
        c.setSifraClana(podaci.get("sifraClana"));
        Administrator a = new Administrator();
        a.setSifraAdmina(podaci.get("sifraAdmina"));
        Iznajmljivanje i = new Iznajmljivanje(null, p, c, a, null, null);
        return (boolean) posaljiZahtev(Operacije.ZAPAMTI_IZNAJMLJIVANJE, i);
    }

    public void nadjiIznajmljenePrimerke(String sifraClana, EkranskaFormaVracanje efv) throws Exception {
        Clan clan = new Clan();
        clan.setSifraClana(sifraClana);
        ArrayList<Primerak> listaPrimeraka = (ArrayList<Primerak>) posaljiZahtev(Operacije.NADJI_IZNAJMLJENE_PRIMERKE, clan);
        ModelTabelePrimerci mtp = new ModelTabelePrimerci();
        mtp.setLista(listaPrimeraka);
        efv.setModelTabelePrimerci(mtp);
        efv.getTabelaPrimerci().setModel(mtp);
        JOptionPane.showMessageDialog(efv, "Sistem je našao iznajmljene primerke.");
    }

    public boolean vratiPrimerak(String sifraPrimerka) throws Exception {
        Primerak primerak = new Primerak();
        primerak.setSifraPrimerka(sifraPrimerka);
        return (boolean) posaljiZahtev(Operacije.VRATI_PRIMERAK, primerak);
        
    }

    public void zavrsiSaRadom(Administrator ulogovaniAdministrator) throws Exception {
        posaljiZahtev(Operacije.IZLOGUJ, ulogovaniAdministrator);
    }

      public void ucitajClanovePrimerkeIKnjige(EkranskaFormaIznajmljivanje efi) throws Exception {
        ArrayList<Knjiga> listaKnjiga = OpstiKontrolerKI.vratiInstancu().ucitajListuKnjiga();
        ArrayList<Primerak> listaPrimeraka = OpstiKontrolerKI.vratiInstancu().ucitajListuPrimeraka();
        ArrayList<Clan> listaClanova = OpstiKontrolerKI.vratiInstancu().ucitajListuClanova();

        ModelTabeleClanovi mtc = new ModelTabeleClanovi();
        mtc.setLista(listaClanova);
        efi.getTabelaClanovi().setModel(mtc);
        efi.setModelTabeleClanovi(mtc);

        ModelTabeleKnjige mtk = new ModelTabeleKnjige();
        mtk.setLista(listaKnjiga);
        efi.getTabelaKnjige().setModel(mtk);
        efi.setModelTabeleKnjige(mtk);

        ModelTabelePrimerci mtp = new ModelTabelePrimerci();
        mtp.setLista(listaPrimeraka);
        efi.getTabelaPrimerci().setModel(mtp);
        efi.setModelTabeleKnjige(mtk);

    }

    public void postaviPrimerke(String isbn, EkranskaFormaIznajmljivanje efi) throws Exception {
        ArrayList<Primerak> listaPrimeraka = (ArrayList<Primerak>) posaljiZahtev(Operacije.UCITAJ_LISTU_PRIMERAKA, isbn);
        ModelTabelePrimerci mtp = new ModelTabelePrimerci();
        mtp.setLista(listaPrimeraka);
        efi.setModelTabelePrimerci(mtp);
        efi.getTabelaPrimerci().setModel(mtp);
    }
    
    // Pomoćne metode
    
    public Administrator adminHashUadminObjekat(HashMap<String, String> adminHash) {
        Administrator administrator = new Administrator();
        administrator.setSifraAdmina(adminHash.get("SifraAdmina"));
        administrator.setKorisnickoIme(adminHash.get("KorisnickoIme"));
        administrator.setIme(adminHash.get("Ime"));
        administrator.setPrezime(adminHash.get("Prezime"));
        return administrator;
    }

    protected Object posaljiZahtev(int operacija, Object parametar) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(operacija);
        kz.setParametar(parametar);
        KomunikacijaSaServerom.vratiInstancu().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.vratiInstancu().procitajOdgovor();
        if (so.getUspesnost() == 1) {
            return so.getPodaci();
        } else {
            Exception ex = so.getException();
            throw ex;
        }
    }

    public void uspostaviKomunikaciju() throws IOException {
        if (KomunikacijaSaServerom.vratiInstancu().getSocket() == null) {
            Socket socket = new Socket("localhost", 9000);
            KomunikacijaSaServerom.vratiInstancu().setSocket(socket);
            System.out.println("Klijent je povezan na server.");
        }
    }

}