#include <iostream>
using namespace std;
#include <fstream>
#include "reader.h"
#include "letterCounter.h"
#include "writer.h"

void Clread::read(ifstream &ifs)
{
	//try {
		Clcounter count;
		//ifs.exceptions( std::ios::failbit );   // throw if failbit get set*/
		
		while (ifs.good()) {
			ifs.get(letter);
			count.sorting(letter);
		}
	
	count.counter();
	count.vertical();	
				
	//} catch( const std::exception & ex ) {
//		std::cerr << "Fail - reason is " << ex.what();
//	}
}

