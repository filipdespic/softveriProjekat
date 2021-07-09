package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public abstract class OpstiDomenskiObjekat implements Serializable {
    
    public abstract String vratiImeTabele();
    public abstract String vratiParametre();
    public abstract String vratiPK();
    public abstract String vratiVrednostPK();
    public abstract List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs);
    public abstract String vratiUpdate();
    public abstract void postaviVrednostPK(String pk);

}
