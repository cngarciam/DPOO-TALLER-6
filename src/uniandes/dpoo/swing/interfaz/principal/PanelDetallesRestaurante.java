package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel
{

    private JLabel labNombre;


    private JLabel labCalificacion;


    private JCheckBox chkVisitado;

    public PanelDetallesRestaurante( )
    {

        labNombre = new JLabel( "Nombre:" );


        labCalificacion = new JLabel( );


        chkVisitado = new JCheckBox( "Visitado:" );
        chkVisitado.setEnabled( false );


        setLayout( new GridLayout( 3, 1 ) );
        
        JPanel panelNombre = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        panelNombre.add( new JLabel( "Nombre: " ) );
        panelNombre.add( labNombre );
        add( panelNombre );
        
        JPanel panelCalificacion = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        panelCalificacion.add( new JLabel( "Calificación: " ) );
        panelCalificacion.add( labCalificacion );
        add( panelCalificacion );
        
        JPanel panelVisitado = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        panelVisitado.add( new JLabel( "Visitado: " ) );
        panelVisitado.add( chkVisitado );
        add( panelVisitado );
    }


    private void actualizarRestaurante( String nombre, int calificacion, boolean visitado )
    {
        labNombre.setText( nombre );
        labCalificacion.setIcon( buscarIconoCalificacion( calificacion ) );
        chkVisitado.setSelected( visitado );
    }

  
    public void actualizarRestaurante( Restaurante r )
    {
        this.actualizarRestaurante( r.getNombre( ), r.getCalificacion( ), r.isVisitado( ) );
    }

    private ImageIcon buscarIconoCalificacion( int calificacion )
    {
        String imagen = "./imagenes/stars" + calificacion + ".png";
        return new ImageIcon( imagen );
    }
}
