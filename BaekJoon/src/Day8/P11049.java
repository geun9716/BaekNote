package Day8;

import java.awt.Point;
import java.util.Scanner;

public class P11049 {
	static int N, min = Integer.MAX_VALUE;
	static int [][] dp;
	static Point [] mat;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		mat = new Point[N+1];
		dp = new int [N+1][N+1];
		for (int i = 1; i <= N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			mat[i] = new Point(r, c);		
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
//		System.out.println(calc(1, N));
		
		solution2();
		System.out.println(dp[1][N]);
		
	}	
	//����� s���� e���� ����� �ؼ� ������ ���� ���� �Լ�.
	static int calc(int s, int e) {
		if(e - s == 1) {
			return mat[s].x * mat[s].y * mat[e].y;
		}
		if(e == s) {
			return 0;
		}
		//������ ó���� �ؼ� ��귮�� ���� ������
		//calc(s,e)�� ó������ ����� ���� ������, �׶� ����ߴ� ����� �����.
		// if...
		if(dp[s][e] != -1)
			return dp[s][e];
		//ó������ ����� �ϴϱ� �ϴ� ����� ��
		// �κ����� ������ ������ ���� ���Ѵ�.
		int mn= -1;
		for(int mid = s; mid < e ; mid++ ) {
			int tmp = calc(s,mid) + calc(mid+1,e) + mat[s].x * mat[mid].y * mat[e].y;
			if(mn == -1 || tmp < mn) mn = tmp;
		}
		//ó������ ��� �߱� ������ ��� ����� ������.
		dp[s][e] = mn;
		return mn;
	}
	static void solution2() {
		int len;
		for (len = 2; len <= N; len++) {
			for (int s = 1; s+len-1 < N; s++) {
				int e = s + len - 1;
				int mn = -1;
				for (int mid = s; mid <= e-1; mid++) {
					int tmp = dp[s][mid] + dp[mid+1][e] + mat[s].x * mat[mid].y * mat[e].y;
					if(mn == -1 || tmp < mn) mn = tmp;
				}
				dp[s][e] = mn;
			}
		}
	}
}
