import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A graphical user interface for the calculator. No calculation is being done
 * here. This class is responsible just for putting up the display on screen. It
 * then refers to the "CalcEngine" to do all the real work.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class UserInterface implements ActionListener {
	private CalcEngine calc;
	private Postfix evaluater;
	private boolean showingAuthor;

	private JFrame frame;
	private JTextField display;
	private JTextField stringDisplay;
	private JLabel status;
	private JPanel buttonPanelHex;

	/**
	 * Create a user interface.
	 * 
	 * @param engine
	 *            The calculator engine.
	 */
	public UserInterface(CalcEngine engine) {
		calc = engine;
		showingAuthor = true;
		makeFrame();
		frame.setVisible(true);
	}

	/**
	 * Set the visibility of the interface.
	 * 
	 * @param visible
	 *            true if the interface is to be made visible, false otherwise.
	 */
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	/**
	 * Make the frame for the user interface.
	 */
	private void makeFrame() {
		frame = new JFrame(calc.getTitle());

		JPanel contentPane = (JPanel) frame.getContentPane();
		JPanel numberPane = new JPanel();
		numberPane.setLayout(new BorderLayout());
		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		display = new JTextField();
		stringDisplay = new JTextField();
		contentPane.add(stringDisplay, BorderLayout.NORTH);
		contentPane.add(numberPane, BorderLayout.CENTER);
		numberPane.add(display, BorderLayout.NORTH);
		
		
		

		JPanel buttonPanelContainer = new JPanel(new BorderLayout());

		JPanel buttonPanel = new JPanel(new GridLayout(3, 6));
		addButton(buttonPanel, "+");
		addButton(buttonPanel, "-");
		addButton(buttonPanel, "*");
		addButton(buttonPanel, "/");
		addButton(buttonPanel, "Deg");
		addButton(buttonPanel, "Hex");

		addButton(buttonPanel, "9");
		addButton(buttonPanel, "8");
		addButton(buttonPanel, "7");
		addButton(buttonPanel, "6");
		addButton(buttonPanel, "Clear");
		addButton(buttonPanel, "=");

		addButton(buttonPanel, "5");
		addButton(buttonPanel, "4");
		addButton(buttonPanel, "3");
		addButton(buttonPanel, "2");
		addButton(buttonPanel, "1");
		addButton(buttonPanel, "0");
		addButton(buttonPanel, "Pfx");
		addButton(buttonPanel, "Infx");

		buttonPanelHex = new JPanel(new GridLayout(1, 6));
		addButton(buttonPanelHex, "A");
		addButton(buttonPanelHex, "B");
		addButton(buttonPanelHex, "C");
		addButton(buttonPanelHex, "D");
		addButton(buttonPanelHex, "E");
		addButton(buttonPanelHex, "F");

		buttonPanelContainer.add(buttonPanel, BorderLayout.NORTH);
		buttonPanelContainer.add(buttonPanelHex, BorderLayout.SOUTH);
		numberPane.add(buttonPanelContainer, BorderLayout.CENTER);

		status = new JLabel(calc.getAuthor());
		contentPane.add(status, BorderLayout.SOUTH);

		frame.pack();
		buttonPanelHex.setVisible(false);
	}

	/**
	 * Add a button to the button panel.
	 * 
	 * @param panel
	 *            The panel to receive the button.
	 * @param buttonText
	 *            The text for the button.
	 */
	private void addButton(Container panel, String buttonText) {
		JButton button = new JButton(buttonText);
		button.addActionListener(this);
		panel.add(button);
	}

	/**
	 * An interface action has been performed. Find out what it was and handle
	 * it.
	 * 
	 * @param event
	 *            The event that has occured.
	 */
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		String currentValue = display.getText();
		if (command.equals("0") || command.equals("1") || command.equals("2")
				|| command.equals("3") || command.equals("4")
				|| command.equals("5") || command.equals("6")
				|| command.equals("7") || command.equals("8")
				|| command.equals("9")) {
			int number = Integer.parseInt(command);
			calc.numberPressed(number);

		} else if (command.equals("A") || command.equals("B")
				|| command.equals("C") || command.equals("D")
				|| command.equals("E") || command.equals("F")) {
			calc.hexPressed(command);

		} else if (command.equals("+")) {
			calc.plus();

		} else if (command.equals("-")) {
			calc.minus();

		} else if (command.equals("=")) {
			calc.equals();

		} else if (command.equals("Clear")) {
			calc.clear();

		} else if (command.equals("/")) {
			calc.divide();

		} else if (command.equals("*")) {
			calc.multiply();

		} else if (command.equals("Hex")) {
			buttonPanelHex.setVisible(true);

		} else if (command.equals("Deg")) {
			buttonPanelHex.setVisible(false);
		} else if (command.equals("Pfx")) {
			try {
				String result = evaluater.evaluate(currentValue);
				display.setText(result);
			} catch (UnderflowException e) {
				JOptionPane.showMessageDialog(frame, "Der Stack ist leer");
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(frame, "Jede Zahl und jeder Operator muss durch ein Leerzeichen getrennt sein.");
			}
		} else if (command.equals("Infx")) {
			try {
				String result = evaluater.infixToPostfix(currentValue);
				display.setText(result);
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(frame, "Jede Zahl und jeder Operator muss durch ein Leerzeichen getrennt sein.");
			} catch (UnderflowException e) {
				JOptionPane.showMessageDialog(frame, "Der Stack ist leer");
			} catch (FormatException e) {
				JOptionPane.showMessageDialog(frame, "Bitte benutzen Sie nur die Operatoren / * - +");
			}
		}
		// else unknown command.

		redisplay();

	}

	/**
	 * Update the interface display to show the current value of the calculator.
	 */
	private void redisplay() {
		if (buttonPanelHex.isVisible()) {
			display.setText(""
					+ Integer.toHexString((int) calc.getDisplayValue())
							.toUpperCase());
		} else {
			display.setText("" + calc.getDisplayValue());
		}
	}

	/**
	 * Toggle the info display in the calculator's status area between the
	 * author and version information.
	 */
	// private void showInfo()
	// {
	// if(showingAuthor)
	// status.setText(calc.getVersion());
	// else
	// status.setText(calc.getAuthor());
	//
	// showingAuthor = !showingAuthor;
	// }
}