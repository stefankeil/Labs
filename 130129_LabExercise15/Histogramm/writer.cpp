#include <iostream>
using namespace std;
#include <fstream>
#include "writer.h"

void Clwriter::write(char input){
	
	ofstream ofs("frequency.txt", ios::app);
	
	ofs << input;
	
	//int num = 1;
//	ofs << num;
//	ofs << "Test";
}

