package Controlador;

import Modelo.*;
import Vista.*;

public class ControladorMenuPrincipal {
    
    VistaPrincipal vistaprincipal;

    public ControladorMenuPrincipal(VistaPrincipal vistaprincipal) {
        this.vistaprincipal = vistaprincipal;
        vistaprincipal.setVisible(true);
        vistaprincipal.setLocationRelativeTo(null);
    }
    
    public void iniciaControl() {
        vistaprincipal.getMnucrudpersona().addActionListener(l -> CrudPersona());
        vistaprincipal.getBtnpersona().addActionListener(l -> CrudPersona());
        vistaprincipal.getBtnpuntoventa().addActionListener(l -> PuntoVenta());
        vistaprincipal.getBtnproducto().addActionListener(l -> CrudProducto());
        vistaprincipal.getBtnpersona().setToolTipText("Carga la vista de personas");
        vistaprincipal.getBtnpuntoventa().setToolTipText("Carga la vista del punto de venta");
    }
    
    private void CrudPersona() {
        VistaPersonas vp = new VistaPersonas();
        ModeloPersona mp = new ModeloPersona();
        
        vistaprincipal.getDktprincipal().add(vp);
        ControlPersona cp = new ControlPersona(mp, vp);
        cp.IniciaControl();
    }
    
    private void CrudProducto() {
        VistaProductos vps = new VistaProductos();
        ModeloProducto mps = new ModeloProducto();
        vistaprincipal.getDktprincipal().add(vps);
        ControladorProducto cps = new ControladorProducto(mps, vps);
        cps.IniciaControl();
    }
    
    private void PuntoVenta() {
        VistaPuntoVenta vpv = new VistaPuntoVenta();
        vistaprincipal.getDktprincipal().add(vpv);
        ControladorPuntoVenta cpv = new ControladorPuntoVenta(vpv);
        cpv.IniciaControl();  
    }
}
