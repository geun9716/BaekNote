package Day6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1922 {
	static int N, M, result = 0;
	static int [] p;
	static Computer [] edge;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		edge = new Computer [M];
		p = new int [N+1];
		
		for (int i = 0; i < M; i++) {
		
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c= sc.nextInt();
			
			edge[i] = new Computer(a, b, c);
			
		}
		//������ ũ�� ������ ����
		Arrays.sort(edge, new Comparator<Computer>(){
			@Override
			public int compare(Computer o1, Computer o2) {
				return Integer.compare(o1.c, o2.c);
			}
		});
		//ũ�罺Į �˰��� ��� = ������ ����� ���� �� ���� Ʈ�� ����
		//union- find �̿��ؼ� Ʈ�� ����
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}
//		System.out.println(Arrays.toString(p));
		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(p));
			//���� ������ �о��
			//���� ����Ǿ� �ִ��� = ���� �׷����� Ȯ��
			if (find(edge[i].a) != find(edge[i].b)) {
				//���� �ٸ� �׷��̸� ����, ��뵵 �߰�
				
				union(edge[i].a, edge[i].b);

				//����� ���
				result += edge[i].c;
				
				//cnt++;
			}
		}
		//cnt != N-1 -> MST ������ �ȵ�.
		System.out.println(result);
		sc.close();
	}
	static int find(int a) {
		if (a == p[a]) 
			return a;
		p[a] = find(p[a]);
		return p[a];
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		p[a] = b;
	}
	
}
class Computer{
	int a, b, c;

	public Computer(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}