package Day9;

import java.util.Arrays;
import java.util.Scanner;

public class P2342 {
	static int n=0, INF = 8000000;
	static int [] step = new int [100010];
	static int [][] power = new int [5][5];
	static int [][][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
				
		for (int i = 1; i < 5; i++) {
			power[0][i] = 2;
		}
		
		power[1][2] = power[1][4] = 3;
		power[2][1] = power[2][3] = 3;
		power[3][2] = power[3][4] = 3;
		power[4][1] = power[4][3] = 3;
		
		power[1][3] = power[2][4] = power[3][1] = power[4][2] = 4;
		
		for(int i = 1; i < 5 ; i++) {
			power[i][i] = 1;
		}
		
		while(true) {
			step[n] = sc.nextInt();
			if(step[n] == 0) break;
			n++;
		}
		dp = new int [n+1][5][5];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 5; j++) {
				for (int j2 = 0; j2 < 5; j2++) {
					dp[i][j][j2] = INF;
				}
			}
		}
		dp[0][0][0] = 0;
		//�ܰ踦 �����غ���
		for(int i = 0 ; i < n ; i++) {
			// <i> �ܰ��� ����� �� ���°�, <i+1> �ܰ�� ���� ����.
			for (int l = 0; l <= 4; l++) {
				for (int r = 0; r <= 4; r++) {
					int ddr = step[i+1], used_power;
					//dp[i][l][r] : i�ܰ��϶� �޹� l, ������ r�϶� �Ҹ��� ��
					//�޹��� �������� -> dp[i+1][step[i+1]][r]
					used_power = dp[i][l][r] + power[l][ddr];
					if (ddr != r && used_power < dp[i+1][ddr][r]) {
						dp[i+1][ddr][r] = used_power;
					}
					
					//�������� �������� -> dp[i+1][l][ddr]
					used_power = power[r][ddr];
					if (ddr != l && used_power < dp[i+1][l][ddr]) {
						dp[i+1][l][ddr] = used_power;
					}
					//ó���� �͵�.. ���� ��ġ�� �ȵ�.
					//ddr == r , l == ddr
					
				}
			}
		}
		
		
		//print
		int ans = INF;
		for (int l = 0; l <= 4; l++) {
			for (int r = 0; r <= 4; r++) {
				ans = Math.min(ans, dp[n][l][r]);
			}
		}
		System.out.println(ans);
	}

}
