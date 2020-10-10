import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	static ArrayList<Integer> [] list ; 
	static int N;
	static boolean[] check;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		list = new ArrayList[N+1];
		for(int i = 0 ; i < N+1 ; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i = 0 ; i < M ; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			list[u].add(v);
			list[v].add(u);
		}
		for(int i = 1 ; i< N + 1 ; i++) {
			Collections.sort(list[i]);
		}
		check = new boolean[N+1];
		dfs(V);
		System.out.println();
		
		check = new boolean[N+1];
		bfs(V);
		System.out.println();
		
		sc.close();
		return ;
	}
	private static void dfs(int x) {
		if(check[x]) { 
			return ;
		}
		check[x] = true;
		System.out.print(x+" ");
		for(int y : list[x]) {
			if(!check[y])
				dfs(y);
		}
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x+" ");
			for(int y : list[x]) {
				if(!check[y]) {
					check[y] = true;
					queue.add(y);
				}
			}
		}
		
	}
}
