#include <iostream>
using namespace std;

void arabienToRom(int number);

int main (int argc, char * const argv[]) {
    int number = 0;
	int size = 0;
	int numberArray[100];
	
	cin >> number;
	numberArray[size] = number;
	size++;
	
	while (number >= 0) {
		cin >> number;
		numberArray[size] = number;
		size++;
	}	
	
	for (int i=0; i < size-1; i++) {
		arabienToRom(numberArray[i]);
	}
    return 0;
}

void arabienToRom(int arabian)
{
	int orgNumber = arabian;
	char result [10];
	char roman[8] = "mdclxvi";
	int values[7] = {1000,500,100,50,10,5,1};
	int place=0;
	
	for (int i = 0; i < 7; i++)
    {
		while (arabian >= values[i])
		{
			result[place] = roman[i];
			arabian -= values[i];
			place++;
		}
    }
	result[place]='\0';
	
	cout << orgNumber << "= " << result << endl;
	
}
