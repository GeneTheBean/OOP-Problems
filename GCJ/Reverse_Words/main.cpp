//https://code.google.com/codejam/contest/351101/dashboard#s=p1
#include <iostream>
#include <fstream>
#include <sstream>
#include <stack>
#include <stdlib.h>     /* atoi */
using namespace std;

int main()
{
    std::ifstream infile("input.txt");
    string word;
    stack<string> s;
    string str;
    int count, case_num = 1;
    infile >> count;
    infile.ignore();

    while (count>0 && count--){
        std::getline(infile, str);
        stringstream stream(str);
        for(int i = 0;stream >> word;i++){
            s.push(word);
        }
        printf("Case #%d: ",case_num);

        while(! s.empty()){
            cout<<s.top()<<" ";
            s.pop();
        }
        cout<<endl;
        case_num++;
    }
    return 0;
}
