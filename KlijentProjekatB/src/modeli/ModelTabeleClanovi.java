package modeli;

import domen.Clan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleClanovi extends AbstractTableModel{

    private ArrayList<Clan> lista = new ArrayList<>();
    String[] naziviKolona = {"Ime i prezime", "Šifra člana", "Telefon"};

    public ModelTabeleClanovi() {
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Clan c = lista.get(i);
        switch(i1){
            case 0: return c.getIme() + " " + c.getPrezime();
            case 1: return c.getSifraClana();
            case 2: return c.getTelefon();
            default: return " ";
        }
    }

    @Override
    public String getColumnName(int i) {
        return naziviKolona[i];
    }

    public ArrayList<Clan> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Clan> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
}
