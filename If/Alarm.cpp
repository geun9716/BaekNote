#include <iostream>
using namespace std;

int main(void)
{
	int H, M;

	cin>>H>>M;

	if (M >= 45)
		M-=45;
	else{
		H-=1;
		M+=15;
	}
	
	if (H < 0)
		H+=24;
	cout<<H<<" "<<M;

}
