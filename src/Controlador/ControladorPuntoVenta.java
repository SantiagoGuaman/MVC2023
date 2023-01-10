package Controlador;
import Vista.VistaPuntoVenta;

public class ControladorPuntoVenta {
    
    private final VistaPuntoVenta vpv;

    public ControladorPuntoVenta(VistaPuntoVenta vpv) {
        this.vpv = vpv;
        vpv.setVisible(true);
    }
    
    public void IniciaControl() {
        vpv.getBtnagregar().addActionListener(l -> AbreDialogo(1));
    }
    
    private void AbreDialogo(int op) {
        String title = null;
        if (op == 1) {
            title = "PRODUCTOS";
        }
        vpv.getDjgproductos().setLocationRelativeTo(vpv);
        vpv.getDjgproductos().setSize(620, 350);
        vpv.getDjgproductos().setTitle(title);
        vpv.getDjgproductos().setVisible(true);
    }
}
