#include <iostream>
using namespace std;

int main(void){
	int a, b;

	cin>>a>>b;

	if (a-b > 0)
		cout<<">";
	else if (a-b < 0)
		cout<<"<";
	else
		cout<<"==";

}
