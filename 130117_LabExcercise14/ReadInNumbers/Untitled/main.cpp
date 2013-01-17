#include <iostream>
using namespace std;

int main () {
	int numberArray[100];
	int number = 0;
	int minimum = 0;
	int maximum = 0;
	float average = 0;
	int size = 0;
	
	cin >> number;
	numberArray[size] = number;
	size++;
	
	while (number >= 0) {
		cin >> number;
		numberArray[size] = number;
		size++;
	}
	
	for (int i = 0; i <= size; i++) {
		if (numberArray[i] > maximum) {
			maximum = numberArray[i];
		} else if (numberArray[i] < minimum) {
			minimum = numberArray[i];
		}
		
		average += numberArray[i];
	}
	
	
	cout << "Maximum: " << maximum
		 << endl;
	cout << "Minimum: " << minimum 
		 << endl;
	cout << "Average: " << average/size;
	
	return 0;
	
}
