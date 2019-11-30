#include <iostream>
using namespace std;

int main(void){
	int N;
	cin>>N;

	for(int i = 1 ; i <= N ; i++)
	{
		for(int a = 0; a < N-i; a++)
			cout<<' ';
		for(int b = 0; b < i; b++)
			cout<<'*';
		cout<<'\n';
	}
	return 0;
}
