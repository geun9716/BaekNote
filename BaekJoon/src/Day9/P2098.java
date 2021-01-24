package Day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P2098 {
	static int N;
	static int [][] W; //i-j���� �̵��Ÿ�
	static int [][] dp; //[i][j] ���ø� ió�� ���Ŀ԰�, ���翡 j������ �̵��� �Ÿ�
	static final int INF = 20000000;
	//dp[������ ���õ�][�������� ������ ����]
	//w ���
	//���������� �ٽ� �;� ��
	//0������ 1������ 2������
	//0 0 0 0 0 0 0 1 1 0 0 0 0 0 : 6, 7 �����ø� ������.
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		W = new int[N+1][N+1];
		dp = new int [(1<<N)][N];
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < (1<<N); i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = INF;
			}
		}
		//������ ���� : 0��° ���ÿ��� ������... [0��° ���ø� ���Ŀ԰�][���� 0��°�� �����ϱ�]
		dp[1][0] = 0;
		for (int i = 0; i < (1<<N); i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (check_bit(i, k) == true)	//k�� �� �� �ִ���
						continue;
					if (W[j][k] == 0)
						continue;
					int nxt = set_bit(i, k);
					dp[nxt][k] = Math.min(dp[nxt][k], dp[i][j] + W[j][k]);
				}
			}
		}
		
		
		//�������� ���� ó���� �ϸ鼭 ���� ����
		int answer = INF;
		int last_state = (1<<N) - 1;
		//��� ���ø� ��ȸ�߰�, ����� ���ϸ鼭 ������ ã�´�.
		for (int i = 0; i < N; i++) {
			if (W[i][0] == 0) continue;	//���� ����.
			answer = Math.min(dp[last_state][i] + W[i][0],answer);
		}
		
		System.out.println(answer);
	}
	//pos ��°�� ��Ʈ�� ������ : ���� ���� �ڸ����� 0
	static int set_bit(int origin, int pos) {
		return origin | (1<<pos);
	}
	static int unset_bit(int origin, int pos) {
		return origin & ~(1<<pos);
	}
	static boolean check_bit(int origin, int pos) {
		if ((origin & (1<<pos)) == 0)
			return false;
		return true;
	}

}
