package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Knjiga extends OpstiDomenskiObjekat{
    private String ISBN;
    private String nazivKnjige;
    private String autor;
    private int godinaObjavljivanja;

    public Knjiga() {
    }

    public Knjiga(String ISBN, String nazivKnjige, String autor, int godinaObjavljivanja) {
        this.ISBN = ISBN;
        this.nazivKnjige = nazivKnjige;
        this.autor = autor;
        this.godinaObjavljivanja = godinaObjavljivanja;
    }

    public int getGodinaObjavljivanja() {
        return godinaObjavljivanja;
    }

    public void setGodinaObjavljivanja(int godinaObjavljivanja) {
        this.godinaObjavljivanja = godinaObjavljivanja;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String vratiImeTabele() {
        return "knjiga";
    }

    @Override
    public String vratiParametre() {
         return String.format("'%s', '%s', '%s','%s'", ISBN, nazivKnjige, autor, godinaObjavljivanja);
    }

    @Override
    public String vratiPK() {
        return "ISBN";
    }

    @Override
    public String vratiVrednostPK() {
        return ISBN;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        
        
        List<OpstiDomenskiObjekat> knjige = new ArrayList<>();
        try {
            while (rs.next()) {
                String ISBN = rs.getString("ISBN");
                String nazivKnjige = rs.getString("NazivKnjige");
                String autor = rs.getString("Autor");
                int godinaObjavljivanja = rs.getInt("GodinaObjavljivanja");
                Knjiga k = new Knjiga(ISBN, nazivKnjige, autor, godinaObjavljivanja);
                knjige.add(k);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Greska kod RSuTabelu za Knjige");
        }
        return knjige;
    }

    @Override
    public String vratiUpdate() {
        throw new UnsupportedOperationException("Pozvana je metoda koja nije implementirana još");
    }

    @Override
    public void postaviVrednostPK(String pk) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
