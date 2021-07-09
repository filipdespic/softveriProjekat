package so;

import db.DBBroker;
import exception.ServerskiException;

public abstract class OpstaSistemskaOperacija {

    protected DBBroker dbb;

    public OpstaSistemskaOperacija() {
        this.dbb = new DBBroker();
    }

    synchronized public void izvrsiOperaciju() throws ServerskiException {
        otvoriKonekciju();
        try {
            izvrsiKonkretnuOperaciju();
            potvrdiTransakciju();
        } catch (ServerskiException e) {
            ponistiTransakciju();
            throw e;
        } finally {
            zatvoriKonekciju();
        }
    }

    private void potvrdiTransakciju() throws ServerskiException {
        dbb.potvrdiTransakciju();
    }

    private void ponistiTransakciju() throws ServerskiException {
        dbb.ponistiTransakciju();
    }

    private void zatvoriKonekciju() throws ServerskiException {
        dbb.raskiniKonekciju();
    }

    private void otvoriKonekciju() throws ServerskiException {
        dbb.uspostaviKonekciju();
    }

    protected abstract void izvrsiKonkretnuOperaciju() throws ServerskiException;

}
