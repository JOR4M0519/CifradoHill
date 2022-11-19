import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Vista extends JFrame{
	private IngresoObjetoPanel ingresoObjetoPanel;

	
	public Vista() {
		
			 setSize(500, 500);
			 setDefaultCloseOperation(EXIT_ON_CLOSE);
			 setLayout(new BorderLayout());
			 setTitle("Selector de Objetos");
			 setResizable(false);
			 setLocationRelativeTo(null);

			 ingresoObjetoPanel = new IngresoObjetoPanel();
			 
			 add(ingresoObjetoPanel,BorderLayout.CENTER);
			 setVisible(true);
		
	}
	
	
	public String recibirDato(String msg) {
		return JOptionPane.showInputDialog(null, msg);
	}
	
	public void mostrarVentana(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public boolean confirmacionVentana(String mensaje, String titulo, int tipoMensaje) {
		int respuesta = JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION, tipoMensaje);
		if(respuesta == 0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public IngresoObjetoPanel getIngresoObjeto() {
		return ingresoObjetoPanel;
	}


}
