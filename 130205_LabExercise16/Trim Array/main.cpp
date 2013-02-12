//
//  main.cpp
//  Exercise 16
//
//  
//  Copyright (c) 2013 Stefan/Fee. All rights reserved.
//

//Write a method in C++ void removeSpaces (char* s) that removes all blanks in a char array s. For example, "a bb ccc d" will be changed "to abbcccd". Use pointers! Is there a difference in calling this with a string or a character array? Now overload removeSpaces and make it take an array of char arrays, and remove the spaces out of all elements of the array, using pointers.

#include <iostream>
using namespace std;
// prototype
void removeSpaces (char *s);
void removeSpaces (char *sArray[]);

int main(){
    
    char test1[] = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr";
    char test2[] = "sed diam nonumy eirmod tempor";
    char *input[] = {test1,test2,0};
    
    removeSpaces(input);
    
    for (int i=0; input[i] ;i++){
        cout << input[i] << endl;}
    
    return 0;
}

void removeSpaces (char *s){
    
    //pointer
    char *ptn;
    // p points to the adress s is pointing to, condition while s don´t point to the last element in the array \0,increase s
    for(ptn=s; *s != '\0'; s++){
        // if s don´t points to a whitespace,the ptn points to the value s is poiting to, after this ptn points to the next adress(value)
        if(*s != ' '){
            *ptn++ = *s;
        }
    }// finish the char array
    *ptn = '\0';
}

void removeSpaces (char *sArray[]){
    // while there is sth. to poiting to
    while (*sArray) {
        //  remove space from the current char array *sArray is poitning to (e.g test1), then inrcrease the adress sArray is poiting to
        removeSpaces(*sArray);
        sArray++;
    }
}
