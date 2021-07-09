package so;

import domen.Iznajmljivanje;
import exception.ServerskiException;
import java.util.Date;

public class SOZapamtiIznajmljivanje extends OpstaSistemskaOperacija{

    private Iznajmljivanje iznajmljivanje;
    private boolean uspesno = false;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        String sifraIznajmljivanja = Integer.toString((int) (new Date().getTime() / 1000)); 
        iznajmljivanje.setDatumIznajmljivanja(new Date());
        iznajmljivanje.setSifraIznajmljivanja(sifraIznajmljivanja);
        if(dbb.sacuvajIznajmljivanje(iznajmljivanje) != null) uspesno = true;
    }

    public Iznajmljivanje getIznajmljivanje() {
        return iznajmljivanje;
    }

    public void setIznajmljivanje(Iznajmljivanje iznajmljivanje) {
        this.iznajmljivanje = iznajmljivanje;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }
    
}
