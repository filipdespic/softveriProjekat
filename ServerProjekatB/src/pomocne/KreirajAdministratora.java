package pomocne;

import domen.Administrator;
import exception.ServerskiException;
import zastita.HashFunkcija;

public class KreirajAdministratora {
    public static void main(String[] args) {
        Administrator a = new Administrator("333", "Filip", "Despic", "fil", HashFunkcija.napraviHash("des"), false);
        try {
            kontroler.Kontroler.vratiInstancu().kreirajAdministratora(a);
        } catch (ServerskiException ex) {
            System.out.println("Novi administrator nije kreiran.");
        }
    }
}
