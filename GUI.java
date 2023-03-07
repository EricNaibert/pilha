package pilha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class GUI {
	
	static DefaultListModel<Integer> elementoLista;
	static JButton botao1;
	static JButton botao2;
	static JButton botao3;
	static JTextField input;
	static JFrame frame;
	static JPanel painel;
	static JPanel painelLista;
	static JPanel painelTexto;
	static JLabel label;
	static JTextPane areaTexto;
	static JList<Integer> lista;
	
	public GUI(){
		
		painel = new JPanel();
		label = new JLabel();
		areaTexto = new JTextPane();
	
		//Frame 
		frame = new JFrame();
		frame.pack();
		frame.setSize(600, 400);
		frame.setTitle("Stack Maker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(painel);
		
		//Buttons
		botao1 = new JButton("Adicionar");
		botao2 = new JButton("Remover");
		botao3 = new JButton("Ver Pilha");
		input = new JTextField();
		setUpButton();
		
		//List
		elementoLista = new DefaultListModel<>();
		lista = new JList<Integer>(elementoLista);
		lista.setFont(new Font("Arial", Font.BOLD, 17));
		
		//PanelList
		painelLista = new JPanel(new BorderLayout());
		painelLista.setBackground(lista.getBackground());
		painelLista.add(lista, BorderLayout.SOUTH);
		JScrollPane scroolPane = new JScrollPane(painelLista);
		scroolPane.setPreferredSize(new Dimension(200, 250));
		
		//PaneText
		painelTexto = new JPanel();
		painelTexto.add(areaTexto);
		areaTexto.setText("O Botão 'Adicionar' adiciona um elemento ao topo da pilha. \n\r O Botão 'Remover' remove o elemento do topo."
				+ "\n\r O Botão 'Ver Pilha' Abre um PopUp com os elementos da pilha. ");
		Color cinza = new Color(238, 238, 238);
		areaTexto.setBackground(cinza);
		
		//Panel
		label.setText("Pilha");
		painel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		painel.setBounds(5, 5, 500, 400);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 2;
		gbc.gridy = 0;
		painel.add(label, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		painel.add(areaTexto, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		painel.add(botao1, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 4;
		painel.add(scroolPane, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		painel.add(input, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		painel.add(botao2, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 4;
		painel.add(botao3, gbc);
		
		
		
		
	}
	
	public void setUpButton() {
		ActionListener buttonListener1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int number = Integer.parseInt(input.getText());
					elementoLista.add(0, number);
					input.setText("");
					input.requestFocus();
				} catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(frame, "Por favor, digite apenas numeros!");
				} catch(Exception exception) {
					JOptionPane.showMessageDialog(frame, exception);
				}
				
			}
		};
		
		ActionListener buttonListener2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					elementoLista.remove(0);
				} catch(ArrayIndexOutOfBoundsException exception) {
					JOptionPane.showMessageDialog(frame, "Você deve adicionar pelo menos um elemento antes de remover");
				}
				
			}
		};
		
		ActionListener buttonListener3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String oi = elementoLista.toString();
				JOptionPane.showMessageDialog(frame, oi);
				
			}
		};
		
		botao1.addActionListener(buttonListener1);
		botao2.addActionListener(buttonListener2);
		botao3.addActionListener(buttonListener3);
	}
		
	
	public static void main(String[] args) {
		new GUI();
		frame.setVisible(true);
	}

}
