import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IngresoObjetoPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JButton btnCrBen;
	private JButton btnCONFIG;
	private JButton btnSalir;

	private JButton btnVSOM;
	
	private	JLabel lablTitulo;
	
	/**
	 * Representa el metodo constructor de la clase InicioPanel.  
	 */
	public IngresoObjetoPanel() {
		
		setLayout(new GridBagLayout());
		
		lablTitulo = new JLabel("Bienvenidos al sistema selector de objetos");
		lablTitulo.setFont(new Font("Serif", Font.BOLD, 20));

		
		btnVSOM = new JButton("Version Multiples Objetos");
		btnVSOM.setActionCommand("CrCant");
		
		btnCrBen = new JButton("Seleccionar Objetos");
		btnCrBen.setActionCommand("CrBen");
		
		btnCONFIG = new JButton("Propiedades de los Objetos");
		btnCONFIG.setActionCommand("CONFIG");
		
		btnSalir = new JButton("Salir");
		btnSalir.setActionCommand("SALIR");
		
		
		
		addComponent(lablTitulo	,0,0,1,1,0,0.6,GridBagConstraints.CENTER);
		addComponent(btnCrBen	,0,1,1,1,0,0.2,GridBagConstraints.BOTH);
	//addComponent(btnVSOM	,0,2,1,1,0,0.5,GridBagConstraints.BOTH);
		addComponent(btnCONFIG	,0,2,1,1,0,0.2,GridBagConstraints.BOTH);
		addComponent(btnSalir	,0,3,1,1,0,0.1,GridBagConstraints.BOTH);
		
	}
	
	/**
	 * A�ade los componentes al panel y especifica lase cordenadas del mismo.
	 * @param component Componente que ver� el usuario.
	 * @param gridx Ajuste del grid en el eje x.
	 * @param gridy Ajuste del grid en el eje y.
	 * @param gridwidth Ajuste del acho del grid.
	 * @param gridheight Ajuste del alto del grid.
	 * @param weightx Ajusta la distribucion tendra el componente en el eje x.
	 * @param weighty Ajusta la distribucion tendra el componente en el eje y.
	 * @param fill Rellena el area que le es asignada.
	 */
	public void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight,double weightx, double weighty, int fill) {
		    GridBagConstraints gbc = new GridBagConstraints();
		    gbc.gridx = gridx;
		    gbc.gridy = gridy;
		    gbc.gridwidth = gridwidth;
		    gbc.gridheight = gridheight;
		    gbc.weightx = weightx;
		    gbc.weighty = weighty;
		    gbc.fill = fill;
		    add(component, gbc);
		  }

	public JButton getBtnCrBen() {
		return btnCrBen;
	}

	public JButton getBtnCONFIG() {
		return btnCONFIG;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}


	public JButton getBtnVSOM() {
		return btnVSOM;
	}

	public JLabel getLablTitulo() {
		return lablTitulo;
	}

	

}
