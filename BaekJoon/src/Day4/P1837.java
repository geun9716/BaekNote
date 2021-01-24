package Day4;

import java.util.ArrayList;
import java.util.Scanner;

public class P1837 {
	static int K;
	static char [] PW;
	static boolean[] checked;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		PW = sc.next().toCharArray();
		K = sc.nextInt();
				
		checked = new boolean[K + 1];
		// 6 2���� K=2 �̸�, ���� ��ȣ �̾�� ��. ����, i < K
		for (int i = 2; i < K; i++) {
			if(checked[i] == false) { // => �Ҽ�
				list.add(i);
				for (int j = i + i; j <= K; j += i) {	// i*k ���·� ��Ÿ�� �� �ִ� ���� ��� üũ
					checked[j] = true;
				}
			}
		}
		for(int num : list) {
			int tmp=0;
			
			for (int i = 0; i < PW.length; i++) {
				tmp = tmp*10 + PW[i]-'0';
				tmp = tmp % num;
			}
//			System.out.println(num+", "+tmp);
			if (tmp == 0) {
				
				System.out.println("BAD "+num);
				return ;
			}
		}
		System.out.println("GOOD");
		sc.close();
		
		
		
//		for(int prime : list) {
//			if (prime >= K) {
//				break;
//			}
//			if (checkIsBad(prime)) {
//				System.out.println("BAD");
//				return ;
//			}
//		}
//		System.out.println("GOOD");
		
	}
	static boolean checkIsBad(int x) {
		int r = 0;
		for(int i=0; i < PW.length ; i++) {
			r = (r * 10 + (PW[i] - '0')) % x;
		}
		if (r == 0) {
			return true;
		}
		else
			return false;
	}
}
