/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Autor: Ing. Esduardo Del Aguila
//Objetivo:  Mantenimiento de cursos permitirà realizar el CRUD  a la respectiva tabla en la BD
package vista;

import modelo.BodegaDAO;
import controlador.Bodega;
import controlador.Bodega;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import controlador.clsBitacora;
import controlador.clsUsuarioConectado;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;



/**
 *
 * @author visitante
 */
public class MantenimientoBodega extends javax.swing.JInternalFrame {

    int codigoAplicacion = 2000;
    clsBitacora Auditoria = new clsBitacora();
  
    public void llenadoDeCombos() {
       /*EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> empleados = empleadoDAO.select();
        cbox_empleado.addItem("Seleccione una opción");
        for (int i = 0; i < empleados.size(); i++) {
            cbox_empleado.addItem(empleados.get(i).getNombreEmpleado());
        }*/
    }

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Bodega");
        modelo.addColumn("Tipo bodega");
        modelo.addColumn("nombre");
        modelo.addColumn("direccion");
        modelo.addColumn("Estatus");
        BodegaDAO bodegaDAO = new BodegaDAO();
        List<Bodega> bodega = bodegaDAO.select();
        tablaVendedores.setModel(modelo);
        String[] dato = new String[5];
        for (int i = 0; i < bodega.size(); i++) {
            dato[0] = bodega.get(i).getPkid();
            dato[1] = bodega.get(i).getTipo_bodea();
            dato[2] = bodega.get(i).getNombre();
            dato[3] = bodega.get(i).getDireccion();
            dato[4] = bodega.get(i).getEstado();
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void buscarVendedor() {
    Bodega bodegaAConsultar = new Bodega();
    BodegaDAO bodegaDAO = new BodegaDAO();
    bodegaAConsultar.setPkid(txtbuscado.getText());
    
    // Realiza la consulta
    bodegaAConsultar = bodegaDAO.query(bodegaAConsultar);
    
    // Verifica si se obtuvo una bodega
    if (bodegaAConsultar != null) {
        txtCodigo.setText(bodegaAConsultar.getPkid());
        txttipo.setText(bodegaAConsultar.getTipo_bodea());
        txtNombre.setText(bodegaAConsultar.getNombre());
        txtdireccion.setText(bodegaAConsultar.getDireccion());
        txtestatus.setText(bodegaAConsultar.getEstado());
    } else {
        // Maneja el caso en el que no se encuentra la bodega
        JOptionPane.showMessageDialog(null, "Bodega no encontrada");
        txtCodigo.setText("");
        txttipo.setText("");
        txtNombre.setText("");
        txtdireccion.setText("");
        txtestatus.setText("");
    }
}


    public MantenimientoBodega() {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        txtestatus = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        btnAyuda = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();
        label7 = new javax.swing.JLabel();
        btnReporte1 = new javax.swing.JButton();
        label8 = new javax.swing.JLabel();
        txttipo = new javax.swing.JTextField();
        label9 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("2000 Mantenimiento Cursos");
        setVisible(true);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Cursos");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Codigo");

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vendedor", "ID Empleado", "Correo", "Telefono", "Direccion", "Porcentaje", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVendedores);

        txtestatus.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtestatus.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtestatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtestatusActionPerformed(evt);
            }
        });

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Estatus");

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");

        btnAyuda.setText("Ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Nombre");

        txtCodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCodigo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed1(evt);
            }
        });

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Valor a buscar:");

        btnReporte1.setText("Reporte");
        btnReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Tipo");

        txttipo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txttipo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Direccion");

        txtdireccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtdireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(txtbuscado))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label8)
                                    .addComponent(label6)
                                    .addComponent(label9)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label3))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label5)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtestatus, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttipo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(294, 294, 294))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label6)))
                            .addComponent(lb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtestatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar)
                            .addComponent(btnRegistrar))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar)
                            .addComponent(btnAyuda)
                            .addComponent(btnReporte))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(label7))))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        BodegaDAO bodegaDAO = new BodegaDAO();
        Bodega bodegaAEliminar = new Bodega();
        bodegaAEliminar.setPkid(txtbuscado.getText());
        bodegaDAO.delete(bodegaAEliminar);
        Auditoria.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");
        llenadoDeTablas();
        //bitacora.ingresar(codigoAplicacion, usuarioRegistrado, "DEL");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        BodegaDAO bodegaDAO = new BodegaDAO();
        Bodega bodegaAInsertar = new Bodega();
        bodegaAInsertar.setPkid(txtCodigo.getText());
        bodegaAInsertar.setNombre(txtNombre.getText());
        bodegaAInsertar.setTipo_bodea(txttipo.getText());
        bodegaAInsertar.setDireccion(txtdireccion.getText());
        bodegaAInsertar.setEstado(txtestatus.getText());
        bodegaDAO.insert(bodegaAInsertar);
        Auditoria.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");        
        llenadoDeTablas();
        //bitacora.ingresar(codigoAplicacion, usuarioRegistrado, "INS");        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarVendedor();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
        BodegaDAO bodegaDAO = new BodegaDAO();
        Bodega bodegaAActualizar = new Bodega();
        bodegaAActualizar.setPkid(txtbuscado.getText());
        bodegaAActualizar.setNombre(txtNombre.getText());
        bodegaAActualizar.setTipo_bodea(txttipo.getText());
        bodegaAActualizar.setDireccion(txtdireccion.getText());
        bodegaAActualizar.setEstado(txtestatus.getText());
        bodegaDAO.update(bodegaAActualizar);
        Auditoria.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "UPD");
        llenadoDeTablas();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtCodigo.setText("");
        txttipo.setText("");
        txtNombre.setText("");
        txtdireccion.setText("");
        txtestatus.setText("");
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\ayudas\\ProcesoMayor.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\ayudas\\ProcesoMayor.chm");
                p.waitFor();
            } else {
                System.out.println("La ayuda no Fue encontrada");
            }
            System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteActionPerformed

    private void txtestatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtestatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtestatusActionPerformed

    private void btnReporteActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed1

        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteActionPerformed1


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnReporte1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtbuscado;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtestatus;
    private javax.swing.JTextField txttipo;
    // End of variables declaration//GEN-END:variables
}
