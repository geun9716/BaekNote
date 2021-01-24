package Day1;
import java.util.*;

public class Escape {
	
	static int[] mx = {-1, 1 ,0 ,0};
	static int[] my = {0, 0, -1, 1};
	
	static int R, C;
	static char [][] map;
	static int [][] dp;
	static boolean foundAnswer;
	static Queue<Point> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		Point st = null;
		map = new char[R][C];
		dp = new int[R][C];
		
		for(int r=0; r < R; r++) {
			String line = sc.next();
			for (int c = 0 ; c < C; c++) {
				map[r][c] = line.charAt(c);
				if (map[r][c] == '*') {
					queue.add(new Point(r, c, '*'));
				} else if (map[r][c] == 'S') {
					st = new Point(r, c, 'S');
				}
			}
		}
		
		queue.add(st);
		
		while(!queue.isEmpty()) {
			//1. ť���� ������
			Point p = queue.poll();
			//2. �������ΰ�? if(p == D)
			if (p.type == 'D') {
				System.out.println(dp[p.x][p.y]);
				foundAnswer = true;
				return;
			}
			//3. ���� �ִ� ���� ��ȸ for(��, ��, �� , �Ʒ�)
			for(int i = 0 ; i < 4; i++) {
				int tx = p.x+mx[i];
				int ty = p.y+my[i];
				//4. ���� �ִ°�? if (���� ����� �ʰ�, X�� �ƴϰ�, *�ƴϰ�)
				if ((0 <= tx && tx < R) && (0 <= ty && ty < C)) {
					if (p.type == 'S' || p.type == '.') {	//����ġ
						if (dp[tx][ty] == 0 && (map[tx][ty] == 'D' || map[tx][ty] == '.')) {
							//5. üũ�� dp[r][c] = time
							dp[tx][ty] = dp[p.x][p.y] + 1 ;
							//6. ť�� ���� queue.add(next)
							queue.add(new Point(tx, ty, map[tx][ty]));
						}
					} else {
						if (map[tx][ty] == '.') {
							map[tx][ty] = '*';
							queue.add(new Point(tx, ty, '*'));
						}
					}
				}
			}
		}
		
		if (foundAnswer == false) {
			System.out.println("KAKTUS");
		}
		sc.close();
	}
}
class Point{
	int x;
	int y;
	char type;
	public Point(int x, int y, char type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+x+","+y+"]";
	}
}
