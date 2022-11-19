import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import co.edu.unbosque.model.Vehiculo;
import co.edu.unbosque.view.Vista;

public class Controlador implements ActionListener{
	
	private Vista vista;

	public Controlador() {

		vista = new Vista();

		asignarOyentes();

	}

	public void asignarOyentes() {

		vista.getIngresoObjeto().getBtnCONFIG().addActionListener(this);
		vista.getIngresoObjeto().getBtnSalir().addActionListener(this);
		vista.getIngresoObjeto().getBtnCrBen().addActionListener(this);
		vista.getIngresoObjeto().getBtnVSOM().addActionListener(this);



	}

	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("SALIR")) {
			System.exit(0);
		}


	}
}
