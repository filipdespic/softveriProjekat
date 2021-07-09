package modeli;

import domen.Knjiga;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleKnjige extends AbstractTableModel{
    
    private ArrayList<Knjiga> lista = new ArrayList<>();
    String[] naziviKolona = {"Naziv knjige", "Autor", "Godina objavljivanja", "ISBN"};
    
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
        Knjiga k = lista.get(i);
        switch(i1){
            case 0: return k.getNazivKnjige();
            case 1: return k.getAutor();
            case 2: return k.getGodinaObjavljivanja();
            case 3: return k.getISBN();
            default: return "/";
        }
    }

    @Override
    public String getColumnName(int i) {
        return naziviKolona[i];
    }

    
    public ArrayList<Knjiga> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Knjiga> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public void dodajUListu(Knjiga k){
        this.lista.add(k);
        this.fireTableDataChanged();
    }
}
