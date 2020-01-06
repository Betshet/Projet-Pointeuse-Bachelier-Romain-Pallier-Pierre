package view;

import javax.swing.*;

public class PopupImport extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextField FieldNom;
	
	public PopupImport() 
	{
		setFieldNom(new JTextField(20));

		add(new JLabel("Chemin:"));
		add(getFieldNom());
		
		JOptionPane.showConfirmDialog(
				null,
				this,
                "Importer CSV",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE
                );
	}

	public JTextField getFieldNom() {
		return FieldNom;
	}
	public void setFieldNom(JTextField xField) {
		this.FieldNom = xField;
	}

}
