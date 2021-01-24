package Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1102 {
	static int N, P, INF = 10000;
	static int [][] W;
	static int [] dp;
	static boolean [] onoff;
	static char [] buf;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		W = new int [N][N];
		dp = new int [1<<N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		onoff = new boolean[N];
		buf = br.readLine().toCharArray();
		
		for (int i = 0; i < buf.length; i++) {
			if(buf[i] == 'Y')
				onoff[i] = true;
		}
		
		P = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < (1<<N); i++) {
			dp[i] = INF;
		}
		//���� ������ ��� �����ؾ� �ұ�?
		//���ʿ� �����ִ� �����Ҹ� �ƴϱ�, ���¸� ���� �� ������ dp[] = 0
		int first_state = 0;
		for (int i = 0; i < N; i++) {
			if(onoff[i]) {
				first_state = set_bit(first_state, i);
			}
		}
		
		dp[first_state] = 0;
		//����
//		dp[state]
		for (int state = 0; state <= (1<<N) ; state++) {
			for (int i = 0; i < N; i++) {
				int nxt_state, nxt_cost;
				//state�� ���¿��� i �����Ҹ� ų �� ������?
				if(check_bit(state, i)) { // state : �����Ұ� �����ִ°�, i�� �ִٴ� ���� �̹� �����ִ°�
					continue;
				}
				//�ѰԵǸ� ����� ��� �ɱ�?
				// �׶� state�� � ����ϱ�? : nxt_state
				nxt_state = set_bit(state, i);
				// nxt_state���� � ���� �־�����?
				for (int j = 0; j < N; j++) {	//	j���� �����Ҹ� �̿��ؼ� i�� Ű��
					if(check_bit(state, j)) {
						nxt_cost = dp[state] + W[j][i];
						if (nxt_cost < dp[nxt_state]) {
							dp[nxt_state] = nxt_cost;
						}
					}
				}
			}
		}
		int answer = INF;
		//Print : P�� ����Ͽ� P���� ū ���� ���
		for (int i = 0; i < (1<<N); i++) {
			if(bitCount(i) >= P) {
				if (dp[i] < answer) {
					answer = dp[i];
				}
			}
		}
		if(answer == INF)
			answer = -1;
		
		System.out.println(answer);
	}
	static int bitCount(int x) {
		int cnt = 0;
		while(x > 0) {
			if ((x & 1) == 1) 
				cnt++;
			x /= 2;
		}
		return cnt;
	}
	static int set_bit(int origin, int pos) {
		return origin | (1<<pos);
	}
	static boolean check_bit(int origin, int pos) {
		if ((origin & (1<<pos)) == 0)
			return false;
		return true;
	}
	
	
}
