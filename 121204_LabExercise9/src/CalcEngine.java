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
		currentSet.add(number);
	}
	
	public void buttonPressed(String command){
		set = currentSet;
		currentSet.clear();
		operator = command;
	}

	
	public void equals() {
		switch(operator.charAt(0)){
		case '∩':
			set.retainAll(currentSet);
			result = set;
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
		currentSet.size();
	}
//	public TreeSet<Integer> onlyEqual(TreeSet<Integer> set){
//		for ()
//		if (!currentSet.add(i)){
//			
//		}
//	}

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
