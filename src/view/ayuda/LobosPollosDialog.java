/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LobosPollosDialog.java
 *
 * Created on 24-ene-2010, 17:13:04
 */

package view.ayuda;

/**
 *
 * @author Alicia
 */
public class LobosPollosDialog extends javax.swing.JDialog {

    /** Creates new form LobosPollosDialog */
    public LobosPollosDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);


        LobosPollosPanel pnlFondo = new LobosPollosPanel();

        this.add(pnlFondo);

        this.pack();
        this.setTitle("Ayuda - Juego de los lobos y los pollitos");

        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LobosPollosDialog dialog = new LobosPollosDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
