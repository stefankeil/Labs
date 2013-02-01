#include <iostream>
using namespace std;
#include <fstream>
#include "reader.h"
#include "writer.h"
#include "letterCounter.h"

int main() {
	
	ifstream ifs("test.txt");
	Clread readDocument;
	
	readDocument.read(ifs);
	
	ifs.close();
	
	return 0;
}

