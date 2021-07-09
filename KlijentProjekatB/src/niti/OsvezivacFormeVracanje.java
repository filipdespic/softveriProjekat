package niti;

import forme.EkranskaFormaVracanje;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OsvezivacFormeVracanje extends Thread {

    private EkranskaFormaVracanje efv;
    private boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            try {
                efv.osveziTabeluClanova();
                sleep(1000);
            } catch (Exception ex) {
                Logger.getLogger(OsvezivacFormeVracanje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public EkranskaFormaVracanje getEfv() {
        return efv;
    }

    public void setEfv(EkranskaFormaVracanje efv) {
        this.efv = efv;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

}
