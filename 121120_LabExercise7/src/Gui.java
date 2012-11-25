import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Gui extends JFrame implements ActionListener {
	private Postfix evaluater;

	private JTextField postfixDisplay;
	private JTextField infixDisplay;

	public Gui(Postfix engine) {
		evaluater = engine;
		makeFrame();
		this.setVisible(true);
	}

	private void makeFrame() {
		this.setTitle("Postfix/Infix Evaluater");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		postfixDisplay = new JTextField();
		JButton buttonPfx = new JButton("evaluate Postfix Expression");
		buttonPfx.setToolTipText("Please put a blank between Operator and Operand. e.g.:3 3 +");
		buttonPfx.addActionListener(this);
		contentPane.add(postfixDisplay);
		contentPane.add(buttonPfx);

		infixDisplay = new JTextField();
		JButton buttonIfx = new JButton("evaluate Infix Expression");
		contentPane.add(infixDisplay);
		buttonIfx.addActionListener(this);
		contentPane.add(buttonIfx);
		
		JLabel status = new JLabel("Created by Fee Braun & Stefan Keil");
		contentPane.add(status);
		this.pack();
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();

		if (command.equals("evaluate Postfix Expression")) {
			String currentValue = postfixDisplay.getText();
			try {
				String result = evaluater.evaluate(currentValue);
				postfixDisplay.setText(result);
			} catch (UnderflowException e) {
				JOptionPane.showMessageDialog(Gui.this, "Der Stack ist leer");
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(Gui.this, "Jede Zahl und jeder Operator muss durch ein Leerzeichen getrennt sein.");
			}
		} else if (command.equals("evaluate Infix Expression")) {
			String currentValue = infixDisplay.getText();
			try {
				String result = evaluater.infixToPostfix(currentValue);
				infixDisplay.setText(result);
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(Gui.this, "Jede Zahl und jeder Operator muss durch ein Leerzeichen getrennt sein.");
			} catch (UnderflowException e) {
				JOptionPane.showMessageDialog(Gui.this, "Der Stack ist leer");
			} catch (FormatException e) {
				JOptionPane.showMessageDialog(Gui.this, "Bitte benutzen Sie nur die Operatoren / * - +");
			}
		 }
	}
}
