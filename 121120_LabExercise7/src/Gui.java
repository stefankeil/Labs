import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Gui implements ActionListener {
	private Postfix evaluater;

	private JFrame frame;
	private JTextField PostfixDisplay;
	private JTextField InfixDisplay;
	String currentValue;

	private JLabel status;

	public Gui(Postfix engine) {
		evaluater = engine;
		makeFrame();
		frame.setVisible(true);
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	private void makeFrame() {
		frame = new JFrame("Postfix/Infix Evaluater");

		JPanel contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		PostfixDisplay = new JTextField();
		JButton buttonpfx = new JButton("evaluate Postfix Expression");
		buttonpfx.setToolTipText("Please put a blank between Operator and Operand. e.g.:3 3 +");
		buttonpfx.addActionListener(this);
		contentPane.add(PostfixDisplay);
		contentPane.add(buttonpfx);

		InfixDisplay = new JTextField();
		JButton buttonifx = new JButton("evaluate Infix Expression");
		contentPane.add(InfixDisplay);
		buttonifx.addActionListener(this);
		contentPane.add(buttonifx);
		
		status = new JLabel("Created by Fee Braun & Stefan Keil");
		contentPane.add(status);
		frame.pack();
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();

		if (command.equals("evaluate Postfix Expression")) {
			currentValue = PostfixDisplay.getText();
			try {
				evaluater.evaluate(currentValue);
				PostfixDisplay.setText(evaluater.getFinalResult());
			} catch (UnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// } else if (command.equals("evaluate Infix Expression")) {
		// currentValue = InfixDisplay.getText();
		// try {
		// evaluater.infixToPostfix(currentValue);
		// InfixDisplay.setText(evaluater.getFinalResult());
		// } catch (UnderflowException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}
}
