import java.util.Scanner;

public class Main {
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		char [] A = Integer.toString(sc.nextInt()).toCharArray();
		char [] B = Integer.toString(sc.nextInt()).toCharArray();
		
		char tmp = 0;
		
		tmp = A[0];
		A[0] = A[2];
		A[2] = tmp;
		
		tmp = B[0];
		B[0] = B[2];
		B[2] = tmp;
		
		int AA = Integer.parseInt(new String(A));
		int BB = Integer.parseInt(new String(B));
		
		if (AA > BB)
			System.out.println(AA);
		else
			System.out.println(BB);
	}
}

