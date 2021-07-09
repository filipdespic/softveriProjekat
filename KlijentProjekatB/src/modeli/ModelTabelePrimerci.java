package modeli;

import domen.Primerak;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabelePrimerci extends AbstractTableModel {

    private ArrayList<Primerak> lista = new ArrayList<>();
    String[] naziviKolona = {"Sifra primerka", "ISBN", "Izdavac"};

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
        Primerak p = lista.get(i);
        switch(i1){
            case 0: return p.getSifraPrimerka();
            case 1: return p.getISBN();
            case 2: return p.getIzdavac();
            default: return " ";
        }
    }

    @Override
    public String getColumnName(int i) {
        return naziviKolona[i];
    }

    public ArrayList<Primerak> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Primerak> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

}
