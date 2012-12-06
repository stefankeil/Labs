import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class UserInterface extends JFrame implements ActionListener {
	private CalcEngine calc;
	private boolean showingAuthor;

	private JTextField display;
	private JTextField stringDisplay;
	private JLabel status;

	public UserInterface(CalcEngine engine) {
		calc = engine;
		showingAuthor = true;
		makeFrame();
		this.setVisible(true);
	}

	private void makeFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel contentPane = (JPanel) this.getContentPane();
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

		JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
		addButton(buttonPanel, "∩");
		addButton(buttonPanel, "∪");
		addButton(buttonPanel, "\\");
		addButton(buttonPanel, "PUSH");

		addButton(buttonPanel, "Clear");
		addButton(buttonPanel, "9");
		addButton(buttonPanel, "8");
		addButton(buttonPanel, "7");

		addButton(buttonPanel, "6");
		addButton(buttonPanel, "5");
		addButton(buttonPanel, "4");
		addButton(buttonPanel, "3");

		addButton(buttonPanel, "2");
		addButton(buttonPanel, "1");
		addButton(buttonPanel, "0");
		addButton(buttonPanel, "=");

		buttonPanelContainer.add(buttonPanel, BorderLayout.NORTH);
		numberPane.add(buttonPanelContainer, BorderLayout.CENTER);

		status = new JLabel(calc.getAuthor());
		contentPane.add(status, BorderLayout.SOUTH);

		this.pack();
	}

	private void addButton(Container panel, String buttonText) {
		JButton button = new JButton(buttonText);
		button.addActionListener(this);
		panel.add(button);
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals("0") || command.equals("1") || command.equals("2")
				|| command.equals("3") || command.equals("4")
				|| command.equals("5") || command.equals("6")
				|| command.equals("7") || command.equals("8")
				|| command.equals("9")) {
			calc.addToSet(Integer.parseInt(command));

		} else if (command.equals("∩")) {
			calc.buttonPressed(command);

		} else if (command.equals("∪")) {
			calc.buttonPressed(command);

		} else if (command.equals("=")) {
			calc.equals();

		} else if (command.equals("Clear")) {
			calc.clear();

		} else if (command.equals("\\")) {
			calc.buttonPressed(command);

		} else if (command.equals(",")) {
			calc.buttonPressed(command);

		} else if (command.equals("PUSH")) {
			int st = calc.numberSet();
			JOptionPane.showMessageDialog(null,
					"Die Anzahl der Elemente beträgt: " + st,
					"Eig. des aktuellen Sets", JOptionPane.PLAIN_MESSAGE);
		}
		redisplay();
	}

	private void redisplay() {
		display.setText(calc.getDisplayValue().toString());
		stringDisplay.setText(calc.getDisplayString());
	}
}