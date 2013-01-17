#include <iostream>
using namespace std;

int main () {
    int number = 100;
	bool prime;
	
	for (int primeNumber = 3; primeNumber < number; primeNumber++) {
		for (int j = 2; j < number; j++) {
			if (primeNumber % j == 0) {
				if (primeNumber == j) {
					prime = true;
				} else {
					prime = false;
					//cout << "false: " << primeNumber << " " << primeNumber % j << endl;
					break;
				}
			} else {
				prime = true;		
			}
		}
		if (prime == true) {
			cout << primeNumber << endl;
		}
	}
	
    return 0;
}
