public class Postfix {

	// private Stack stack;
	// der String muss leerzeichen zwischen den einzelnen term bzw. operatoren
	// enthalten

	public String evaluate(String pfx) throws UnderflowException,
			IllegalArgumentException {
		int rest = 0;
		String finalResult = null;
		if (!pfx.equals("")) {
			Stack<Integer> ablage = new Stack<Integer>();
			String[] stringArray = pfx.split(" ");
			String operator;
			LinkedListItem<Integer> lhs;
			LinkedListItem<Integer> rhs;
			for (int i = 0; i < stringArray.length; i++) {
				if (stringArray[i].matches("(\\d{1,2})")) {
					ablage.push(Integer.parseInt(stringArray[i]));
				} else {
					if (stringArray[i].length() > 1) {
						throw new IllegalArgumentException();
					}
					operator = stringArray[i];
					if (!ablage.empty()) {
						rhs = ablage.pop();
						lhs = ablage.pop();
						if (operator.equals("+")) {
							int result = lhs.value + rhs.value;
							rest = 0;
							ablage.push(result);
						} else if (operator.equals("-")) {
							int result = lhs.value - rhs.value;
							rest = 0;
							ablage.push(result);
						} else if (operator.equals("*")) {
							int result = lhs.value * rhs.value;
							rest = 0;
							ablage.push(result);
						} else if (operator.equals("/")) {
							int result = lhs.value / rhs.value;
							rest = lhs.value % rhs.value;
							ablage.push(result);
						} else if (operator.equals("^")) {
							int result = (int) Math.pow(lhs.value, rhs.value);
							rest = 0;
							ablage.push(result);
						}
					}
				}
			}

			finalResult = ablage.pop().value.toString();
			if (rest > 0) {
				finalResult = finalResult + "  + Rest von: " + rest;
			}
		}
		return finalResult;
	}

	public String infixToPostfix(String ifx) throws UnderflowException,
			FormatException, IllegalArgumentException {
		Stack<String> operatorAblage = new Stack<String>();
		String[] stringArray = ifx.split(" ");
		String numberString = "";
		LinkedListItem<String> operator;
		int priority;

		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i].matches("(\\d{1,2})")) {
				numberString += stringArray[i] + " ";
			} else {
				if (stringArray[i].length() > 1) {
					throw new IllegalArgumentException();
				}
				priority = findPriority(stringArray[i]);
				if (!operatorAblage.empty()) {
					while (!operatorAblage.empty() && operatorAblage.top().priority <= priority) {
						numberString += operatorAblage.pop().value + " ";
					}
					operatorAblage.push(stringArray[i]);
					operatorAblage.top().priority = priority;
					if (operatorAblage.top().priority > priority) {
						operatorAblage.push(stringArray[i]);
						operatorAblage.top().priority = priority;
					}

				} else {
					operatorAblage.push(stringArray[i]);
					operatorAblage.top().priority = priority;
				}
			}
		}

		while (!operatorAblage.empty()) {
			numberString += operatorAblage.pop().value + " ";
		}

		// System.out.println("Postfix: " + numberString);
		return numberString;
	}

	public int findPriority(String operator) {
		if (operator.equals("*") || operator.equals("/")) {
			return 2;
		} else if (operator.equals("+") || operator.equals("-")) {
			return 3;
		} else if (operator.equals("h")) {
			return 1;
		} else {
			return 0;
		}
	}
}
