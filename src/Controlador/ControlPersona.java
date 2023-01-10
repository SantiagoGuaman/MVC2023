package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControlPersona {

    private final ModeloPersona modelo;
    private final VistaPersonas view;

    public ControlPersona(ModeloPersona modelo, VistaPersonas view) {
        this.modelo = modelo;
        this.view = view;
        //Instancia de vista 
        view.setVisible(true);
    }

    //Método de acción con botones
    public void IniciaControl() {
        view.getBtnUpdate().addActionListener(l -> CargaPersonas());
        view.getBtnCreate().addActionListener(l -> abrirDialogo(1));
        view.getBtnEdit().addActionListener(l -> abrirDialogo(2));
        view.getBtnEliminar().addActionListener(l -> abrirDialogo(3));
        view.getBtnaceptar().addActionListener(l -> crearEditarEliminarPersona());
        view.getBtncancelar().addActionListener(l -> view.getDlgcrud().dispose());
        
        view.getTxtBuscar().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscaPersona();
            } 
        });
        
        view.getTablePerson().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                MousePress(me);
            }
        });
        
        //Validaciones 
        view.getTxtid().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidKeyEvent(evt);
            }
        });

        view.getTxtnombre().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Campostexto(evt);
            }
        });

        view.getTxtapellido().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Campostexto(evt);
            }
        });

        view.getJdcfechanac().setDateFormatString("yyyy-MM-dd");
        view.getJdcfechanac().setEnabled(false);
        view.getJdcfechanac().getCalendarButton().setEnabled(true);
    }

    //EventosKey
    public void txtidKeyEvent(java.awt.event.KeyEvent e) {
        char key = e.getKeyChar();
        if (Character.isLetter(key) || view.getTxtid().getText().length() >= 10 || view.getTxttelefono().getText().length() >= 15) {
            e.consume();
        }
    }

    public void Campostexto(java.awt.event.KeyEvent e) {
        char key = e.getKeyChar();
        if (Character.isDigit(key) || view.getTxtnombre().getText().length() >= 50 || view.getTxtapellido().getText().length() >= 50) {
            e.consume();
        }
    }
    
    
    public void DateEvent(java.awt.event.KeyEvent e) {
        char key = e.getKeyChar();
        if (Character.isDigit(key) || Character.isLetter(key)) {
            e.consume();
        }
    }

    public void MousePress(MouseEvent me) {
        try { 
            if (me.getClickCount() == 1) {
                view.getTxtid().setText(view.getTablePerson().getValueAt(view.getTablePerson().getSelectedRow(), 0).toString());
                view.getTxtnombre().setText(view.getTablePerson().getValueAt(view.getTablePerson().getSelectedRow(), 1).toString());
                view.getTxtapellido().setText(view.getTablePerson().getValueAt(view.getTablePerson().getSelectedRow(), 2).toString());
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                view.getJdcfechanac().setDate(formateador.parse(view.getTablePerson().getValueAt(view.getTablePerson().getSelectedRow(), 3).toString()));
                view.getTxttelefono().setText(view.getTablePerson().getValueAt(view.getTablePerson().getSelectedRow(), 4).toString());
                String sexo = view.getTablePerson().getValueAt(view.getTablePerson().getSelectedRow(), 5).toString();
                if (sexo.equals("Masculino")) {
                    view.getRbtnmale().setSelected(true);
                    view.getRbtnwoman().setSelected(false);
                } else if(sexo.equals("Femenino")){
                    view.getRbtnmale().setSelected(false);
                    view.getRbtnwoman().setSelected(true);
                }
                view.getSpnsueldo().setValue(Double.parseDouble(view.getTablePerson().getValueAt(view.getTablePerson().getSelectedRow(), 6).toString()));
                view.getSpncupo().setValue(Integer.parseInt(view.getTablePerson().getValueAt(view.getTablePerson().getSelectedRow(), 7).toString()));
            } else {
                JOptionPane.showMessageDialog(view, "Seleccione una fila primero");
            }
        } catch(NullPointerException | ParseException e) {
            System.out.println(e);
        }
    }
    
    private void CargaPersonas() {
        //Control de consulta a la BD al modelo
        //Luego a la vista
        List<Persona> listaPer = modelo.ListPersonas();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) view.getTablePerson().getModel();
        mTabla.setNumRows(0);

        listaPer.stream().forEach(pe -> {
            String[] FilaNueva = {pe.getIdpersona(), pe.getNombres(), pe.getApellidos(), String.valueOf(pe.getFechanac()),
            pe.getTelefono(), pe.getSexo(), String.valueOf(pe.getSueldo()), String.valueOf(pe.getCupo())};
            mTabla.addRow(FilaNueva);
        });
    }
    
    private void BuscaPersona() {
        //Control de consulta a la BD al modelo
        //Luego a la vista
        List<Persona> listaPer = modelo.BuscarPersonaBD(view.getTxtBuscar().getText());
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) view.getTablePerson().getModel();
        mTabla.setNumRows(0);

        listaPer.stream().forEach(pe -> {
            String[] FilaNueva = {pe.getIdpersona(), pe.getNombres(), pe.getApellidos(), String.valueOf(pe.getFechanac()),
            pe.getTelefono(), pe.getSexo(), String.valueOf(pe.getSueldo()), String.valueOf(pe.getCupo())};
            mTabla.addRow(FilaNueva);
        });
    }
    
    private void abrirDialogo(int ce) {
        String title = null;
        if (ce == 1) {
            title = "CREAR NUEVA PERSONA";
            view.getDlgcrud().setName("crear");
            view.getTxtid().setEnabled(true);
            view.getTxtid().setText(null);
            view.getTxtnombre().setText(null);
            view.getTxtapellido().setText(null);
            view.getJdcfechanac().setCalendar(null);
            view.getTxttelefono().setText(null);
            view.getBtngrpsexo().clearSelection();
            view.getSpnsueldo().setValue(0);
            view.getSpnsueldo().setValue(0);
        } else {
            if (ce == 2) {
                title = "EDITAR PERSONA";
                view.getDlgcrud().setName("editar");
                view.getTxtid().setEnabled(false);  
            } else {
                if(ce == 3) {
                    title = "ELIMINAR PERSONA";
                    view.getDlgcrud().setName("eliminar");
                    view.getTxtid().setEnabled(false);
                }
            }
        }
        view.getDlgcrud().setLocationRelativeTo(view);
        view.getDlgcrud().setSize(600, 400);
        view.getDlgcrud().setTitle(title);
        view.getDlgcrud().setVisible(true);
    }

    //Crear y Editar persona
    private void crearEditarEliminarPersona() {
        if (view.getDlgcrud().getName().equals("crear")) {
            //INSERTAR
            try {
                String cedula = view.getTxtid().getText();
                String nombres = view.getTxtnombre().getText();
                String apellidos = view.getTxtapellido().getText();
                Date fechanac = view.getJdcfechanac().getDate();
                String telefono = view.getTxttelefono().getText();
                String sexo = null;
                if (view.getRbtnmale().isSelected()) {
                    sexo = "Masculino";
                } else if(view.getRbtnwoman().isSelected()){
                    sexo = "Femenino";
                }               
                double sueldo = Double.parseDouble(view.getSpnsueldo().getValue().toString());
                int cupo = Integer.parseInt(view.getSpncupo().getValue().toString());
                //byte foto = 
                ModeloPersona persona = new ModeloPersona();
                persona.setIdpersona(cedula);
                persona.setNombres(nombres);
                persona.setApellidos(apellidos);
                persona.setFechanac(fechanac);
                persona.setTelefono(telefono);
                persona.setSexo(sexo);
                persona.setSueldo(sueldo);
                persona.setCupo(cupo);
                //persona.setFoto(foto);

                if (persona.GrabaPersonaDB() == null) {
                    view.getDlgcrud().setVisible(false);
                    JOptionPane.showMessageDialog(view, "Persona creada correctamente");
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo crear la persona");
                }
            } catch(NullPointerException | NumberFormatException e) {
                System.out.println(e);
            }
        } else {
            if (view.getDlgcrud().getName().equals("editar")) {
                try {
                    String cedula = view.getTxtid().getText();
                    if (cedula.isEmpty()) {
                            JOptionPane.showMessageDialog(view, "Por favor seleccione una fila de la tabla");
                    } else {
                        view.getBtnaceptar().setEnabled(true);
                        String nombres = view.getTxtnombre().getText();
                        String apellidos = view.getTxtapellido().getText();
                        Date fechanac = view.getJdcfechanac().getDate();
                        String telefono = view.getTxttelefono().getText();
                        String sexo = null;
                        if (view.getRbtnmale().isSelected()) {
                        sexo = "Masculino";
                        } else if(view.getRbtnwoman().isSelected()){
                            sexo = "Femenino";
                        }               
                        double sueldo = Double.parseDouble(view.getSpnsueldo().getValue().toString());
                        int cupo = Integer.parseInt(view.getSpncupo().getValue().toString());
                        ModeloPersona persona = new ModeloPersona();

                        persona.setIdpersona(cedula);
                        persona.setNombres(nombres);
                        persona.setApellidos(apellidos);
                        persona.setFechanac(fechanac);
                        persona.setTelefono(telefono);
                        persona.setSexo(sexo);
                        persona.setSueldo(sueldo);
                        persona.setCupo(cupo);
                        if (persona.ModficarPersonaDB(cedula) == null) {
                            view.getDlgcrud().setVisible(false);
                            JOptionPane.showMessageDialog(view, "Persona editada con éxito");
                        } else {
                            JOptionPane.showMessageDialog(view, "No se pudo editar a la persona");
                        }
                    }
                } catch(NumberFormatException | NullPointerException e) {
                    System.out.println(e);
                }
            } else {
                if (view.getDlgcrud().getName().equals("eliminar")) {
                    try {
                        String cedula = view.getTxtid().getText();
                        if (cedula.isEmpty()) {
                            JOptionPane.showMessageDialog(view, "Por favor seleccione una fila de la tabla");
                        } else {
                            String nombres = view.getTxtnombre().getText();
                            String apellidos = view.getTxtapellido().getText();
                            Date fechanac = view.getJdcfechanac().getDate();
                            String telefono = view.getTxttelefono().getText();
                            String sexo = null;
                            if (view.getRbtnmale().isSelected()) {
                                sexo = "Masculino";
                            } else if(view.getRbtnwoman().isSelected()){
                                sexo = "Femenino";
                            }               
                            double sueldo = Double.parseDouble(view.getSpnsueldo().getValue().toString());
                            int cupo = Integer.parseInt(view.getSpncupo().getValue().toString());
                            ModeloPersona persona = new ModeloPersona();

                            //persona.setIdpersona(cedula);
                            persona.setNombres(nombres);
                            persona.setApellidos(apellidos);
                            persona.setFechanac(fechanac);
                            persona.setTelefono(telefono);
                            persona.setSexo(sexo);
                            persona.setSueldo(sueldo);
                            persona.setCupo(cupo);
                            if (persona.EliminarPersonaDB(cedula) == null) {
                                view.getDlgcrud().setVisible(false);
                                JOptionPane.showMessageDialog(view, "Persona eliminada con éxito");
                            } else {
                                JOptionPane.showMessageDialog(view, "No se pudo eliminar a la persona");
                            }
                        }
                    } catch(NumberFormatException | NullPointerException e) {
                        System.out.print(e);
                    }
                }
            }
        }
        CargaPersonas();
    }

    private boolean campoVacio(String id) {
        return id.isEmpty();
    }
    
}
