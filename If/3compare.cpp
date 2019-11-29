#include <iostream>
using namespace std;

int main(void){
	int a, b, c;

	cin>>a>>b>>c;

	if (a-b>0)
	{
		if(b-c < 0)
			if (a-c > 0)
				cout<<c;
			else
				cout<<a;
		else
			cout<<b;
	}
	else if (a-b < 0)
	{
		if (a-c < 0)
			if (b-c > 0)
				cout<<c;
			else
				cout<<b;
		else
			cout<<a;
	}
	else
	{
			cout<<a;
	}
}
