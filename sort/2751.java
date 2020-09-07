import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(in.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			for(int i = 0; i < N ;i++)
				list.add(Integer.parseInt(in.readLine()));
			Collections.sort(list);
			for(int j = 0 ; j < N ; j++)
				System.out.println(list.get(j));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

