package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Iznajmljivanje extends OpstiDomenskiObjekat{
    
    private String sifraIznajmljivanja;
    private Primerak primerak;
    private Clan clan;
    private Administrator administrator;
    private Date datumIznajmljivanja;
    private Date datumVracanja;

    public Iznajmljivanje() {
    }

    public Iznajmljivanje(String sifraIznajmljivanja, Primerak primerak, Clan clan, Administrator administrator, Date datumIznajmljivanja, Date datumVracanja) {
        this.sifraIznajmljivanja = sifraIznajmljivanja;
        this.primerak = primerak;
        this.clan = clan;
        this.administrator = administrator;
        this.datumIznajmljivanja = datumIznajmljivanja;
        this.datumVracanja = datumVracanja;
    }

    public Date getDatumVracanja() {
        return datumVracanja;
    }

    public void setDatumVracanja(Date datumVracanja) {
        this.datumVracanja = datumVracanja;
    }

    public String getSifraIznajmljivanja() {
        return sifraIznajmljivanja;
    }

    public void setSifraIznajmljivanja(String sifraIznajmljivanja) {
        this.sifraIznajmljivanja = sifraIznajmljivanja;
    }

    public Primerak getPrimerak() {
        return primerak;
    }

    public void setPrimerak(Primerak primerak) {
        this.primerak = primerak;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Date getDatumIznajmljivanja() {
        return datumIznajmljivanja;
    }

    public void setDatumIznajmljivanja(Date datumIznajmljivanja) {
        this.datumIznajmljivanja = datumIznajmljivanja;
    }

    @Override
    public String vratiImeTabele() {
        return "iznajmljivanje";
    }

    @Override
    public String vratiParametre() {
         return String.format("'%s', '%s', '%s', '%s', '%s'", sifraIznajmljivanja, primerak.getSifraPrimerka(), clan.getSifraClana(), administrator.getSifraAdmina(), new java.sql.Date(datumIznajmljivanja.getTime()));
    }

    @Override
    public String vratiPK() {
        return "SifraIznajmljivanja";
    }

    @Override
    public String vratiVrednostPK() {
        return sifraIznajmljivanja;
    }


    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
         List<OpstiDomenskiObjekat> iznajmljivanja = new ArrayList<>();
        try {
            while (rs.next()) {
                String sifraIznajmljivanja = rs.getString("SifraIznajmljivanja");
                String sifraPrimerka = rs.getString("SifraPrimerka");
                String sifraClana = rs.getString("SifraClana");
                String sifraAdmina = rs.getString("SifraAdmina");
                java.sql.Date datumIznajmljivanja = rs.getDate("DatumIznajmljivanja");
                java.sql.Date datumVracanja = rs.getDate("DatumVracanja");
                
                Clan c = new Clan();
                c.setSifraClana(sifraClana);
                
                Primerak p = new Primerak();
                p.setSifraPrimerka(sifraPrimerka);
                
                Administrator a = new Administrator();
                a.setSifraAdmina(sifraAdmina);
                
                Date datumIznajmljivanjaUtil = new Date(datumIznajmljivanja.getTime());
                Date datumVracanjaUtil;
                if(datumVracanja != null){
                datumVracanjaUtil = new Date(datumVracanja.getTime());
                }else{
                datumVracanjaUtil = null;
                }
                Iznajmljivanje i = new Iznajmljivanje(sifraIznajmljivanja, p, c, a, datumIznajmljivanjaUtil, datumVracanjaUtil);
                iznajmljivanja.add(i);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Greska kod RSuTabelu za Iznajmljivanja");
        }
        return iznajmljivanja;
    }

    @Override
    public String vratiUpdate() {
        throw new UnsupportedOperationException("Pozvana metoda nije još implementirana."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postaviVrednostPK(String pk) {
        this.sifraIznajmljivanja = pk;
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
        final Iznajmljivanje other = (Iznajmljivanje) obj;
        return true;
    }
    
    
    
}
