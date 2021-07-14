package swing_estaciones;

import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubPanelFiltros extends JPanel {
	private ButtonGroup horaApertura;
	private ButtonGroup horaCierre;
	private ButtonGroup estado;
	
	public SubPanelFiltros() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("FILTROS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.BASELINE;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Horario apertura:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("00:01 a 06:00");
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 3;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("06:01 a 12:00");
		rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 4;
		add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("12:01 a 18:00");
		rdbtnNewRadioButton_3.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_3.gridx = 1;
		gbc_rdbtnNewRadioButton_3.gridy = 5;
		add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("18:01 a 00:00");
		rdbtnNewRadioButton_4.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_4.gridx = 1;
		gbc_rdbtnNewRadioButton_4.gridy = 6;
		add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
		
		horaApertura = new ButtonGroup();
		horaApertura.add(rdbtnNewRadioButton);
		horaApertura.add(rdbtnNewRadioButton_1);
		horaApertura.add(rdbtnNewRadioButton_3);
		horaApertura.add(rdbtnNewRadioButton_4);
		
		
		JLabel lblNewLabel_2 = new JLabel("Horario cierre:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 7;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("00:01 a 06:00");
		rdbtnNewRadioButton_5.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_5 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_5.gridx = 1;
		gbc_rdbtnNewRadioButton_5.gridy = 8;
		add(rdbtnNewRadioButton_5, gbc_rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("06:01 a 12:00");
		rdbtnNewRadioButton_6.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_6 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_6.gridx = 1;
		gbc_rdbtnNewRadioButton_6.gridy = 9;
		add(rdbtnNewRadioButton_6, gbc_rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("12:01 a 18:00");
		rdbtnNewRadioButton_7.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_7 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_7.gridx = 1;
		gbc_rdbtnNewRadioButton_7.gridy = 10;
		add(rdbtnNewRadioButton_7, gbc_rdbtnNewRadioButton_7);
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("18:01 a 00:00");
		rdbtnNewRadioButton_8.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_8 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_8.gridx = 1;
		gbc_rdbtnNewRadioButton_8.gridy = 11;
		add(rdbtnNewRadioButton_8, gbc_rdbtnNewRadioButton_8);
		
		horaCierre = new ButtonGroup();
		horaApertura.add(rdbtnNewRadioButton_5);
		horaApertura.add(rdbtnNewRadioButton_6);
		horaApertura.add(rdbtnNewRadioButton_7);
		horaApertura.add(rdbtnNewRadioButton_8);
		
		JLabel lblNewLabel_3 = new JLabel("Estado");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 12;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("Operativa");
		rdbtnNewRadioButton_9.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_9 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_9.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_9.gridx = 1;
		gbc_rdbtnNewRadioButton_9.gridy = 13;
		add(rdbtnNewRadioButton_9, gbc_rdbtnNewRadioButton_9);
		
		
		JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("En mantenimiento");
		rdbtnNewRadioButton_10.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_10 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_10.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_10.gridx = 1;
		gbc_rdbtnNewRadioButton_10.gridy = 14;
		add(rdbtnNewRadioButton_10, gbc_rdbtnNewRadioButton_10);

		estado= new ButtonGroup();
		estado.add(rdbtnNewRadioButton_9); 
		estado.add(rdbtnNewRadioButton_10);
		
		JButton btnNewButton = new JButton("Limpiar filtros");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 15;
		add(btnNewButton, gbc_btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				horaApertura.clearSelection();
				horaCierre.clearSelection();
				estado.clearSelection();
				// TO-DO tendria que mostrar todos los datos de la BDD
			}
		});
	}

}
