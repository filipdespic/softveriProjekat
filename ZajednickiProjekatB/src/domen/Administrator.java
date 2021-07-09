package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Administrator extends OpstiDomenskiObjekat {

    private String sifraAdmina;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String korisnickaLozinka;
    private boolean ulogovan;

    public Administrator() {
    }

    public Administrator(String sifraAdmina, String ime, String prezime, String korisnickoIme, String korisnickaLozinka, boolean ulogovan) {
        this.sifraAdmina = sifraAdmina;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.korisnickaLozinka = korisnickaLozinka;
        this.ulogovan = ulogovan;
    }

    public String getKorisnickaLozinka() {
        return korisnickaLozinka;
    }

    public void setKorisnickaLozinka(String korisnickaLozinka) {
        this.korisnickaLozinka = korisnickaLozinka;
    }

    public String getSifraAdmina() {
        return sifraAdmina;
    }

    public void setSifraAdmina(String sifraAdmina) {
        this.sifraAdmina = sifraAdmina;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public String vratiImeTabele() {
        return "administrator";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s', '%s'", sifraAdmina, ime, prezime, korisnickoIme, korisnickaLozinka);
    }

    @Override
    public String vratiPK() {
        return "sifraAdmina";
    }

    @Override
    public String vratiVrednostPK() {
        return sifraAdmina;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        List<OpstiDomenskiObjekat> administratori = new ArrayList<>();
        try {
            while (rs.next()) {
                String sifraAdmina = rs.getString("SifraAdmina");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                String korisnickoIme = rs.getString("KorisnickoIme");
                String korisnickaLozinka = rs.getString("KorisnickaLozinka");

                Administrator administrator = new Administrator(sifraAdmina, ime, prezime, korisnickoIme, korisnickaLozinka, false);
                administratori.add(administrator);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Greska kod RSuTabelu za Administratora");
        }
        return administratori;
    }

    @Override
    public String vratiUpdate() {
        throw new UnsupportedOperationException("Pozvana je metoda koja nije implementirana još"); 
    }

    @Override
    public void postaviVrednostPK(String pk) {
        throw new UnsupportedOperationException("Pozvana je metoda koja nije implementirana još"); 
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Administrator other = (Administrator) obj;
        if (!Objects.equals(this.korisnickaLozinka, other.korisnickaLozinka)) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return true;
    }

    public boolean isUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }

}
