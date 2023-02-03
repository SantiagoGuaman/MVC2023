/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.VistaProductos;
import java.awt.event.KeyAdapter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorProducto {

    private final ModeloProducto mp;
    private final VistaProductos vp;

    public ControladorProducto(ModeloProducto mp, VistaProductos vp) {
        this.mp = mp;
        this.vp = vp;
        vp.setVisible(true);
    }

    public void IniciaControl() {
        vp.getBtnUpdatepro().addActionListener(l -> CargaProductos());
        vp.getBtnCreatepro().addActionListener(l -> abrirDialogo(1));
        vp.getBtnCreatepro().addActionListener(l -> vp.getLblidpro().setText(String.valueOf(IncrementaID())));
        vp.getBtnEditpro().addActionListener(l -> abrirDialogo(2));
        vp.getBtnEliminarpro().addActionListener(l -> abrirDialogo(3));
        vp.getBtnaceptar().addActionListener(l -> crearEditarEliminarProducto());
        vp.getBtncancel().addActionListener(l -> vp.getDlgcrudproducts().dispose());
        vp.getTxtBuscarpro().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                BuscaProductos();
            }
        });
    }

    private void CargaProductos() {
        List<Producto> listapro = mp.ListProductos();
        DefaultTableModel mtabla;
        mtabla = (DefaultTableModel) vp.getTableProduct().getModel();
        mtabla.setNumRows(0);

        listapro.stream().forEach(pro -> {
            String[] FilaNueva = {String.valueOf(pro.getIdproducto()), pro.getNombre_pro(), String.valueOf(pro.getPrecio_pro()), String.valueOf(pro.getCantidad_pro()),
                pro.getDescripcion_pro()};
            mtabla.addRow(FilaNueva);
        });
    }

    private void BuscaProductos() {
        List<Producto> listapro = mp.BuscarProductoBD(vp.getTxtBuscarpro().getText().trim());
        DefaultTableModel mtabla;
        mtabla = (DefaultTableModel) vp.getTableProduct().getModel();
        mtabla.setNumRows(0);

        listapro.stream().forEach(pro -> {
            String[] FilaNueva = {String.valueOf(pro.getIdproducto()), pro.getNombre_pro(), String.valueOf(pro.getPrecio_pro()), String.valueOf(pro.getCantidad_pro()),
                pro.getDescripcion_pro()};
            mtabla.addRow(FilaNueva);
        });
    }

    private void abrirDialogo(int ce) {
        String title = null;
        boolean rowselected = false;
        if (ce == 1) {
            title = "AÑADIR NUEVO PRODUCTO";
            vp.getDlgcrudproducts().setName("crear");
            vp.getTxtnombrepro().setEnabled(true);
            vp.getTxtnombrepro().setText(null);
            vp.getSpnprecio().setValue(0);
            vp.getSpncantidad().setValue(0);
            vp.getTxtdescripcion().setText(null);
            ActivaCampos();
            rowselected = true;
        } else {
            if (ce == 2) {
                title = "EDITAR PRODUCTO";
                vp.getDlgcrudproducts().setName("editar");
                ActivaCampos();
                vp.getTxtnombrepro().setEnabled(false);
                rowselected = MousePress(vp.getTableProduct());
            } else {
                if (ce == 3) {
                    title = "ELIMINAR PRODUCTO";
                    vp.getDlgcrudproducts().setName("eliminar");
                    vp.getTxtnombrepro().setEnabled(false);
                    vp.getSpnprecio().setEnabled(false);
                    vp.getSpncantidad().setEnabled(false);
                    vp.getTxtdescripcion().setEnabled(false);
                    rowselected = MousePress(vp.getTableProduct());
                }
            }
        }
        
        if (rowselected) {
            vp.getDlgcrudproducts().setLocationRelativeTo(vp);
            vp.getDlgcrudproducts().setSize(600, 400);
            vp.getDlgcrudproducts().setTitle(title);
            vp.getDlgcrudproducts().setVisible(true);
        }
    }

    public void ActivaCampos() {
        vp.getTxtdescripcion().setEnabled(true);
        vp.getTxtnombrepro().setEnabled(true);
        vp.getSpncantidad().setEnabled(true);
        vp.getSpnprecio().setEnabled(true);
    }
    
    private boolean MousePress(JTable me) {
        boolean press = false;
        try { 
            if (me.getSelectedRowCount() == 1) {
                vp.getLblidpro().setText(vp.getTableProduct().getValueAt(vp.getTableProduct().getSelectedRow(), 0).toString());
                vp.getTxtnombrepro().setText(vp.getTableProduct().getValueAt(vp.getTableProduct().getSelectedRow(), 1).toString());
                vp.getSpnprecio().setValue(Double.parseDouble(vp.getTableProduct().getValueAt(vp.getTableProduct().getSelectedRow(), 2).toString()));
                vp.getSpncantidad().setValue(Integer.parseInt(vp.getTableProduct().getValueAt(vp.getTableProduct().getSelectedRow(), 3).toString()));
                vp.getTxtdescripcion().setText(vp.getTableProduct().getValueAt(vp.getTableProduct().getSelectedRow(), 4).toString());

                press = true;
            } else {
                JOptionPane.showMessageDialog(vp, "Seleccione una fila primero");
            }
        } catch(NullPointerException e) {
            System.out.println(e);
        }
        return press;
    }
    
    private int IncrementaID() {
        int id = mp.ObtieneID();
        id++;
        return id;
    }
    
    private void crearEditarEliminarProducto() {
        if (vp.getDlgcrudproducts().getName().equals("crear")) {
            try {
                int id = Integer.parseInt(vp.getLblidpro().getText());
                String nombre = vp.getTxtnombrepro().getText();
                double precio = Double.parseDouble(vp.getSpnprecio().getValue().toString());
                int cantidad = Integer.parseInt(vp.getSpnprecio().getValue().toString());
                String descripcion = vp.getTxtdescripcion().getText();
                //byte foto = 
                ModeloProducto producto = new ModeloProducto();
                producto.setIdproducto(id);
                producto.setNombre_pro(nombre);
                producto.setPrecio_pro(precio);
                producto.setCantidad_pro(cantidad);
                producto.setDescripcion_pro(descripcion);

                if (producto.GrabaProductoDB() == null) {
                    vp.getDlgcrudproducts().setVisible(false);
                    JOptionPane.showMessageDialog(vp, "Producto creado correctamente");
                } else {
                    JOptionPane.showMessageDialog(vp, "No se pudo crear el producto");
                }
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println(e);
            }
        } else {
            if (vp.getDlgcrudproducts().getName().equals("editar")) {
                try {
                    vp.getBtnaceptar().setEnabled(true);
                    int id = Integer.parseInt(vp.getLblidpro().getText());
                    String nombre = vp.getTxtnombrepro().getText();
                    double precio = Double.parseDouble(vp.getSpnprecio().getValue().toString());
                    int cantidad = Integer.parseInt(vp.getSpnprecio().getValue().toString());
                    String descripcion = vp.getTxtdescripcion().getText();
                    //byte foto = 
                    ModeloProducto producto = new ModeloProducto();
                    producto.setIdproducto(id);
                    producto.setNombre_pro(nombre);
                    producto.setPrecio_pro(precio);
                    producto.setCantidad_pro(cantidad);
                    producto.setDescripcion_pro(descripcion);
                    if (producto.ModficarProductoDB(id) == null) {
                        vp.getDlgcrudproducts().setVisible(false);
                        JOptionPane.showMessageDialog(vp, "Producto editado con éxito");
                    } else {
                        JOptionPane.showMessageDialog(vp, "No se pudo editar el producto");
                    }
                } catch (NumberFormatException | NullPointerException e) {
                    System.out.println(e);
                }
            } else {
                if (vp.getDlgcrudproducts().getName().equals("eliminar")) {
                    try {
                        int id = Integer.parseInt(vp.getLblidpro().getText());
                        String nombre = vp.getTxtnombrepro().getText();
                        double precio = Double.parseDouble(vp.getSpnprecio().getValue().toString());
                        int cantidad = Integer.parseInt(vp.getSpnprecio().getValue().toString());
                        String descripcion = vp.getTxtdescripcion().getText();
                        //byte foto = 
                        ModeloProducto producto = new ModeloProducto();
                        producto.setIdproducto(id);
                        producto.setNombre_pro(nombre);
                        producto.setPrecio_pro(precio);
                        producto.setCantidad_pro(cantidad);
                        producto.setDescripcion_pro(descripcion);
                        if (producto.EliminarProductoDB(id) == null) {
                            vp.getDlgcrudproducts().setVisible(false);
                            JOptionPane.showMessageDialog(vp, "Producto eliminado con éxito");
                        } else {
                            JOptionPane.showMessageDialog(vp, "No se pudo eliminar el producto");
                        }

                    } catch (NumberFormatException | NullPointerException e) {
                        System.out.print(e);
                    }
                }
            }
        }
        CargaProductos();
    }

}
