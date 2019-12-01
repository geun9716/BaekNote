#include <iostream>
using namespace std;

int main(void){
	int N, first;
	int i = 0;
	int a[2];
	int b;

	cin>>N;

	first = N;
	
	while(1){	
	
		if (N < 10)
		{
			a[0] = 0;
			a[1] = N;
		}
		else
		{
			a[0] = N / 10;
			a[1] = N % 10;	
		}

		b = a[0] + a[1];
		
		N = a[1]*10 + (b % 10);	
		
		i++;
		
		if(first == N)
			break;
	}

	cout<<i;
}
