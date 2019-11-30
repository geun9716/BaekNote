#include <iostream>

using namespace std;

int main(void){

	int n;

	cin>>n;
	int a[n], b[n];

	for(int i = 0; i < n ; i++)
		cin>>a[i]>>b[i];

	for(int i = 0; i < n ; i++)
		cout<<a[i]+b[i]<<endl;
	return 0;
}
