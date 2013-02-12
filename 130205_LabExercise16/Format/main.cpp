//
//  main.cpp
//  Format
//
//  
//  Copyright (c) 2013 Fee/Stefan. All rights reserved.

//  Write a class Format that formats numbers right-justified and with a specific number of decimal places.
//  How will you handle numbers less than 1, but greater than 0? Negative numbers?
//  Format f(12,3); // Output 12 characters wide, 3 decimal places

// Using f
// cout << f.toString(789.90687) << endl;
// cout << f.toString(-123456789.45907) << endl;
//
// The result of the first line should be
// 789.907
// and the second line (note that the number is too big!):
// -123456789.459

#include <iostream>
#include <sstream>
#include <iomanip>
using namespace std;

class Format{

private:
    int wide, decimal;
    
public:
// Output 12 characters wide, 3 decimal places
    
    Format (int w,int d){
        wide = w;
        decimal = d;
    }
    
    string toString(double zahl){
        // stringstream(puts zahl into string) with fixed notation by decimal value
        ostringstream sstream;
        sstream << fixed << setprecision(decimal) << zahl;
        string sstr = sstream.str();
        // Size of indent 
        int diff = (int)(wide - sstr.length());
        
        string whitespaces;
        
        if(diff > 0){
            char newStrg[diff];
            
            for(int i=0;i<diff;i++){
                newStrg[i] = ' ';
            }
            newStrg[diff]= '\0';
            
            whitespaces = newStrg;
            // append the number after the indent
            whitespaces.append(sstr);
        }
        return whitespaces;
        
    }
};
// class Currency outputs a currency symbol + formated number
class Currency : Format{
public:
    // derived constructor
    Currency(int w,int d):Format(w,d){}
    
    string toString(double zahl, string Symbol){
        // call toString from parent class
        string formated = Format::toString(zahl);
        string currencyStr;
        
        if (Symbol.compare("€")== 0) {currencyStr = appendtoEnd(formated, Symbol);}
        else if (Symbol.compare("元")== 0){currencyStr = appendtoEnd(formated, Symbol);}
        else if (Symbol.compare("£")==0){currencyStr = appendtoBegin(formated, Symbol);}
        else if (Symbol.compare("$")== 0){currencyStr = appendtoBegin(formated, Symbol);}
        
            
        // e.g. $123.345
        return currencyStr;
        
    }
private:
    // append the number after currency symbol
    string appendtoBegin(string f, string s){
        s.append(f);
        return s;
    }
    // append the currency symbol after the number
    string appendtoEnd(string f, string s){
        f.append(s);
        return f;
    }
    
    
};
    
int main()
{
    
    Format f = Format(12,3);
    double zahl = -123456.45907;
    double zahl2 = 123456.45907;
    double zahl3 = -156.4523907;
    
    cout << f.toString(zahl) << endl;
    cout << f.toString(zahl2) << endl;
    cout << f.toString(zahl3) << endl;
    
    Currency c = Currency(12,3);
    double zahl4 = -123456.45907;
    double zahl5 = 123456.45907;
    double zahl6 = -156.4523907;
    
    string symbol1 = "€";
    string symbol2 = "$";
    string symbol3 = "元";
    
    cout << c.toString(zahl4,symbol1) << endl;
    cout << c.toString(zahl5,symbol2) << endl;
    cout << c.toString(zahl6,symbol3) << endl;


    return 0;
}

