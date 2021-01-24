package Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1516 {
	static StringTokenizer st;
	static int n;
	static int [] build_time, answer, indegree, before_max;
	static ArrayList<Integer> adj[];
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n+1];
		build_time = new int [n+1];
		answer = new int [n+1];
		indegree = new int [n+1];
		before_max = new int [n+1];
		
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i =1 ; i <=n; i++) {
			st = new StringTokenizer(br.readLine());
			build_time[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int a = Integer.parseInt(st.nextToken());
				if(a == -1) break;
				adj[a].add(i);
				indegree[i]++;
			}
		}
		
		//���������� ���ؼ� , ������ = ������ ������ ���� �͵�
		for(int i = 1; i<=n ;i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		//������ �ǹ��� �������� �ּ� �ð�.. -> answer
		while(!q.isEmpty()) {
			int cur = q.poll();
			//cur�� ó����. �̹� before_max�� � ���� �� ��� �ִٰ� ������ �� ����.
			answer[cur] = before_max[cur] + build_time[cur];
			// ���� �ǹ� ó�� ������ �ϳ� ���ְ� && �� �ǹ��� �������� ���� ���� ū �� (before_max) �� ����
			for (int i = 0; i < adj[cur].size(); i++) {
				int nxt = adj[cur].get(i);
				--indegree[nxt]; // ���� �ϳ� ����.
				if(before_max[nxt] < answer[cur]) {
					before_max[nxt] = answer[cur];
				}
				if(indegree[nxt] == 0)
					q.add(nxt);
			}
		}
		
		//print
		for(int i = 1 ; i <=n ;i++) {
			System.out.println(answer[i]);
		}
	}

}
