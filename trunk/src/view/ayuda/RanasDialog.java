/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HermanosDialog.java
 *
 * Created on 24-ene-2010, 17:26:13
 */

package view.ayuda;

/**
 *
 * @author Alicia
 */
public class RanasDialog extends javax.swing.JDialog {

    /** Creates new form HermanosDialog */
    public RanasDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        RanasPanel pnlFondo = new RanasPanel();

        this.add(pnlFondo);

        this.pack();
        this.setTitle("Ayuda - Juego de las Ranas Saltarinas");

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
            .addGap(0, 417, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RanasDialog dialog = new RanasDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
