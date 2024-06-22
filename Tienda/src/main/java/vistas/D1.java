/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import clases.Venta;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luzne
 */
public class D1 extends javax.swing.JFrame {

    /**
     * Creates new form D1
     */
    String productos[] = {"Coca cola", "Papas fritas", "Nutella", "Jabon", "Shampoo", "Leche", "nugges", "cafe", "Helado", "Gomitas", "Cerveza"};
    double precios[] = {2500, 3600, 17000, 5000, 4200, 14000, 3250, 4950, 6000, 13600, 2000, 3200};
    double precio = 0;
    int cantidad = 0;
    DefaultTableModel modelo= new DefaultTableModel();
    ArrayList<Venta>listaVentas=new ArrayList<Venta>();
    
    public D1() {
        initComponents();
        this.setTitle("D1 PARA TODOS");
        this.setLocationRelativeTo(null);
        cerrar();
        DefaultComboBoxModel comboModel= new DefaultComboBoxModel(productos);
        cboProducto.setModel(comboModel);
        
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("PRECIO U");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("IMPORTE");
        actualizarTabla();
        calcularPrecio();
        
   }
    public void cerrar(){
        try{
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter()
            {
            public void windowClosing(WindowEvent e){
                confirmarsalida();
}
            });
        }catch(Exception e){

}
    }
    public void confirmarsalida(){
        int valor=JOptionPane.showConfirmDialog
          (this,"¿Desea cerrar la aplicación?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if(valor==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null,"Hasta pronto","",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        
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
        jLabel2 = new javax.swing.JLabel();
        lblImporte = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        spnCantidad = new javax.swing.JSpinner();
        cboProducto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblIVA = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(218, 8, 30));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel2.setText("PRODUCTO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 110, -1));

        lblImporte.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lblImporte.setText("$0.0 COP");
        lblImporte.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 120, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel4.setText("CANTIDAD");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 100, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel5.setText("IMPORTE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 90, -1));

        btnAgregar.setBackground(new java.awt.Color(218, 8, 30));
        btnAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\luzne\\OneDrive\\Documentos\\NetBeansProjects\\Tienda\\src\\main\\java\\imagen\\icon.png")); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, -1, 50));

        spnCantidad.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        spnCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCantidadStateChanged(evt);
            }
        });
        jPanel1.add(spnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, -1));

        cboProducto.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        cboProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductoActionPerformed(evt);
            }
        });
        jPanel1.add(cboProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 110, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel6.setText("PRECIO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 80, -1));

        lblPrecio.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lblPrecio.setText("$0.0 COP");
        lblPrecio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 120, -1));

        tblProductos.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 590, 180));

        jLabel13.setFont(new java.awt.Font("Stencil", 2, 36)); // NOI18N
        jLabel13.setText("TIENDA D1");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 280, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\luzne\\OneDrive\\Documentos\\NetBeansProjects\\Tienda\\src\\main\\java\\imagen\\Fondo.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 370));

        jLabel8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel8.setText("SUBTOTAL");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 100, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel9.setText("IVA");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 50, -1));

        lblSubtotal.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lblSubtotal.setText("$0.0 COP");
        lblSubtotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 100, -1));

        lblIVA.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lblIVA.setText("$0.0 COP");
        lblIVA.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, 110, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel12.setText("TOTAL");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 70, -1));

        lblTotal.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lblTotal.setText("$0.0 COP");
        lblTotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductoActionPerformed
        calcularPrecio();
    }//GEN-LAST:event_cboProductoActionPerformed

    private void spnCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCantidadStateChanged
       calcularPrecio();
    }//GEN-LAST:event_spnCantidadStateChanged

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Venta venta = new Venta();
        venta.setId(cboProducto.getSelectedIndex());
        venta.setDescripcion(cboProducto.getSelectedItem().toString());
        venta.setPrecio(precios[cboProducto.getSelectedIndex()]); // Asegurarse de obtener el precio correcto
        venta.setCantidad(cantidad);
        venta.setImporte(precio * cantidad);
        listaVentas.add(venta);
        actualizarTabla();
        borrar();
    }//GEN-LAST:event_btnAgregarActionPerformed
    
    public void borrar(){
        precio=0;
        cantidad=0;
    }
   
    public void  calcularPrecio(){
        precio=precios[cboProducto.getSelectedIndex()];
        cantidad=Integer.parseInt(spnCantidad.getValue().toString());
        lblPrecio.setText(aMoneda(precio));
        lblImporte.setText(aMoneda(precio*cantidad));
        
    }
    public String aMoneda(double precio){
        return "$" + Math.round(precio*100.00)/100.0+"COP";
    }
    
    public void actualizarTabla(){
        
        while(modelo.getRowCount()>0){
            modelo.removeRow(0);
            
        }
        double subtotal = 0;
        for(Venta v: listaVentas){
            Object x []= new Object[4];
            x[0]=v.getDescripcion();
            x[1]=aMoneda(v.getPrecio());
            x[2]=v.getCantidad();
            x[3]=aMoneda(v.getImporte());
            subtotal += v.getImporte();
            modelo.addRow(x);
        }
        double iva=subtotal*0.19;
        double total=subtotal+iva;
        lblSubtotal.setText(aMoneda(subtotal));
        lblIVA.setText(aMoneda(iva));
        lblTotal.setText(aMoneda(total));
        tblProductos.setModel(modelo);
        
    }
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
            java.util.logging.Logger.getLogger(D1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(D1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(D1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(D1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new D1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cboProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblImporte;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}