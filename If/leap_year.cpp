#include <iostream>
using namespace std;
int leapYear(int);

int main(void)
{
	int a;
	cin>>a;

	cout<<leapYear(a);
}
int leapYear(int i)
{
	if (!(i % 4))
	{
		if ((i % 100)||!(i % 400))
			return 1;
		else
			return 0;
	}
	else
		return 0;
}
