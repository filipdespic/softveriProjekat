package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Clan extends OpstiDomenskiObjekat {

    private String sifraClana;
    private String JMBG;
    private String ime;
    private String prezime;
    private String telefon;
    private String email;

    public Clan() {
    }

    public Clan(String sifraClana, String JMBG, String ime, String prezime, String telefon, String email) {
        this.sifraClana = sifraClana;
        this.JMBG = JMBG;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifraClana() {
        return sifraClana;
    }

    public void setSifraClana(String sifraClana) {
        this.sifraClana = sifraClana;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String vratiImeTabele() {
        return "clan";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s', '%s', '%s'", sifraClana, JMBG, ime, prezime, telefon, email);
    }

    @Override
    public String vratiPK() {
        return "SifraClana";
    }

    @Override
    public String vratiVrednostPK() {
        return sifraClana;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        List<OpstiDomenskiObjekat> clanovi = new ArrayList<>();
        try {
            while (rs.next()) {
                String sifraClana = rs.getString("SifraClana");
                String JMBG = rs.getString("JMBG");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                String telefon = rs.getString("Telefon");
                String email = rs.getString("Email");
                
                Clan c = new Clan(sifraClana, JMBG, ime, prezime, telefon, email);
                clanovi.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Greska kod RSuTabelu za Clanove");
        }
        return clanovi;
    }

    @Override
    public String vratiUpdate() {
        return String.format("JMBG='%s',Ime='%s',Prezime='%s', Telefon='%s',Email='%s'", JMBG, ime,prezime,telefon, email);
    }

    @Override
    public void postaviVrednostPK(String pk) {
        this.sifraClana = pk;
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
        final Clan other = (Clan) obj;
        return true;
    }

    
}
