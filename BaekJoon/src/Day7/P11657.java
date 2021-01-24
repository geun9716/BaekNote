package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P11657 {
	static int n, m, INF = 10000000;
	static long [] dist;
	static boolean has_m_cycle = false;
	static ArrayList<Info> [] adj;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		dist = new long[n+1];
		adj = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			dist[i] = INF;
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c= sc.nextInt();
		
			adj[a].add(new Info(b,c));
		}
		bell();
		
		//���ܸ� ���� ó����
		//�ð��� ������ �ǵ��ư��� -1
		// � ���ñ��� ���� ��ΰ� ������ -1
		// �� �������� �Ÿ� ���
		if (has_m_cycle) {
			System.out.println(-1);
		}
		else {
			//print
			for (int i = 2; i <= n; i++) {
				if (dist[i] == INF) 
					System.out.println(-1);
				else
					System.out.println(dist[i]);
			}
		}
	}
	static void bell() {
		//������ �ʱ�ȭ
		dist[1] = 0;
		for (int i = 0; i < n-1; i++) {	//�ִ� �湮�� �� �ִ� ������ ������ŭ ���� : n-1��
			for (int j = 1; j <= n; j++) { //j�� �ֺ��� �ִ� ������ ������Ʈ �� �� �ִ��� Ȯ��
				for (int k = 0; k < adj[j].size(); k++) {
					
					Info nxt = adj[j].get(k);
					if (dist[j] + nxt.c < dist[nxt.b]) {
						dist[nxt.b] = dist[j] + nxt.c;	//j�� nxt �̵��ϴ� �� �� ���� ������� �̵� �����ϸ� ������Ʈ
					}
				}
//				System.out.println(Arrays.toString(dist));
			}
//			System.out.println(Arrays.toString(dist));
		}
		//���� : n-1�� �����߱� ������, ���� �� ��δ��� ����� �������� ���̴�.
		//�׸��� �� ��ΰ� �ִ� ��� ���� ���̴�.
		//�� �߰��ؼ� �湮�� ������, ����� ���� Ŀ���״ϱ�...
		//������ �����ϴ� ������ �����ߴٸ�??
		for (int j = 1; j <= n; j++) { //j�� �ֺ��� �ִ� ������ ������Ʈ �� �� �ִ��� Ȯ��
			for (int k = 0; k < adj[j].size(); k++) {
				Info nxt = adj[j].get(k);
				if (Math.abs(dist[j] + nxt.c) < Math.abs(dist[nxt.b])) {
					//�̷� ���� ������ �� ������? ó�� �ʿ�?
					has_m_cycle = true;
				}
			}
		}
	}	
}	
//class Info{
//	int b;
//	long c;
//
//	public Info(int b, long c) {
//		this.b = b;
//		this.c = c;
//	}
//}