package server;

import java.io.IOException;
import java.util.List;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PokretanjeServeraNit extends Thread {

    private ServerSocket serverSocket;
    public static int brojPorta = 9000;
    static List<ObradaKlijentskihZahtevaNit> klijenti = new ArrayList<>();

    public PokretanjeServeraNit() {
        try {
            serverSocket = new ServerSocket(brojPorta);
            System.out.println("Server je pokrenut.");
        } catch (IOException ex) {
            System.out.println("Greska. Server socket nije kreiran.");
        }
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Socket socket = serverSocket.accept();
                ObradaKlijentskihZahtevaNit okz = new ObradaKlijentskihZahtevaNit(socket, klijenti);
                okz.start();
                klijenti.add(okz);
                System.out.println("Klijent je povezan na server!");
            }
        } catch (SocketException ex) {
            System.out.println("Prekinula se konekcija sa serverom");
        } catch (IOException e) {
            System.out.println("Greska prilikom povezivanja klijenta!");
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void zaustaviNiti() {
        try {
            serverSocket.close();
            for (ObradaKlijentskihZahtevaNit klijentNit : klijenti) {
                klijentNit.getSocket().close();
            }
        } catch (IOException ioe) {
            Logger.getLogger(PokretanjeServeraNit.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }
}
