package Day4;

import java.util.Arrays;
import java.util.Scanner;

public class P3955 {
	static int T;
	static long A, B;
	
	public static void main(String[] args) {
		// X : �δ� ������ ������ ��
		// Y : ���� ������ ��
		// A * X + 1 = B * Y   =>    A(-x) + By = 1 
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int t=0; t < T ; t++) {
			//A, B �Է�
			A = sc.nextLong();
			B = sc.nextLong();
			
			//D = gcd(A, B)
			//D * k = C ==> C % D == 0 : ���� �׵��
			//Ȯ�� ��Ŭ���� ȣ������ �̿��Ͽ� s, t, r = D�� ã�Ƴ�.
			long [] str = eGcd(A, B);
			long D = str[2];

//			System.out.println(Arrays.toString(str));
			if(1 % D != 0) {
				System.out.println("IMPOSSIBLE");
				continue;
			}
			// x0 = s * (C/D)
			// y0 = t * (C/D)
			long x0 = str[0];		//C =1, D = 1
			long y0 = str[1];
//			System.out.println(x0+", "+ y0);
			//�Ϲ� �� ���� (k �� �Ϲ��ؿ��� ������ k)
			// x = x0 + B/D * k
			// y = y0 - A/D * k
			
			// x < 0 -> �������� ���¸� �����ֱ����� ��ȣ�� �ٲپ��� ������ 
			// x0 + B/D*k < 0
			// k < - x0 / B * D
			
			// 0 < y <= 10^9 (1e9)
			// 0 < y0 - A/D*k <= 1e9
			// -y0 < - A/D * k <= 1e9 - y0
			
			// (D/A) * (y0 - 1e9) <= k < y0 * (D/A)
			// 						k < - x0 / B*D
			long k1 = (long)Math.ceil((double)-x0 * D / B)-1;
			long k2 = (long)Math.ceil((double)y0 * D / A)-1;
//			System.out.println(k1+", "+k2);
			// k1�� k2�� ������ �ִ� ���̹Ƿ� ���� �����Ϸ��� min���� k�� max���� ���س��� �Ѵ�.
			// k�� max�� ���� �� �� k�� �̿��ؼ� y���� ���س��ϴ�. => k�� Ŀ���� y�� �۾����Ƿ�
			
			long k = (long)Math.min(k1, k2);
			long y = y0 - A/D * k;
			if (y <= 1e9) {
				System.out.println(y);
			}
			else
				System.out.println("IMPOSSIBLE");
			// �׷��� ���� y�� ���� ���� y���̴�.
			// �� y���� 1e9 ���� �۰ų� ������ ������ ��.
			// �ƴϸ� �Ұ����� ��.
		}
		
		sc.close();
	}

	// ax + by = c => as + bt = r�� �����ϴ� s, t, r ������ ã�� (r�� gcd(a,b)�϶�)
	static long[] eGcd(long a, long b) {
		long s0 = 1, t0 = 0, r0 = a;
		long s1 = 0, t1 = 1, r1 = b;
		
		long temp;
		while(r1 != 0) {
			long q = r0 / r1;
			
			temp = r0 - q * r1; // => ���ο� r ��
			r0 = r1;
			r1 = temp;
			
			temp = s0 - q * s1;
			s0 = s1;
			s1 = temp;
			
			temp = t0 - q * t1;
			t0 = t1;
			t1 = temp;
		}
		
		return new long[] {s0, t0, r0};
	}
}
