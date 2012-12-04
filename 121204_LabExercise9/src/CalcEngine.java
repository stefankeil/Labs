/**
 * The main part of the calculator doing the calculations.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
import java.util.TreeSet;

public class CalcEngine {

	private TreeSet<Integer> result;
	public TreeSet<Integer> currentSet = new TreeSet<Integer>();
	public TreeSet<Integer> set = new TreeSet<Integer>();
	public String operator;
	public String displayString;

	public CalcEngine() {
		clear(); 
	}

	/**
	 * @return The value that should currently be displayed on the calculator
	 *         display.
	 */
	public TreeSet<Integer> getDisplayValue() {
		return result;
	}

	public String getDisplayString() {
		return displayString;
	}

	/**
	 * A number button was pressed. Either start a new operand, or incorporate
	 * this number as the least significant digit of an existing one.
	 * 
	 * @param number
	 *            The number pressed on the calculator.
	 */

	public void addToSet(int number){
		displayString = displayString  + number;
		currentSet.add(number);
		System.out.println(currentSet);
	}
	
	public void buttonPressed(String command){
		displayString = displayString  + command;
		set.addAll(currentSet);
		currentSet.clear();
		System.out.println(currentSet);
		System.out.println(set);
		operator = command;
	}

	
	public void equals() {
		switch(operator.charAt(0)){
		case '∩':
			System.out.println(set);
			System.out.println(currentSet);
			set.retainAll(currentSet);
			result = set;
			System.out.println(result);
			break;
		case '∪':
			set.addAll(currentSet);
			result = set;
			break;
		case '\\':
			set.removeAll(currentSet);
			result = set;
		}
	}
	
	public void numberSet(){
		System.out.println(currentSet.size());
		System.out.println(result);
		result.add(2);
		//result.add(currentSet.size());
		System.out.println(result);
	}

	public void clear() {
		displayString = "";
		set.clear();
		currentSet.clear();
//		result.clear();
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
