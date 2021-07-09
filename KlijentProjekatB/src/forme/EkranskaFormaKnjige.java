package forme;

import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroleriKI.OpstiKontrolerKI;

public class EkranskaFormaKnjige extends OpstaEkranskaForma {

    /**
     * Creates new form EkranskaFormaKnjiga
     */
    public EkranskaFormaKnjige() {
        initComponents();
        postaviImeForme();
        postaviToolTipove();
        zakljucajPamcenjeKnjige();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnKreirajNovuKnjigu = new javax.swing.JButton();
        btnZapamtiKnjigu = new javax.swing.JButton();
        labelaNapomena = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtGodOb = new javax.swing.JTextField();
        txtISBN = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnKreirajNovuKnjigu.setText("Kreiraj novu knjigu");
        btnKreirajNovuKnjigu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajNovuKnjiguActionPerformed(evt);
            }
        });

        btnZapamtiKnjigu.setText("Zapamti knjigu");
        btnZapamtiKnjigu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZapamtiKnjiguActionPerformed(evt);
            }
        });

        labelaNapomena.setText("Napomena(?)");

        jLabel1.setText("Naziv:");

        jLabel2.setText("Autor:");

        jLabel3.setText("Godina objavljivanja:");

        jLabel4.setText("ISBN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNaziv))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(txtAutor))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtISBN))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnZapamtiKnjigu, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(labelaNapomena))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnKreirajNovuKnjigu, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGodOb, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKreirajNovuKnjigu)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGodOb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZapamtiKnjigu)
                    .addComponent(labelaNapomena))
                .addContainerGap())
        );

        jButton1.setText("Nazad na glavnu formu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nazadNaGlavnuFormu();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnKreirajNovuKnjiguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajNovuKnjiguActionPerformed
        HashMap<String, String> novaKnjiga = kreirajObjekat();
        if (novaKnjiga != null) {
            popuniPolja(novaKnjiga);
            btnZapamtiKnjigu.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Sistem je kreirao novu knjigu.");
        }
    }//GEN-LAST:event_btnKreirajNovuKnjiguActionPerformed

    private void btnZapamtiKnjiguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZapamtiKnjiguActionPerformed
        if (ispravnoUnetiPodaci()) {
            try {
                zapamtiKnjigu();
            } catch (Exception ex) {
                Logger.getLogger(EkranskaFormaKnjige.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Neispravan unos, pogledajte napomenu za više informacija.");
        }
    }//GEN-LAST:event_btnZapamtiKnjiguActionPerformed

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
            java.util.logging.Logger.getLogger(EkranskaFormaKnjige.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EkranskaFormaKnjige.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EkranskaFormaKnjige.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EkranskaFormaKnjige.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EkranskaFormaKnjige().setVisible(true);
            }
        });
    }

    @Override
    HashMap<String, String> kreirajObjekat() {
        try {
            return OpstiKontrolerKI.vratiInstancu().kreirajObjekat("knjiga");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da kreira knjigu", "Greška", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    void postaviImeForme() {
        this.setTitle("Forma za rad sa knjigama");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreirajNovuKnjigu;
    private javax.swing.JButton btnZapamtiKnjigu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelaNapomena;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtGodOb;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables


    @Override
    void postaviToolTipove() {
        labelaNapomena.setToolTipText("Naziv i autor knjige ne smeju biti prazni niti podrazumevani tekst. ISBN mora biti 10 ili 13 cifara. Godina objavljivanja mora biti broj.");
    }

    private void zapamtiKnjigu() throws Exception {
        HashMap<String, String> hashMapKnjige = pokupiPodatke();
        if (OpstiKontrolerKI.vratiInstancu().zapamtiObjekat(hashMapKnjige)) {
            btnZapamtiKnjigu.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio knjigu: \n Naziv knjige: " + hashMapKnjige.get("naziv")
                    + "\n Autor: " + hashMapKnjige.get("autor")
                    + "\n Godina objavljivanja: " + hashMapKnjige.get("godina")
                    + "\n ISBN: " + hashMapKnjige.get("isbn"));
            isprazniPolja();
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti knjigu.");
        }
    }

    private void popuniPolja(HashMap<String, String> novaKnjiga) {
        txtAutor.setText(novaKnjiga.get("autor"));
        txtGodOb.setText(novaKnjiga.get("godina"));
        txtNaziv.setText(novaKnjiga.get("naziv"));
        txtISBN.setText(novaKnjiga.get("isbn"));
    }

    private HashMap<String, String> pokupiPodatke() {
        HashMap<String, String> hashMapKnjige = new HashMap<>();
        hashMapKnjige.put("tip", "knjiga");
        hashMapKnjige.put("isbn", txtISBN.getText());
        hashMapKnjige.put("naziv", txtNaziv.getText());
        hashMapKnjige.put("autor", txtAutor.getText());
        hashMapKnjige.put("godina", txtGodOb.getText());
        return hashMapKnjige;
    }

    private void isprazniPolja() {
        txtAutor.setText("");
        txtGodOb.setText("");
        txtNaziv.setText("");
        txtISBN.setText("");
    }

    private void zakljucajPamcenjeKnjige() {
        btnZapamtiKnjigu.setEnabled(false);
    }

    //validacije 
    private boolean ispravnoUnetiPodaci() {
        if (ispravnoUnetNaziv() && ispravnoUnetAutor() && ispravnoUnetaGodina() && ispravnoUnetISBN()) {
            return true;
        }
        return false;
    }

    private boolean ispravnoUnetNaziv() {
        String naziv = txtNaziv.getText();
        if (naziv.length() > 1) {
            return true;
        }
        return false;
    }

    private boolean ispravnoUnetAutor() {
        String autor = txtAutor.getText();
        if (autor.length() > 1) {
            return true;
        }
        return false;
    }

    private boolean ispravnoUnetaGodina() {
        String godina = txtGodOb.getText();
        int trenutnaGodina = Calendar.getInstance().get(Calendar.YEAR);
        if (Integer.parseInt(godina) > 0 && Integer.parseInt(godina) <= trenutnaGodina) {
            return true;
        }
        return false;
    }

    private boolean ispravnoUnetISBN() {
        String ISBN = txtISBN.getText();
        if (ISBN.length() == 10 || ISBN.length() == 13) {
            return true;
        }
        return false;
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
}