package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Player;

public class Lista extends JPanel implements ListSelectionListener {

	private JList listaPlayers;
	private InterfazMain principal;
	
	public Lista(InterfazMain principal){
		this.principal=principal;
		setLayout(new BorderLayout());
		
		JPanel panelLista= new JPanel( );
		panelLista.setLayout( new BorderLayout( ) );
		panelLista.setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Players NBA" ) ) );

	
		listaPlayers= new JList();
		listaPlayers.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		listaPlayers.addListSelectionListener( this );

        JScrollPane scroll = new JScrollPane( );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
        scroll.getViewport( ).add( listaPlayers );

        panelLista.add( scroll, BorderLayout.CENTER );
        add( panelLista, BorderLayout.CENTER );
	}
	
	public void updateList( ArrayList<Player> listUpdated )
	   {
		listaPlayers.setListData( listUpdated.toArray() );
		listaPlayers.setSelectedIndex( 0 );
	       

	   }
	public void selection( int seleccionado )
	   {
		listaPlayers.setSelectedIndex( seleccionado );
		listaPlayers.ensureIndexIsVisible( seleccionado );
	   }
	
	public boolean isSelectioned( ){
	       return !listaPlayers.isSelectionEmpty( );
	}
	
	public Player getSelection( )
	   {
		Player vSeleccionado = null;

	       if( listaPlayers.getSelectedValue( ) != null )
	       {
	           vSeleccionado = (Player )listaPlayers.getSelectedValue( );
	       }

	       return vSeleccionado;
	   }
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if( listaPlayers.getSelectedValue( ) != null )
	       {
	           Player p = ( Player )listaPlayers.getSelectedValue( );
	           principal.mostrarInformacion( p );
	       }
		
	}

}
