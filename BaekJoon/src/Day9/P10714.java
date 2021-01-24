package Day9;

import java.util.Arrays;
import java.util.Scanner;

public class P10714 {
	static int N;
	static long result;
	static long [] cake;
	static long [][] dp; // [i][j] j���� �ٶ� �� ���ʿ��� i��°, �����ʿ��� j��°  ����ũ, ���� ���� �� �ִ� ����ũ�� ��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cake = new long[N];
		dp = new long[N][N];
		for (int i = 0; i < N; i++) {
			cake[i] = sc.nextLong();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			//i���� ����ũ�� J���� �����鼭 ����
			int nxtl, nxtr;
			nxtl = i+1;
			if(nxtl == N) 
				nxtl = 0;
			nxtr = i-1;
			if(nxtr < 0) 
				nxtr = N-1;
		
			result = Math.max(result, cake[i] + I_eat(nxtl, nxtr));
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(dp[i]));	
//		}
		System.out.println(result);
	}
	// ���� ���ʰ� �Ǿ��µ� �ٶ� ���� ������ l����ũ, �������� r ����ũ�� ���� ��, ���� �Դ� ��
	static long J_eat(int l, int r) {
		if (l == r)
			return cake[l];
		if (dp[l][r] != -1)
			return dp[l][r];
		int nxtl, nxtr;
		nxtl = l+1;
		if(nxtl == N) 
			nxtl = 0;
		nxtr = r-1;
		if(nxtr < 0) 
			nxtr = N-1;
				
		//l�� �԰ų� //r�� �԰ų�
		//���� ū ���� ����
		dp[l][r] = Math.max(cake[l] + I_eat(nxtl, r), cake[r] + I_eat(l, nxtr));	
		return dp[l][r];
	}
	//I���� ���� ���ʰ� �Ǿ��µ� I���� ���� ���� �� �ִ� ��
	//I���� ���� ���ʰ� �Ǿ��µ� J���� ���� ���� �� �ִ� �� -> ����
	static long I_eat(int l ,int r) {
		if (l == r)
			return 0;
		if (dp[l][r] != -1)
			return dp[l][r];
		//���� �� �ִ� ����� ���� ���� ū�͸� �Ծ����.
		if(cake[l] > cake[r]) {
			//cake[l]
			int nxtl = l+1;
			if(nxtl == N) 
				nxtl = 0;
			return J_eat(nxtl, r);
		}
		else {
			//cake[r]
			int nxtr = r-1;
			if(nxtr < 0) 
				nxtr = N-1;
			return J_eat(l, nxtr);
		}
	}

}
