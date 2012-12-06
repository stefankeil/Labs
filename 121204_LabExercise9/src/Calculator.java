public class Calculator {
	private CalcEngine engine;
	private UserInterface gui;

	public Calculator() {
		engine = new CalcEngine();
		gui = new UserInterface(engine);
	}

	public void show() {
		gui.setVisible(true);
	}
}