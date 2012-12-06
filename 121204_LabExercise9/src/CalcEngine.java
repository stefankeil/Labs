import java.util.TreeSet;

public class CalcEngine {

	private TreeSet<Integer> result = new TreeSet<Integer>();
	public TreeSet<Integer> currentSet = new TreeSet<Integer>();
	public TreeSet<Integer> set = new TreeSet<Integer>();
	public String operator;
	public String displayString;

	public CalcEngine() {
		clear();
	}

	public TreeSet<Integer> getDisplayValue() {
		return result;
	}

	public String getDisplayString() {
		return displayString;
	}

	public void addToSet(int number) {
		displayString = displayString + number + " ";
		currentSet.add(number);
		result = currentSet;
		// System.out.println(currentSet);
	}

	public void buttonPressed(String command) {
		displayString = "[ " + displayString + "] " + command + " [ ";
		set.addAll(currentSet);
		currentSet.clear();
		operator = command;
	}

	public void equals() {
		switch (operator.charAt(0)) {
		case '∩':
			result = null;
			set.retainAll(currentSet);
			result = set;
			displayString = displayString + "]";
			break;
		case '∪':
			result = null;
			set.addAll(currentSet);
			result = set;
			displayString = displayString + "]";
			break;
		case '\\':
			result = null;
			set.removeAll(currentSet);
			result = set;
			displayString = displayString + "]";
			break;
		default:
			System.out.println("Es wurde ein falsches Format genutzt!");
			break;
		}
	}

	public int numberSet() {
		int numberOfSetElements = currentSet.size();
		return numberOfSetElements;
	}

	public void clear() {
		displayString = "";
		set.clear();
		currentSet.clear();
	}

	public String getTitle() {
		return "Java Calculator";
	}

	public String getAuthor() {
		return "Stefan Keil and Fee Braun";
	}

	public String getVersion() {
		return "Version 1.0";
	}
}