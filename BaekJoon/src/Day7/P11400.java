package Day7;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class P11400 {
	static int V, E, cnt = 0, num = 1;
	static int [] visit_order;
	static boolean [] visited;
	static boolean [] ans ;
	static Stack<Point> answer = new Stack<>();
	static ArrayList<Integer> [] adj;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new ArrayList[V+1];
		ans = new boolean[V+1];
		visit_order = new int [V+1];
		visited = new boolean[V+1];
		
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			adj[a].add(b);
			adj[b].add(a);
			
		}
		//�������� ã��
		for (int i = 1; i <= V; i++) {
			if(visit_order[i] == 0) {
				dfs(0, i, true);
			}
		}
		
		System.out.println(answer.size());
		//���
		while(!answer.isEmpty()) {
			Point p = answer.pop();
			System.out.println(p.x +" "+p.y);
		}
		for (int i = 1; i <= V; i++) {
			if(ans[i])
				System.out.print(i+" ");
		}
	}
	//���� : ��Ʈ�� ���
	//���� �湮������ �ڽĵ��� ������ �湮������ ���� ���� ���� ��
	static int dfs(int parent, int cur, boolean isRoot) {
//		if (visit_order[cur] != 0) {
//			return visit_order[cur];
//		}
		int clcnt = 0;
		visit_order[cur] = num;			//���� ��ȣ
		int min_visit_order = num; //�� �ڽĵ��� ���� �� �ִ� �� �߿��� ���� ���� ��
		num++;
		
		for (int i = 0; i < adj[cur].size(); i++) {
			int nxt = adj[cur].get(i);
			if(nxt == parent) 
				continue;
			if(visit_order[nxt] > 0) {	//������ �湮 �ߴ� ���
				min_visit_order = Math.min(min_visit_order, visit_order[nxt]);
			}
			else {	// ���Ӱ� �湮�ϴ� ���
				int tmp = dfs(cur, nxt, false);
				min_visit_order = Math.min(tmp, min_visit_order);
				if (!isRoot && tmp >= visit_order[cur]) {
					//������
					ans[cur] = true;
					answer.push(new Point(cur, nxt));
				}
				clcnt++;
			}
		}
		//���࿡ ��������, ������ ó���� ������ ����.
		if (adj[cur].size() == 1) {
			return visit_order[cur];
		}
		
		if(isRoot) {
			//�ڽ��� ������ üũ
			//�� �̻��̸� ������
			if(clcnt >= 2) {
				ans[cur] = true;
			}
		}
		
		return Math.min(min_visit_order, visit_order[cur]);	//���� ���� ���߿��� �湮������ ���� ���� ���� ��ȯ��.
	}
}
