package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ConfiguracionActualPantalla;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class VerConfiguraciones extends JFrame {

	private JPanel contentPane;
	private JTextField txtBrillo;
	private JTextField txtContr;
	private JTextField txtNiti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerConfiguraciones frame = new VerConfiguraciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VerConfiguraciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		// Dos configuraciones actuales para la misma pantalla
		ConfiguracionActualPantalla configuracion1 = ConfiguracionActualPantalla.getConfiguracion(70, 50, 50, false);
		ConfiguracionActualPantalla configuracion2 = ConfiguracionActualPantalla.getConfiguracion(60, 30, 60, true);

		JLabel lblBrillo = new JLabel("Brillo:");
		lblBrillo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblBrillo.setBounds(46, 11, 91, 14);
		contentPane.add(lblBrillo);

		JLabel lblContraste = new JLabel("Contraste:");
		lblContraste.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblContraste.setBounds(46, 36, 91, 14);
		contentPane.add(lblContraste);

		JLabel lblNitidez = new JLabel("Nitidez:");
		lblNitidez.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNitidez.setBounds(46, 61, 91, 14);
		contentPane.add(lblNitidez);

		JLabel lblModoLectura = new JLabel("Modo lectura:");
		lblModoLectura.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblModoLectura.setBounds(46, 86, 91, 14);
		contentPane.add(lblModoLectura);

		JLabel lblBrillov = new JLabel("Selecciona una configuraci\u00F3n para ver.");
		lblBrillov.setBounds(168, 11, 240, 14);
		contentPane.add(lblBrillov);

		JLabel lblContrastev = new JLabel("Selecciona una configuraci\u00F3n para ver.");
		lblContrastev.setBounds(168, 36, 240, 14);
		contentPane.add(lblContrastev);

		JLabel lblNitidezV = new JLabel("Selecciona una configuraci\u00F3n para ver.");
		lblNitidezV.setBounds(168, 61, 240, 14);
		contentPane.add(lblNitidezV);

		JLabel lblModov = new JLabel("Selecciona una configuraci\u00F3n para ver.");
		lblModov.setBounds(168, 86, 240, 14);
		contentPane.add(lblModov);

		// Despliega los parametros de A
		JButton btnVerConfiguracionA = new JButton("");
		btnVerConfiguracionA.setFocusPainted(false);
		btnVerConfiguracionA.setFocusTraversalKeysEnabled(false);
		btnVerConfiguracionA.setBorderPainted(false);
		btnVerConfiguracionA.setContentAreaFilled(false);
		btnVerConfiguracionA.setIcon(new ImageIcon(VerConfiguraciones.class.getResource("/recursos/button (3).png")));
		btnVerConfiguracionA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBrillov.setText(Integer.toString(configuracion1.getPorcentajeBrillo()));
				lblContrastev.setText(Integer.toString(configuracion1.getPorcentajeContraste()));
				lblNitidezV.setText(Integer.toString(configuracion1.getPorcentajeNitidez()));
				if (configuracion1.isModoLectura()) {
					lblModov.setText("Si");
				} else {
					lblModov.setText("No");
				}
			}
		});
		btnVerConfiguracionA.setBounds(56, 111, 161, 36);
		contentPane.add(btnVerConfiguracionA);

		// Despliega los parametros de B
		JButton btnVerConfiguracionB = new JButton("");
		btnVerConfiguracionB.setFocusTraversalKeysEnabled(false);
		btnVerConfiguracionB.setFocusPainted(false);
		btnVerConfiguracionB.setContentAreaFilled(false);
		btnVerConfiguracionB.setBorderPainted(false);
		btnVerConfiguracionB.setIcon(new ImageIcon(VerConfiguraciones.class.getResource("/recursos/button (5).png")));
		btnVerConfiguracionB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBrillov.setText(Integer.toString(configuracion2.getPorcentajeBrillo()));
				lblContrastev.setText(Integer.toString(configuracion2.getPorcentajeContraste()));
				lblNitidezV.setText(Integer.toString(configuracion2.getPorcentajeNitidez()));
				if (configuracion2.isModoLectura()) {
					lblModov.setText("Si");
				} else {
					lblModov.setText("No");
				}
			}
		});
		btnVerConfiguracionB.setBounds(227, 111, 161, 36);
		contentPane.add(btnVerConfiguracionB);

		JTextArea txtrComoSeObserva = new JTextArea();
		txtrComoSeObserva.setEditable(false);
		txtrComoSeObserva.setText(
				"Como se observa ambas configuraciones son en realidad la \r\nmisma puesto que una pantalla no puede tener dos \r\nconfiguraciones distintas al mismo tiempo.\r\n");
		txtrComoSeObserva.setBounds(44, 158, 364, 94);
		contentPane.add(txtrComoSeObserva);

		// Campos

		txtBrillo = new JTextField();
		txtBrillo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		txtBrillo.setText("");
		txtBrillo.setBounds(33, 263, 44, 20);
		contentPane.add(txtBrillo);
		txtBrillo.setColumns(10);

		txtContr = new JTextField();
		txtContr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		txtContr.setBounds(33, 298, 44, 20);
		contentPane.add(txtContr);
		txtContr.setColumns(10);

		txtNiti = new JTextField();
		txtNiti.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		txtNiti.setBounds(33, 332, 44, 20);
		contentPane.add(txtNiti);
		txtNiti.setColumns(10);

		// Modificaciones para la configuracion1

		JButton btnModificarBrillo1 = new JButton("");
		btnModificarBrillo1.setBorderPainted(false);
		btnModificarBrillo1.setContentAreaFilled(false);
		btnModificarBrillo1.setFocusTraversalKeysEnabled(false);
		btnModificarBrillo1.setFocusPainted(false);
		btnModificarBrillo1.setIcon(new ImageIcon(VerConfiguraciones.class.getResource("/recursos/modificar13.png")));
		btnModificarBrillo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtBrillo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingresa un valor.","Mensaje",JOptionPane.QUESTION_MESSAGE);
				} else {
					if (Integer.parseInt(txtBrillo.getText()) > 100 || Integer.parseInt(txtBrillo.getText()) < 0) {
						JOptionPane.showMessageDialog(null, "Valor no valido.","Mensaje",JOptionPane.WARNING_MESSAGE);
					} else {
						configuracion1.setPorcentajeBrillo(Integer.parseInt(txtBrillo.getText()));
						btnVerConfiguracionA.doClick();
					}
				}
			}
		});
		btnModificarBrillo1.setBounds(87, 255, 155, 36);
		contentPane.add(btnModificarBrillo1);

		JButton btnModificarContraste1 = new JButton("");
		btnModificarContraste1.setFocusTraversalKeysEnabled(false);
		btnModificarContraste1.setFocusPainted(false);
		btnModificarContraste1.setContentAreaFilled(false);
		btnModificarContraste1.setBorderPainted(false);
		btnModificarContraste1.setIcon(new ImageIcon(VerConfiguraciones.class.getResource("/recursos/button (1).png")));
		btnModificarContraste1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtContr.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingresa un valor.","Mensaje",JOptionPane.QUESTION_MESSAGE);
				} else {
					if (Integer.parseInt(txtContr.getText()) > 100 || Integer.parseInt(txtContr.getText()) < 0) {
						JOptionPane.showMessageDialog(null, "Valor no valido.","Mensaje",JOptionPane.WARNING_MESSAGE);
					} else {
						configuracion1.setPorcentajeContraste(Integer.parseInt(txtContr.getText()));
						btnVerConfiguracionA.doClick();
					}
				}
			}
		});
		btnModificarContraste1.setBounds(87, 289, 155, 41);
		contentPane.add(btnModificarContraste1);

		JButton btnModificarNitidez1 = new JButton("");
		btnModificarNitidez1.setFocusTraversalKeysEnabled(false);
		btnModificarNitidez1.setContentAreaFilled(false);
		btnModificarNitidez1.setBorderPainted(false);
		btnModificarNitidez1.setFocusPainted(false);
		btnModificarNitidez1.setIcon(new ImageIcon(VerConfiguraciones.class.getResource("/recursos/button (4).png")));
		btnModificarNitidez1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNiti.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingresa un valor.","Mensaje",JOptionPane.QUESTION_MESSAGE);
				} else {
					if (Integer.parseInt(txtNiti.getText()) > 100 || Integer.parseInt(txtNiti.getText()) < 0) {
						JOptionPane.showMessageDialog(null, "Valor no valido.","Mensaje",JOptionPane.WARNING_MESSAGE);
					} else {
						configuracion1.setPorcentajeNitidez(Integer.parseInt(txtNiti.getText()));
						btnVerConfiguracionA.doClick();
					}
				}
			}
		});
		btnModificarNitidez1.setBounds(87, 326, 155, 36);
		contentPane.add(btnModificarNitidez1);

		// Modificaciones para la configuracion 2

		JButton btnModificarBrillo2 = new JButton("");
		btnModificarBrillo2.setBorderPainted(false);
		btnModificarBrillo2.setContentAreaFilled(false);
		btnModificarBrillo2.setFocusTraversalKeysEnabled(false);
		btnModificarBrillo2.setFocusPainted(false);
		btnModificarBrillo2.setRequestFocusEnabled(false);
		btnModificarBrillo2.setIcon(new ImageIcon(VerConfiguraciones.class.getResource("/recursos/modificar2.png")));
		btnModificarBrillo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtBrillo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingresa un valor.","Mensaje",JOptionPane.QUESTION_MESSAGE);
				} else {
					if (Integer.parseInt(txtBrillo.getText()) > 100 || Integer.parseInt(txtBrillo.getText()) < 0) {
						JOptionPane.showMessageDialog(null, "Valor no valido.","Mensaje",JOptionPane.WARNING_MESSAGE);
					} else {
						configuracion2.setPorcentajeBrillo(Integer.parseInt(txtBrillo.getText()));
						btnVerConfiguracionB.doClick();
					}
				}
			}
		});
		btnModificarBrillo2.setBounds(258, 255, 166, 36);
		contentPane.add(btnModificarBrillo2);

		JButton btnModificarContraste2 = new JButton("");
		btnModificarContraste2.setFocusPainted(false);
		btnModificarContraste2.setBorderPainted(false);
		btnModificarContraste2.setContentAreaFilled(false);
		btnModificarContraste2.setIcon(new ImageIcon(VerConfiguraciones.class.getResource("/recursos/button.png")));
		btnModificarContraste2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtContr.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingresa un valor.","Mensaje",JOptionPane.QUESTION_MESSAGE);
				} else {
					if (Integer.parseInt(txtContr.getText()) > 100 || Integer.parseInt(txtContr.getText()) < 0) {
						JOptionPane.showMessageDialog(null, "Valor no valido.","Mensaje",JOptionPane.WARNING_MESSAGE);
					} else {
						configuracion2.setPorcentajeContraste(Integer.parseInt(txtContr.getText()));
						btnVerConfiguracionB.doClick();
					}
				}
			}
		});
		btnModificarContraste2.setBounds(258, 291, 166, 36);
		contentPane.add(btnModificarContraste2);

		JButton btnModificiarNitidez2 = new JButton("");
		btnModificiarNitidez2.setFocusTraversalKeysEnabled(false);
		btnModificiarNitidez2.setFocusPainted(false);
		btnModificiarNitidez2.setBorderPainted(false);
		btnModificiarNitidez2.setContentAreaFilled(false);
		btnModificiarNitidez2.setIcon(new ImageIcon(VerConfiguraciones.class.getResource("/recursos/button (2).png")));
		btnModificiarNitidez2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNiti.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingresa un valor.","Mensaje",JOptionPane.QUESTION_MESSAGE);
				} else {
					if (Integer.parseInt(txtNiti.getText()) > 100 || Integer.parseInt(txtNiti.getText()) < 0) {
						JOptionPane.showMessageDialog(null, "Valor no valido.","Mensaje",JOptionPane.WARNING_MESSAGE);
					} else {
						configuracion2.setPorcentajeNitidez(Integer.parseInt(txtNiti.getText()));
						btnVerConfiguracionB.doClick();
					}
				}
			}
		});
		btnModificiarNitidez2.setBounds(258, 326, 166, 36);
		contentPane.add(btnModificiarNitidez2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VerConfiguraciones.class.getResource("/recursos/2.png")));
		label.setBounds(0, 0, 434, 367);
		contentPane.add(label);

	}
}
