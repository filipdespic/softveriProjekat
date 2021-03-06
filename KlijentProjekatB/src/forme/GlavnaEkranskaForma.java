package forme;

import domen.Administrator;
import domen.Clan;
import domen.Iznajmljivanje;
import domen.Knjiga;
import domen.OpstiDomenskiObjekat;
import domen.Primerak;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroleriKI.OpstiKontrolerKI;

public class GlavnaEkranskaForma extends OpstaEkranskaForma {

    private Administrator ulogovaniAdministrator;

    /**
     * Creates new form GlavnaKlijentskaForma
     */
    public GlavnaEkranskaForma() {
        initComponents();
        postaviImeForme();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelaImePrezime = new javax.swing.JLabel();
        btnRadSaKnjigama = new javax.swing.JButton();
        btnRadSaPrimercima = new javax.swing.JButton();
        btnRadSaIznajmljivanjima = new javax.swing.JButton();
        btnRadSaClanovima = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnVracanjePrimerka = new javax.swing.JButton();
        btnZavrsi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Dobrodošli, ");

        labelaImePrezime.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelaImePrezime.setText("jLabel2");

        btnRadSaKnjigama.setText("Rad sa knjigama");
        btnRadSaKnjigama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadSaKnjigamaActionPerformed(evt);
            }
        });

        btnRadSaPrimercima.setText("Rad sa primercima");
        btnRadSaPrimercima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadSaPrimercimaActionPerformed(evt);
            }
        });

        btnRadSaIznajmljivanjima.setText("Iznajmljivanje primerka");
        btnRadSaIznajmljivanjima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadSaIznajmljivanjimaActionPerformed(evt);
            }
        });

        btnRadSaClanovima.setText("Rad sa članovima ");
        btnRadSaClanovima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadSaClanovimaActionPerformed(evt);
            }
        });

        jLabel3.setText("Odaberite opciju iz menija:");

        btnVracanjePrimerka.setText("Vraćanje primerka");
        btnVracanjePrimerka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVracanjePrimerkaActionPerformed(evt);
            }
        });

        btnZavrsi.setBackground(new java.awt.Color(255, 0, 0));
        btnZavrsi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnZavrsi.setForeground(new java.awt.Color(255, 255, 255));
        btnZavrsi.setText("Završi sa radom");
        btnZavrsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZavrsiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRadSaKnjigama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelaImePrezime))
                            .addComponent(jLabel3))
                        .addGap(0, 137, Short.MAX_VALUE))
                    .addComponent(btnRadSaPrimercima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRadSaClanovima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRadSaIznajmljivanjima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVracanjePrimerka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnZavrsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelaImePrezime))
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btnRadSaKnjigama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRadSaPrimercima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRadSaClanovima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRadSaIznajmljivanjima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVracanjePrimerka)
                .addGap(47, 47, 47)
                .addComponent(btnZavrsi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRadSaKnjigamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadSaKnjigamaActionPerformed
        try {
            otvoriFormu(new Knjiga());
        } catch (Exception ex) {
            Logger.getLogger(GlavnaEkranskaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRadSaKnjigamaActionPerformed

    private void btnRadSaPrimercimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadSaPrimercimaActionPerformed
        try {
            otvoriFormu(new Primerak());
        } catch (Exception ex) {
            Logger.getLogger(GlavnaEkranskaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRadSaPrimercimaActionPerformed

    private void btnRadSaClanovimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadSaClanovimaActionPerformed
        try {
            otvoriFormu(new Clan());
        } catch (Exception ex) {
            Logger.getLogger(GlavnaEkranskaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRadSaClanovimaActionPerformed

    private void btnRadSaIznajmljivanjimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadSaIznajmljivanjimaActionPerformed
        try {
            otvoriFormu(new Iznajmljivanje());
        } catch (Exception ex) {
            Logger.getLogger(GlavnaEkranskaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRadSaIznajmljivanjimaActionPerformed

    private void btnVracanjePrimerkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVracanjePrimerkaActionPerformed
        otvoriFormuVracanje();
    }//GEN-LAST:event_btnVracanjePrimerkaActionPerformed

    private void btnZavrsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZavrsiActionPerformed
        zavrsiSaRadom();
    }//GEN-LAST:event_btnZavrsiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GlavnaEkranskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GlavnaEkranskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GlavnaEkranskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GlavnaEkranskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GlavnaEkranskaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRadSaClanovima;
    private javax.swing.JButton btnRadSaIznajmljivanjima;
    private javax.swing.JButton btnRadSaKnjigama;
    private javax.swing.JButton btnRadSaPrimercima;
    private javax.swing.JButton btnVracanjePrimerka;
    private javax.swing.JButton btnZavrsi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelaImePrezime;
    // End of variables declaration//GEN-END:variables

    public Administrator getUlogovaniAdministrator() {
        return ulogovaniAdministrator;
    }

    public void setUlogovaniAdministrator(Administrator ulogovaniAdministrator) {
        this.ulogovaniAdministrator = ulogovaniAdministrator;
        labelaImePrezime.setText(ulogovaniAdministrator.getIme() + " " + ulogovaniAdministrator.getPrezime());
    }

    @Override
    void postaviImeForme() {
        this.setTitle("Glavna forma");
    }

    private void otvoriFormu(OpstiDomenskiObjekat odo) throws Exception {
        OpstaEkranskaForma opf;
        if (odo instanceof Knjiga) {
            opf = new EkranskaFormaKnjige();
        } else if (odo instanceof Primerak) {
            opf = new EkranskaFormaPrimerak();
        } else if (odo instanceof Clan) {
            opf = new EkranskaFormaClanovi();
        } else if (odo instanceof Iznajmljivanje) {
            opf = new EkranskaFormaIznajmljivanje();
        } else {
            throw new Exception("Uneti objekat nema svoju ekransku formu");
        }
        opf.setVisible(true);
        this.setVisible(false);
        opf.glavna = this;
    }

    private void otvoriFormuVracanje() {
        OpstaEkranskaForma opf = new EkranskaFormaVracanje();
        opf.setVisible(true);
        this.setVisible(false);
        opf.glavna = this;
    }

    private void zavrsiSaRadom() {
        try {
            OpstiKontrolerKI.vratiInstancu().zavrsiSaRadom(ulogovaniAdministrator);
            dispose();
            EkranskaFormaLogovanje efl = new EkranskaFormaLogovanje();
            efl.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Nije moguće izlogovati se u datom trenutku.");
        }
    }

    //neimplementirane metode
    @Override
    void postaviModeleTabela() {
        throw new UnsupportedOperationException("Metoda koju ste pozvali nije još implementirana.");
    }

    @Override
    void popuniTabele() {
        throw new UnsupportedOperationException("Metoda koju ste pozvali nije još implementirana.");
    }

    @Override
    void postaviToolTipove() {
        throw new UnsupportedOperationException("Metoda koju ste pozvali nije još implementirana.");
    }

    @Override
    HashMap<String, String> kreirajObjekat() {
        throw new UnsupportedOperationException("Metoda koju ste pozvali nije još implementirana."); //To change body of generated methods, choose Tools | Templates.
    }
}
