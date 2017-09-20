#include <iostream>
#include <map>
#include <fstream>
#include <stdlib.h>
using namespace std;
void set_up_map(map<string, int>&);
void print_and_test(char, map<string,int>&);
static int prev; //used to keep track of previously printed character
int main()
{
    std::ifstream infile("input.txt");
    int count;
    infile >> count;
    map<string, int> m;
    set_up_map(m);
    string str;
    infile.ignore();

    for(int i = 0;i<count;i++){
        std::getline(infile, str);
        printf("Case #%d: ", i+1);
        for(int j = 0;j<str.length();j++){
             print_and_test(str[j], m);
        }
        cout<<endl;
    }
    return 0;
}

void set_up_map(map<string, int> & a){
    a["A"] = 2; a["B"] = 22; a["C"] = 222;
    a["D"] = 3; a["E"] = 33; a["F"] = 333;
    a["G"] = 4; a["H"] = 44; a["I"] = 444;
    a["J"] = 5; a["K"] = 55; a["L"] = 555;
    a["M"] = 6; a["N"] = 66; a["O"] = 666;
    a["P"] = 7; a["Q"] = 77; a["R"] = 777; a["S"] = 7777;
    a["T"] = 8; a["U"] = 88; a["V"] = 888;
    a["W"] = 9; a["X"] = 99; a["Y"] = 999; a["Z"] = 9999;
    a[" "] = 0;
}

void print_and_test(char c, map<string,int>& a){
    string s = "";
    s += toupper(c);
    if(prev > 0){ //Tests to see if character belongs to the same number
        if(abs(prev-a[s])%10 == 0)
            cout<<" ";
    }
    cout<<a[s];
    prev = a[s];
}

