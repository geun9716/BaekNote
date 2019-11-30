#include <iostream>
using namespace std;

int main(void){
	int N, X;

	cin>>N>>X;

	int a[N];

	for(int i = 0; i < N ; i++)
		cin>>a[i];


	for(int i = 0; i < N ; i++)
		if (a[i]<X)
			cout<<a[i]<<' ';

	return 0;
}
