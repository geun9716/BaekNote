import java.util.Scanner;
public class Main {
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		sc.close();
		int i = 1;
		
		if (B >= C)
			i = -1;
		else
		{
			i = (int)A/(C-B) + 1;
		}
		System.out.println(i);
	}
}
