import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int tmp = 0;
		int sum = 0;
		sc.close();
		
		for(int i = N/5 ; i >= 0 ; i--, sum = 0)
		{
			tmp = N-(5*i);
			while(tmp != 0) {
				sum += tmp % 10;
				tmp /= 10;
			}
			
			if (sum%3 == 0)
			{
				System.out.println(i+((N-(5*i))/3));
				return ;
			}
		}
		
		System.out.println(-1);
		return ;
	}
}

