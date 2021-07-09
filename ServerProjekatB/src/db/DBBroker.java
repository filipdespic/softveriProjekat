package db;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import domen.Administrator;
import domen.Clan;
import domen.Iznajmljivanje;
import domen.Knjiga;
import domen.OpstiDomenskiObjekat;
import domen.Primerak;
import exception.ServerskiException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import zastita.HashFunkcija;

public class DBBroker {

    private Connection konekcija;

    public DBBroker() {

    }

    public void uspostaviKonekciju() throws ServerskiException {
        try {
            Class.forName(Util.getInstance().getDriver());
            String url = Util.getInstance().getURL();
            String user = Util.getInstance().getUser();
            String password = Util.getInstance().getPassword();
            konekcija = DriverManager.getConnection(url, user, password);
            konekcija.setAutoCommit(false);

        } catch (IOException ex) {
            throw new ServerskiException("Greska kod citanja iz properties fajla!");
        } catch (ClassNotFoundException ex) {
            throw new ServerskiException("Drajver nije pronadjen!");
        } catch (SQLException ex) {
            throw new ServerskiException("Konekcija na bazu neuspesna!");
        }
    }

    public void raskiniKonekciju() throws ServerskiException {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            throw new ServerskiException("Raskidanje konekcije neuspesno!");
        }
    }

    public void potvrdiTransakciju() throws ServerskiException {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            throw new ServerskiException("Transakcija nije uspesno potvrdjena");
        }
    }

    public void ponistiTransakciju() throws ServerskiException {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            throw new ServerskiException("Transakcija nije uspesno ponistena");
        }
    }

    public Administrator prijaviAdministratora(Administrator administrator) throws ServerskiException {
        try {
            String upit = "SELECT * FROM administrator a WHERE a.KorisnickoIme = ?";
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.setString(1, administrator.getKorisnickoIme());
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getString("KorisnickaLozinka").equals(HashFunkcija.napraviHash(administrator.getKorisnickaLozinka()))) {
                administrator.setSifraAdmina(rs.getString("a.SifraAdmina"));
                administrator.setKorisnickaLozinka(rs.getString("a.KorisnickaLozinka"));
                administrator.setIme(rs.getString("a.Ime"));
                administrator.setPrezime(rs.getString("a.Prezime"));
                return administrator;
            }
        } catch (SQLException ex) {
            throw new ServerskiException("Greska pri traženju administratora");
        }
        return new Administrator();
    }

    public List<OpstiDomenskiObjekat> vratiSveObjekte(OpstiDomenskiObjekat o) throws ServerskiException {
        try {
            String upit = "SELECT * FROM " + o.vratiImeTabele();
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<OpstiDomenskiObjekat> listaObjekata = o.RSuTabelu(rs);
            s.close();
            return listaObjekata;
        } catch (SQLException ex) {
            throw new ServerskiException("Server ne moze da prikaže podatke o " + o.getClass().getName() + ".");
        }
    }

    public OpstiDomenskiObjekat vratiObjekatPoKljucu(OpstiDomenskiObjekat o, String ID) throws ServerskiException {
        String upit = "SELECT * FROM " + o.vratiImeTabele() + " WHERE " + o.vratiPK() + "=" + "'" + ID + "'";
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<OpstiDomenskiObjekat> listaObjekata = o.RSuTabelu(rs);
            s.close();
            return listaObjekata.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException(ex.getMessage());
        }
    }

    public OpstiDomenskiObjekat izmeniObjekat(OpstiDomenskiObjekat o) {
        String upit = String.format("UPDATE %s SET %s WHERE %s = '%s'", o.vratiImeTabele(), o.vratiUpdate(), o.vratiPK(), o.vratiVrednostPK());
        try {
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            s.close();
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public OpstiDomenskiObjekat obrisiObjekat(OpstiDomenskiObjekat o) throws ServerskiException {
        try {
            String upit = String.format("DELETE FROM %s WHERE %s = %s", o.vratiImeTabele(), o.vratiPK(), o.vratiVrednostPK());
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException(ex.getMessage());
        }
        return o;
    }

    public ArrayList<Primerak> nadjiPrimerke(String isbn) throws ServerskiException {
        ArrayList<Primerak> listaPrimeraka = new ArrayList<>();
        try {
            String upit = "SELECT * FROM primerak WHERE ISBN = '" + isbn + "'";
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<OpstiDomenskiObjekat> listaObjekata = new Primerak().RSuTabelu(rs);
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaObjekata) {
                Primerak p = (Primerak) opstiDomenskiObjekat;
                listaPrimeraka.add(p);
            }
            s.close();
        } catch (SQLException ex) {
            throw new ServerskiException("Server ne moze da pronadje primerke");
        }
        return listaPrimeraka;
    }

    public OpstiDomenskiObjekat sacuvajObjekat(OpstiDomenskiObjekat o) throws ServerskiException {
        try {
            String upit = String.format("INSERT INTO %s VALUES (%s)", o.vratiImeTabele(), o.vratiParametre());
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            s.close();
            return o;
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new ServerskiException("Neispravno uneti podaci, potencijalno narusavanje integriteta baze podataka.");
        } catch (SQLException ex) {
            throw new ServerskiException("Greska u SQL upitu.");
        }
    }

    public ArrayList<Knjiga> nadjiKnjige(HashMap<String, String> kriterijum) throws ServerskiException {
        String upit = "SELECT * FROM knjiga k";
        ArrayList<Knjiga> listaKnjiga = new ArrayList<>();
        if (kriterijum.size() > 0) {
            upit += " WHERE ";
        }
        if (kriterijum.get("naziv") != null) {
            upit += "k.NazivKnjige LIKE '%" + kriterijum.get("naziv") + "%' AND ";
        }
        if (kriterijum.get("autor") != null) {
            upit += "k.Autor LIKE '%" + kriterijum.get("autor") + "%' AND ";
        }
        if (kriterijum.get("ISBN") != null) {
            upit += "k.ISBN = '" + kriterijum.get("ISBN") + "' AND ";
        }
        if (kriterijum.get("godina") != null) {
            upit += "k.GodinaObjavljivanja = " + kriterijum.get("godina");
        }
        if (upit.substring(upit.length() - 4, upit.length()).equals("AND ")) {
            upit = upit.substring(0, upit.length() - 4);
        }
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            ArrayList<OpstiDomenskiObjekat> odoLista = (ArrayList<OpstiDomenskiObjekat>) new Knjiga().RSuTabelu(rs);
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : odoLista) {
                listaKnjiga.add((Knjiga) opstiDomenskiObjekat);
            }
        } catch (SQLException ex) {
            throw new ServerskiException("Greski pri kreiranju upita");
        }
        return listaKnjiga;
    }

    public ArrayList<Clan> nadjiClanove(HashMap<String, String> kriterijum) throws ServerskiException {
        String upit = "SELECT * FROM clan c";
        ArrayList<Clan> listaClanova = new ArrayList<>();
        if (kriterijum.size() > 0) {
            upit += " WHERE ";
        }
        if (kriterijum.get("ime") != null) {
            upit += "c.Ime LIKE '%" + kriterijum.get("ime") + "%' AND ";
        }
        if (kriterijum.get("prezime") != null) {
            upit += "c.Prezime LIKE '%" + kriterijum.get("prezime") + "%' AND ";
        }
        if (kriterijum.get("JMBG") != null) {
            upit += "c.JMBG = '" + kriterijum.get("jmbg") + "' AND ";
        }
        if (kriterijum.get("sifra") != null) {
            upit += "c.SifraClana = '" + kriterijum.get("sifra") + "'";
        }
        if (upit.substring(upit.length() - 4, upit.length()).equals("AND ")) {
            upit = upit.substring(0, upit.length() - 4);
        }
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            ArrayList<OpstiDomenskiObjekat> odoLista = (ArrayList<OpstiDomenskiObjekat>) new Clan().RSuTabelu(rs);
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : odoLista) {
                listaClanova.add((Clan) opstiDomenskiObjekat);
            }
        } catch (SQLException ex) {
            throw new ServerskiException("Greski pri kreiranju upita");
        }
        return listaClanova;
    }

    public ArrayList<Primerak> nadjiIznajmljenePrimerke(Clan clan) throws ServerskiException {
        ArrayList<Primerak> listaPrimeraka = new ArrayList<>();
        try {
            String upit = "SELECT p.* FROM iznajmljivanje i JOIN primerak p ON i.SifraPrimerka = p.SifraPrimerka WHERE i.SifraClana = '" + clan.getSifraClana() + "' AND i.DatumVracanja IS NULL";
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<OpstiDomenskiObjekat> listaObjekata = new Primerak().RSuTabelu(rs);
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaObjekata) {
                Primerak p = (Primerak) opstiDomenskiObjekat;
                listaPrimeraka.add(p);
            }
            s.close();
        } catch (SQLException ex) {
            throw new ServerskiException("Server ne moze da pronadje primerke");
        }
        return listaPrimeraka;
    }

    public boolean vratiPrimerak(Primerak primerak) {
        try {
            PreparedStatement ps = konekcija.prepareStatement("UPDATE iznajmljivanje SET DatumVracanja = CURDATE() WHERE SifraPrimerka = ?");
            ps.setString(1, primerak.getSifraPrimerka());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Primerak> ucitajListuPrimeraka(String isbn) throws ServerskiException {
        ArrayList<Primerak> listaPrimeraka = new ArrayList<>();
        try {
            String upit;
            if (isbn != null) {
                upit = "SELECT * FROM primerak p WHERE p.SifraPrimerka "
                        + "NOT IN (SELECT SifraPrimerka FROM iznajmljivanje WHERE iznajmljivanje.DatumVracanja IS NULL)"
                        + " AND p.ISBN = '" + isbn + "'";
            } else {
                upit = "SELECT * FROM primerak p WHERE p.SifraPrimerka "
                        + "NOT IN (SELECT SifraPrimerka FROM iznajmljivanje WHERE iznajmljivanje.DatumVracanja IS NULL)";
            }
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<OpstiDomenskiObjekat> listaObjekata = new Primerak().RSuTabelu(rs);
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaObjekata) {
                Primerak p = (Primerak) opstiDomenskiObjekat;
                listaPrimeraka.add(p);
            }
            s.close();
        } catch (SQLException ex) {
            throw new ServerskiException("Server ne moze da pronadje primerke");
        }
        return listaPrimeraka;
    }

    public OpstiDomenskiObjekat sacuvajIznajmljivanje(Iznajmljivanje i) throws ServerskiException {
        try {
            String upit = String.format("INSERT INTO iznajmljivanje(SifraIznajmljivanja, SifraPrimerka, SifraClana, SifraAdmina, DatumIznajmljivanja) VALUES (%s)", i.vratiParametre());
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            s.close();
            return i;
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new ServerskiException("Neispravno uneti podaci, potencijalno narusavanje integriteta baze podataka.");
        } catch (SQLException ex) {
            throw new ServerskiException("Greska u SQL upitu.");
        }
    }

}
