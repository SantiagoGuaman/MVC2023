/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author santi
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
    }

    public JDesktopPane getjDesktopPane1() {
        return dktprincipal;
    }

    public void setjDesktopPane1(JDesktopPane jDesktopPane1) {
        this.dktprincipal = jDesktopPane1;
    }

    public JMenu getMnuper() {
        return mnucrudpersona;
    }

    public void setMnuper(JMenu mnuper) {
        this.mnucrudpersona = mnuper;
    }

    public JMenu getMnupersona() {
        return mnucrudpersona;
    }

    public void setMnupersona(JMenu mnupersona) {
        this.mnucrudpersona = mnupersona;
    }

    public JButton getBtnlistarpersonas() {
        return btnlistarpersonas;
    }

    public void setBtnlistarpersonas(JButton btnlistarpersonas) {
        this.btnlistarpersonas = btnlistarpersonas;
    }

    public JButton getBtnpersona() {
        return btnpersona;
    }

    public void setBtnpersona(JButton btnpersona) {
        this.btnpersona = btnpersona;
    }

    public JButton getBtnproducto() {
        return btnproducto;
    }

    public void setBtnproducto(JButton btnproducto) {
        this.btnproducto = btnproducto;
    }

    public JDesktopPane getDktprincipal() {
        return dktprincipal;
    }

    public void setDktprincipal(JDesktopPane dktprincipal) {
        this.dktprincipal = dktprincipal;
    }

    public JMenuItem getMnilistapersonas() {
        return mnilistapersonas;
    }

    public void setMnilistapersonas(JMenuItem mnilistapersonas) {
        this.mnilistapersonas = mnilistapersonas;
    }

    public JMenuItem getMnipersonacrud() {
        return mnipersonacrud;
    }

    public void setMnipersonacrud(JMenuItem mnipersonacrud) {
        this.mnipersonacrud = mnipersonacrud;
    }

    public JMenu getMnucrudpersona() {
        return mnucrudpersona;
    }

    public void setMnucrudpersona(JMenu mnucrudpersona) {
        this.mnucrudpersona = mnucrudpersona;
    }

    public JMenu getMnuproductos() {
        return mnuproductos;
    }

    public void setMnuproductos(JMenu mnuproductos) {
        this.mnuproductos = mnuproductos;
    }

    public JMenu getMnuventas() {
        return mnuventas;
    }

    public void setMnuventas(JMenu mnuventas) {
        this.mnuventas = mnuventas;
    }

    public JButton getBtnpuntoventa() {
        return btnpuntoventa;
    }

    public void setBtnpuntoventa(JButton btnpuntoventa) {
        this.btnpuntoventa = btnpuntoventa;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnpersona = new javax.swing.JButton();
        btnlistarpersonas = new javax.swing.JButton();
        btnproducto = new javax.swing.JButton();
        btnpuntoventa = new javax.swing.JButton();
        dktprincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnucrudpersona = new javax.swing.JMenu();
        mnipersonacrud = new javax.swing.JMenuItem();
        mnilistapersonas = new javax.swing.JMenuItem();
        mnuproductos = new javax.swing.JMenu();
        mnuventas = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tienda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(864, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnpersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/client.png"))); // NOI18N

        btnlistarpersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/list.png"))); // NOI18N

        btnproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/product.png"))); // NOI18N

        btnpuntoventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/PuntoVenta.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnpersona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlistarpersonas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnproducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnpuntoventa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnlistarpersonas))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnproducto)
                            .addComponent(btnpersona, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnpuntoventa))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dktprincipalLayout = new javax.swing.GroupLayout(dktprincipal);
        dktprincipal.setLayout(dktprincipalLayout);
        dktprincipalLayout.setHorizontalGroup(
            dktprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dktprincipalLayout.setVerticalGroup(
            dktprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dktprincipal)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dktprincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mnucrudpersona.setText("Personas");

        mnipersonacrud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/client.png"))); // NOI18N
        mnipersonacrud.setText("Crear Persona");
        mnucrudpersona.add(mnipersonacrud);

        mnilistapersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/list.png"))); // NOI18N
        mnilistapersonas.setText("Lista Personas");
        mnucrudpersona.add(mnilistapersonas);

        jMenuBar1.add(mnucrudpersona);

        mnuproductos.setText("Productos");
        jMenuBar1.add(mnuproductos);

        mnuventas.setText("Ventas");
        jMenuBar1.add(mnuventas);

        jMenu1.setText("Reportes");
        jMenuBar1.add(jMenu1);

        jMenu4.setText("Ayuda");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlistarpersonas;
    private javax.swing.JButton btnpersona;
    private javax.swing.JButton btnproducto;
    private javax.swing.JButton btnpuntoventa;
    private javax.swing.JDesktopPane dktprincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenuItem mnilistapersonas;
    private javax.swing.JMenuItem mnipersonacrud;
    private javax.swing.JMenu mnucrudpersona;
    private javax.swing.JMenu mnuproductos;
    private javax.swing.JMenu mnuventas;
    // End of variables declaration//GEN-END:variables
}
