package Day8;

import java.util.Arrays;
import java.util.Scanner;

public class P2579 {
	static int N, status;
	static int [] stair, max_1, max_2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		stair = new int [N+1];
		max_1 = new int [N+1];
		max_2 = new int [N+1];
		
		for (int i = 1; i <= N; i++) {
			stair[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			if (i > 1)
			{
				//i-2�� �ִ� ��ܰ� ������ ����.
				max_1[i] = Math.max(max_1[i-2], max_2[i-2]) + stair[i];
				//max_2[] ;
				// i-1�� �ִ� ��ܰ� ������ ������, �� ������ ����
				max_2[i] = max_1[i-1] + stair[i];
			}
			else { //������
				max_1[i] = stair[i];
			}
		}
//		System.out.println(Arrays.toString(max_1));
//		System.out.println(Arrays.toString(max_2));
		
		//Print [n]
		System.out.println(Math.max(max_1[N], max_2[N]));
	}

}
