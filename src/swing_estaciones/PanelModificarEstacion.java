package swing_estaciones;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import com.github.lgooddatepicker.components.TimePicker;
import com.toedter.calendar.JDateChooser;

import bdd.EstacionesRepo;
import bdd.TareaMantenimientoRepo;
import excepciones.FechaFinMenorFechaInicioException;
import excepciones.HoraCierreMenorHoraAperturaException;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;
import modelo.TareaMantenimiento;

import java.awt.Color;

public class PanelModificarEstacion extends JPanel {

	private static final long serialVersionUID = -2672083217995305547L;
	
	private JTextField textField_1;
	private ButtonGroup estado;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private TimePicker timePicker;
	private TimePicker timePicker_1; 
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton1;
	private JLabel lblNewLabel_1;
	private JLabel inserteHoraApertura;
	private JLabel inserteHoraCierre;
	private JLabel seleccioneEstado;
	private JLabel lblNewLabel_6;
	private JLabel agregarMant;
	private JLabel finalizarMant;
	private JLabel fechaFin;
	private JDateChooser dateChooser_1;
	public JLabel obs;  
	private JTextArea textArea ;
	private JButton btnNewButton_3 ;
	private JButton btnNewButton4;
	private JButton btnNewButton5;
	private JLabel fechaFin1;
	private JLabel reingFecha;
	private JLabel cierrePosteriorAp;
	private Estacion a_modificar;
	
	public void horarioCierrePostAp() {
		this.cierrePosteriorAp.setVisible(true);
	}
		
	public void modificarEstacion() throws HoraCierreMenorHoraAperturaException {
			Estacion nueva =  this.getEstacionModificada();
			//Error en todo
			if(nueva.getNombre().isEmpty()) {
				btnNewButton.setEnabled(false);	
			}
			
			
			if(!nueva.getNombre().isEmpty()){
			if(nueva.getEstado().equals(EstadoEstacionEnum.MANTENIMIENTO) && a_modificar.getEstado().equals(EstadoEstacionEnum.OPERATIVA)){
				this.deshabilitarCambios();
				this.mostrarDatosMantenimiento();
			}
			else if(nueva.getEstado().equals(EstadoEstacionEnum.OPERATIVA) && a_modificar.getEstado().equals(EstadoEstacionEnum.MANTENIMIENTO)) {
				this.deshabilitarCambios();
				this.mostrarDatosMantenimientoParaFin(TareaMantenimientoRepo.ObtenerActiva(a_modificar));
			}else { 
				EstacionesRepo.ModificarEstacion(nueva);
				lblNewLabel_6.setVisible(true);
				btnNewButton.setEnabled(false);
			}
			
			}
			
			
			}

	
	public void agregarTareaMantenimiento(Estacion nueva) {
		//public TareaMantenimiento(Estacion estacion, LocalDate fi, LocalDate ff, String obs)
		TareaMantenimiento tarea = null;
		try {
			tarea = this.getTareaMantenimiento(nueva);
			if(tarea.getFechaFin()==null) {
				fechaFin1.setVisible(true);
			}
			else {
				this.limpiarWarnings();
				lblNewLabel_6.setVisible(true);
				btnNewButton4.setEnabled(false);
				TareaMantenimientoRepo.AgregarTareaMantenimiento(tarea);
		}
			
		} catch (FechaFinMenorFechaInicioException e) {
			reingFecha.setVisible(true);
		}
	}
		
	public void finalizarTareaMantenimiento (TareaMantenimiento t) {
		try {
			TareaMantenimientoRepo.FinalizarTareaDeMantenimiento(t);
		} catch (FechaFinMenorFechaInicioException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public PanelModificarEstacion (Estacion actual) {		
		setBackground(Color.WHITE);
		this.a_modificar=actual;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 90, 141, 211, 67, 0};
		gridBagLayout.rowHeights = new int[]{0, 26, 19, 0, 19, 0, 19, 0, 19, 21, 0, 0, 85, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		setSize(new Dimension(503, 555));
		setMinimumSize(new Dimension(300,300));
		
		JLabel lblNewLabel = new JLabel("MODIFICAR ESTACION");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.gridwidth=4;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Por favor, inserte un nombre.");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		gbc_lblNewLabel_1.gridwidth=3;
		gbc_lblNewLabel_1.anchor=GridBagConstraints.WEST;
		lblNewLabel_1.setVisible(false);

		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("HORA APERTURA:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		timePicker = new TimePicker();
		timePicker.getComponentToggleTimeMenuButton().setFont(new Font("Arial", Font.PLAIN, 10));
		timePicker.getComponentToggleTimeMenuButton().setBackground(new Color(204, 204, 153));
		GridBagConstraints gbc_timePicker = new GridBagConstraints();
		gbc_timePicker.insets = new Insets(0, 0, 5, 5);
		gbc_timePicker.fill = GridBagConstraints.BOTH;
		gbc_timePicker.gridx = 2;
		gbc_timePicker.gridy = 4;
		gbc_timePicker.gridwidth=2;
		add(timePicker, gbc_timePicker);

		inserteHoraApertura = new JLabel("Por favor, inserte un horario de apertura.");
		inserteHoraApertura.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteHoraApertura.setForeground(Color.RED);
		GridBagConstraints horaApgbc = new GridBagConstraints();
		horaApgbc.gridy = 5;
		horaApgbc.insets = new Insets(0, 0, 5, 5);
		horaApgbc.gridx = 1;
		horaApgbc.gridwidth=3;
		horaApgbc.anchor=GridBagConstraints.WEST;
		add(inserteHoraApertura, horaApgbc);
		inserteHoraApertura.setVisible(false);
		
		JLabel lblNewLabel_4 = new JLabel("HORA CIERRE:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		timePicker_1 = new TimePicker();
		timePicker_1.getComponentToggleTimeMenuButton().setFont(new Font("Arial", Font.PLAIN, 11));
		timePicker_1.getComponentToggleTimeMenuButton().setBackground(new Color(204, 204, 153));
		GridBagConstraints gbc_timePicker_1 = new GridBagConstraints();
		gbc_timePicker_1.insets = new Insets(0, 0, 5, 5);
		gbc_timePicker_1.fill = GridBagConstraints.BOTH;
		gbc_timePicker_1.gridx = 2;
		gbc_timePicker_1.gridy = 6;
		gbc_timePicker_1.gridwidth=2;
		add(timePicker_1, gbc_timePicker_1);
		
		inserteHoraCierre = new JLabel("Por favor, inserte un horario de cierre.");
		inserteHoraCierre.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		inserteHoraCierre.setForeground(Color.RED);
		GridBagConstraints horaCgbc = new GridBagConstraints();
		horaCgbc.gridy = 7;
		horaCgbc.insets = new Insets(0, 0, 5, 5);
		horaCgbc.gridx = 1;
		horaCgbc.gridwidth=7;
		horaCgbc.anchor=GridBagConstraints.WEST;
		add(inserteHoraCierre, horaCgbc);
		inserteHoraCierre.setVisible(false);
		
		cierrePosteriorAp = new JLabel("Por favor, inserte un horario de cierre posterior al horario de apertura.");
		cierrePosteriorAp.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		cierrePosteriorAp.setForeground(Color.RED);
		GridBagConstraints hora1Cgbc = new GridBagConstraints();
		hora1Cgbc.gridy = 7;
		hora1Cgbc.insets = new Insets(0, 0, 5, 5);
		hora1Cgbc.gridx = 1;
		hora1Cgbc.gridwidth=7;
		hora1Cgbc.anchor=GridBagConstraints.WEST;
		add(cierrePosteriorAp, hora1Cgbc);
		cierrePosteriorAp.setVisible(false);
		
		JLabel lblNewLabel_5 = new JLabel("ESTADO:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 8;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		rdbtnNewRadioButton = new JRadioButton("Operativa");
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 2;
		gbc_rdbtnNewRadioButton.gridy = 8;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		rdbtnNewRadioButton1 = new JRadioButton("En mantenimiento");
		rdbtnNewRadioButton1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnNewRadioButton1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton1.gridx = 3;
		gbc_rdbtnNewRadioButton1.gridy = 8;
		add(rdbtnNewRadioButton1, gbc_rdbtnNewRadioButton1);
		
		seleccioneEstado = new JLabel("Por favor, seleccione un estado.");
		seleccioneEstado.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		seleccioneEstado.setForeground(Color.RED);
		GridBagConstraints estadoGbc = new GridBagConstraints();
		estadoGbc.gridy = 9;
		estadoGbc.insets = new Insets(0, 0, 5, 0);
		estadoGbc.gridx = 1;
		estadoGbc.gridwidth=9;
		estadoGbc.anchor=GridBagConstraints.WEST;
		add(seleccioneEstado, estadoGbc);
		seleccioneEstado.setVisible(false); 
		
		estado = new ButtonGroup();
		estado.add(rdbtnNewRadioButton);
		estado.add(rdbtnNewRadioButton1);
		
		btnNewButton_1 = new JButton("VOLVER");
		btnNewButton_1.setBackground(new Color(204, 204, 51));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 10;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton = new JButton("GUARDAR");
		btnNewButton.setBackground(new Color(204, 204, 51));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 10;
		add(btnNewButton, gbc_btnNewButton);
		
		lblNewLabel_6 = new JLabel("LA ESTACI�N SE MODIFIC� CORRECTAMENTE");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 11;
		gbc_lblNewLabel_6.gridwidth=3;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		lblNewLabel_6.setVisible(false);

		agregarMant = new JLabel("AGREGAR TAREA DE MANTENIMIENTO");
		agregarMant.setFont(new Font("Arial", Font.BOLD, 20));
		GridBagConstraints gbc_agregarMant = new GridBagConstraints();
		gbc_agregarMant.anchor = GridBagConstraints.CENTER;
		gbc_agregarMant.insets = new Insets(0, 0, 5, 5);
		gbc_agregarMant.gridx = 1;
		gbc_agregarMant.gridy = 12;
		gbc_agregarMant.gridwidth=4;
		add(agregarMant,gbc_agregarMant);
		agregarMant.setVisible(false);
		
		finalizarMant = new JLabel("FINALIZAR TAREA DE MANTENIMIENTO");
		finalizarMant.setFont(new Font("Arial", Font.BOLD, 20));
		GridBagConstraints gbc_finalizarMant = new GridBagConstraints();
		gbc_finalizarMant.anchor = GridBagConstraints.CENTER;
		gbc_finalizarMant.insets = new Insets(0, 0, 5, 5);
		gbc_finalizarMant.gridx = 1;
		gbc_finalizarMant.gridy = 12;
		gbc_finalizarMant.gridwidth=4;
		add(finalizarMant,gbc_agregarMant);
		finalizarMant.setVisible(false);
	
		fechaFin = new JLabel("FECHA FIN:");
		fechaFin.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_fin = new GridBagConstraints();
		gbc_fin.anchor = GridBagConstraints.EAST;
		gbc_fin.insets = new Insets(0, 0, 5, 5);
		gbc_fin.gridx = 1;
		gbc_fin.gridy = 13;
		add(fechaFin,gbc_fin);
		fechaFin.setVisible(false);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().setBackground(new Color(204, 204, 102));
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.anchor = GridBagConstraints.WEST;
		gbc_dateChooser_1.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser_1.gridx = 2;
		gbc_dateChooser_1.gridy = 13;
		add(dateChooser_1,gbc_dateChooser_1);
		dateChooser_1.setVisible(false);
			
		fechaFin1 = new JLabel("Por favor, inserte una fecha de fin de mantenimiento.");
		fechaFin1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		fechaFin1.setForeground(Color.RED);
		GridBagConstraints gbc_fin1 = new GridBagConstraints();
		gbc_fin1.gridy = 14;
		gbc_fin1.insets = new Insets(0, 0, 5, 5);
		gbc_fin1.gridx = 1;
		gbc_fin1.gridwidth=7;
		gbc_fin1.anchor=GridBagConstraints.WEST;
		add(fechaFin1, gbc_fin1);
		fechaFin1.setVisible(false);
		
		reingFecha = new JLabel("Por favor, ingrese una fecha posterior a la actual.");
		reingFecha.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		reingFecha.setForeground(Color.RED);
		GridBagConstraints gbc_reingF = new GridBagConstraints();
		gbc_reingF.gridy = 14;
		gbc_reingF.insets = new Insets(0, 0, 5, 5);
		gbc_reingF.gridx = 1;
		gbc_reingF.gridwidth=7;
		gbc_reingF.anchor=GridBagConstraints.WEST;
		add(reingFecha, gbc_reingF);
		reingFecha.setVisible(false);
		
		obs = new JLabel("OBSERVACIONES:");
		obs.setFont(new Font("Arial", Font.BOLD, 14));

		GridBagConstraints gbc_obs = new GridBagConstraints();
		gbc_obs.anchor = GridBagConstraints.EAST;
		gbc_obs.insets = new Insets(0, 0, 5, 5);
		gbc_obs.gridx =1;
		gbc_obs.gridy = 15;
		add(obs,gbc_obs);
		obs.setVisible(false);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setRows(8);
		textArea.setBackground(new Color(204, 204, 255));
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_textArea.anchor = GridBagConstraints.NORTH;
		gbc_textArea.insets = new Insets(10, 0, 5, 5);
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 15;
		gbc_textArea.gridwidth=7;
		gbc_textArea.gridheight=2;
		add(textArea,gbc_textArea);
		textArea.setVisible(false);
		
		btnNewButton_3 = new JButton("VOLVER");
		btnNewButton_3.setBackground(new Color(204, 204, 51));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 3;
		gbc_btnNewButton_3.gridy = 17;
		add(btnNewButton_3, gbc_btnNewButton_3);
		btnNewButton_3.setVisible(false);
		
		btnNewButton4 = new JButton("GUARDAR");
		btnNewButton4.setBackground(new Color(204, 204, 51));
		btnNewButton4.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton4 = new GridBagConstraints();
		gbc_btnNewButton4.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton4.gridx = 2;
		gbc_btnNewButton4.gridy = 17;
		add(btnNewButton4, gbc_btnNewButton4);
		btnNewButton4.setVisible(false);
			
		btnNewButton5 = new JButton("GUARDAR");
		btnNewButton5.setBackground(new Color(204, 204, 51));
		btnNewButton5.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton5 = new GridBagConstraints();
		gbc_btnNewButton5.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton5.gridx = 2;
		gbc_btnNewButton5.gridy = 17;
		add(btnNewButton5, gbc_btnNewButton5);
		btnNewButton5.setVisible(false);
		
		textField_1.setText(actual.getNombre());
		timePicker.setText(actual.getHorarioApertura().toString());
		timePicker_1.setText(actual.getHorarioCierre().toString());

		if(actual.getEstado().equals(EstadoEstacionEnum.OPERATIVA)) {
			rdbtnNewRadioButton.setSelected(true);
		}
		else rdbtnNewRadioButton1.setSelected(true);
	}
	
	public JDateChooser getDateChooser_1() {
		return dateChooser_1;
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	//crea una estacion con los datos ingresados (si son null la creamos igual con null)
	public Estacion getEstacionModificada() throws HoraCierreMenorHoraAperturaException {
		EstadoEstacionEnum e = null;
		if(rdbtnNewRadioButton.isSelected()) {
			e= EstadoEstacionEnum.OPERATIVA;
		}else if(rdbtnNewRadioButton1.isSelected()){
			e= EstadoEstacionEnum.MANTENIMIENTO;
		}
		return new Estacion(a_modificar.getId(),this.textField_1.getText(), this.timePicker.getTime(), this.timePicker_1.getTime(),e);
	}

	public void limpiarDatos() {
		this.textField_1.setText(null);
		this.timePicker.setText(null);
		this.timePicker_1.setText(null);
		this.estado.clearSelection();
		dateChooser_1.setCalendar(null);
		this.textArea.setText(null);
	}
	
	public void limpiarWarnings() {
		this.seleccioneEstado.setVisible(false);
		this.lblNewLabel_1.setVisible(false);
		lblNewLabel_6.setVisible(false);
		inserteHoraCierre.setVisible(false);
		this.inserteHoraApertura.setVisible(false);
		this.reingFecha.setVisible(false);
		this.fechaFin1.setVisible(false);
	}
	
	
	public void nombreFaltante() {
		lblNewLabel_1.setVisible(true);
	}
	
	public void horaAperturaFaltante() {
		inserteHoraApertura.setVisible(true);
	}
	public void horaCierreFaltante() {
		inserteHoraCierre.setVisible(true);
	}
	public void mensajeEstacionModificada() {
		lblNewLabel_6.setVisible(true);
	}
	public void estadoFaltante() {
		seleccioneEstado.setVisible(true);
	}
	
	public void mostrarDatosMantenimiento() {
		//tareaMant.setVisible(true);
		btnNewButton_1.setEnabled(false);
		btnNewButton.setEnabled(false);
		agregarMant.setVisible(true);
		fechaFin.setVisible(true);
		dateChooser_1.setVisible(true);
		obs.setVisible(true);
		textArea.setVisible(true);
		btnNewButton_3.setVisible(true);
		btnNewButton4.setVisible(true);	
	}
	public void mostrarDatosMantenimientoParaFin(TareaMantenimiento actual) {
		
		btnNewButton_1.setEnabled(false);
		btnNewButton.setEnabled(false);
		finalizarMant.setVisible(true);
		fechaFin.setVisible(true);
		dateChooser_1.setVisible(true);
		dateChooser_1.setDate(convertToDate(LocalDate.now()));
		dateChooser_1.setDate(convertToDate(LocalDate.now().minusDays(1)));
		dateChooser_1.setEnabled(false);
		obs.setVisible(true);
		textArea .setVisible(true);

		 try { 
			textArea.setText(actual.getObservaciones()); 
		 }
		 catch (java.lang.NullPointerException e){
			 textArea.setText(null);
		 }
		try{
			textArea.setText(actual.getObservaciones());
		}catch(java.lang.NullPointerException e) {
			textArea.setText(null);
		}
		
		btnNewButton_3.setVisible(true);
		btnNewButton5.setVisible(true); 
/*		try {
			actual.setFechaFin(convertToLocalDate(dateChooser_1.getDate()));
		} catch (FechaFinMenorFechaInicioException e) {
			e.printStackTrace();
		}
		TareaMantenimientoRepo.ModificarTareaMantenimiento(actual);
=======
	*/
	}
	public void sacarMantenimiento() {
		btnNewButton_1.setEnabled(true);
		btnNewButton.setEnabled(true);
		agregarMant.setVisible(false);
		fechaFin.setVisible(false);
		dateChooser_1.setVisible(false);
		obs.setVisible(false);
		textArea .setVisible(false);
		btnNewButton_3.setVisible(false);
		btnNewButton4.setVisible(false);
	}
	public JButton getBtnNewButton_3() {
		return btnNewButton_3;
	}
	
	public JButton getBtnNewButton4() {
		return btnNewButton4;
	}
	public void mensajeFechaErronea() {
		reingFecha.setVisible(true);
	}
	
	public TareaMantenimiento getTareaMantenimiento(Estacion nueva) throws FechaFinMenorFechaInicioException {
		//public TareaMantenimiento(Estacion estacion, LocalDate fi, LocalDate ff, String obs)
		//fechaAntigua.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
		Date fin= dateChooser_1.getDate();
		if(fin==null) {
			return new TareaMantenimiento(nueva,LocalDate.now(),null, textArea.getText() );
		}else {
			return new TareaMantenimiento(nueva,LocalDate.now(),fin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), textArea.getText() );
		}
	}
	
	public Estacion getA_modificar() {
		return a_modificar;
	}

	public void setA_modificar(Estacion a_modificar) {
		this.a_modificar = a_modificar;
	}

	public void deshabilitarGuardado() {
		btnNewButton.setEnabled(false);
	}
	public void deshabilitarGuardado1() {
		btnNewButton4.setEnabled(false);
	}
	public void habilitarBotones() {
		btnNewButton.setEnabled(true);
		btnNewButton4.setEnabled(true);
	}
	
	public void deshabilitarCambios() {
		textField_1.setEditable(false);
		timePicker.setEnabled(false);
		this.timePicker_1.setEnabled(false);
		this.rdbtnNewRadioButton.setEnabled(false);
		this.rdbtnNewRadioButton1.setEnabled(false);
	}
	
	public JButton getBtnNewButton5() {
		return btnNewButton5;
	}

	public void setBtnNewButton5(JButton btnNewButton5) {
		this.btnNewButton5 = btnNewButton5;
	}

	public void habilitar() {
		textField_1.setEditable(true);
		timePicker.setEnabled(true);
		this.timePicker_1.setEnabled(true);
		this.rdbtnNewRadioButton.setEnabled(true);
		this.rdbtnNewRadioButton1.setEnabled(true);
	}
	public void faltaFechaMant() {
		fechaFin1.setVisible(true);
	}
	public static Date convertToDate(LocalDate dateToConvert) {
	    return java.sql.Date.valueOf(dateToConvert);
	}
	public static LocalDate convertToLocalDate(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}

	public JLabel getLblNewLabel_6() {
		return lblNewLabel_6;
	}

	public void setLblNewLabel_6(JLabel lblNewLabel_6) {
		this.lblNewLabel_6 = lblNewLabel_6;
	}
	
	public String estadoSeleccionado() {
		if(rdbtnNewRadioButton.isSelected()) {
			return "operativa";
		}else if(this.rdbtnNewRadioButton1.isSelected()) {
			return "en mantenimiento";
		}else return "no seleccionado";
	}
}