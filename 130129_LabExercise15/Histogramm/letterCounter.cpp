using namespace std;
#include <iostream>
#include <fstream>
#include "letterCounter.h"
#include "writer.h"

char letterStore[127] = {'/0'};

void Clcounter::sorting(char letter){
	asciiCode = (int) tolower(letter);
	int number = 1;
	
	if (letterStore[asciiCode] == 0){
		letterStore[asciiCode] = number;
	}else{
		number = letterStore[asciiCode];
		number++;
		letterStore[asciiCode] = number;
	}	
}	

void Clcounter::counter(){
	
	Clwriter writeToDocument;

	for (int i = 0; i <= 127; i++) {
		int test = letterStore[i];
		if (test != 0 && i != 0 && i != 10 && i != 32 ) {
			char letter = (char) i;
			int whitespace = 9;
			writeToDocument.write(letter);
			writeToDocument.write((char) whitespace);
			for (int j = 0; j < test; j++) {
				char *stern = "*";
				writeToDocument.write(*stern);
			}
			int endline = 10;
			writeToDocument.write((char) endline);
		}
	}
}

void Clcounter::vertical(){
	
	int biggest = 0;
	ofstream ofs("histogramm.txt", ios::app);
	
	for (int i = 97; i <= 122; i++) {
		if (letterStore[i] > biggest){
			biggest = letterStore[i];
			
		}
	}
	
	//schleife für Spalten
	for (int i = biggest; i > 0; i--) {

		//Schleife für Zeilen
		for (int j = 97; j <= 122; j++) {
			if (letterStore[j] == i) {
				ofs << (char) 124;
				letterStore[j]--;
			}
			else {
				ofs << " ";
			}

		} ofs << endl;
		
	}
	
	for (int j = 97; j <= 122; j++) {
		ofs << (char)j;
	}
}

	
		

