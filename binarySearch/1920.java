import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> result = new ArrayList<>();
		
		int N = sc.nextInt();

		for(int i = 0 ; i < N ; i++)
			list.add(sc.nextInt());
		Collections.sort(list);
		
		int M = sc.nextInt();
		
		for(int i = 0 ; i < M ; i++) {
			int num = sc.nextInt();
//			System.out.println("Num : "+num);
			result.add(binarySearch(num));
		}
		for(int i = 0 ; i < result.size(); i++)
			System.out.println(result.get(i));
		
		sc.close();
	}
	private static int binarySearch(int target) {
		int start = 0;
		int end = list.size()-1;
		int mid = (end+start)/2;
		while(end-start >= 0)
		{
			if(target == list.get(mid))
			{
//				System.out.println("Exited");
				return 1;
			}
			else if (target > list.get(mid)) {
				start = mid+1;
			}
			else if (target < list.get(mid)){
				end = mid-1;
			}
//			System.out.println(list.get(mid));
			mid = (end+start)/2;
		}
		return 0;
	}
}
