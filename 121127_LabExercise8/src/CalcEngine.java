/**
 * The main part of the calculator doing the calculations.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */

public class CalcEngine {

	//private int displayValue;
	private String displayString= "";
	//private String hexDisplayString;
	private Boolean hexon;
	//private String result;
	private Postfix evaluater;
	private String result;
	

	public CalcEngine() {
		evaluater = new Postfix();
		clear();
	}

	/**
	 * @return The value that should currently be displayed on the calculator
	 *         display.
	 */
	public String getDisplayValue() {
		return result;
	}

	public String getDisplayString() {
		return displayString;
	}
	public String getHexDisplayString() {
		displayString = hexResult(displayString);
		return displayString;
	}

	/**
	 * A number button was pressed. Either start a new operand, or incorporate
	 * this number as the least significant digit of an existing one.
	 * 
	 * @param number
	 *            The number pressed on the calculator.
	 */
	public void buttonPressed(String inputString) {
		if (inputString.matches("(\\d)")){
			displayString = displayString  + inputString;
		}else{
			displayString = displayString  + " " + inputString + " ";
		}
	}

	public void hexPressed(String hexNumber) {
		
			displayString = displayString  + hexNumber;
			hexon = true;
	}

	
	public void equals() {
		if(hexon = false){
			try {
				String result = evaluater.infixToPostfix(displayString);
				displayString = evaluater.evaluate(result);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
		try {
			result = evaluater.infixToPostfix(displayString);
			displayString = evaluater.evaluate(result);
			displayString = hexResult(displayString);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}	
	}
	public String hexResult(String x){
		int hexValue = Integer.parseInt(x, 16);
		displayString = Integer.toHexString(hexValue);
		return displayString;
		
	}

	public void clear() {
		displayString = "";
	}

	/**
	 * @return The title of this calculation engine.
	 */
	public String getTitle() {
		return "Java Calculator";
	}

	/**
	 * @return The author of this engine.
	 */
	public String getAuthor() {
		return "David J. Barnes and Michael Kolling";
	}

	/**
	 * @return The version number of this engine.
	 */
	public String getVersion() {
		return "Version 1.0";
	}
}
