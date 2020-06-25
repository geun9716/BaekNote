import java.util.Scanner;

public class Main {
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		boolean word = false;
		char [] data = sc.nextLine().toCharArray();
		
		for(int i = 0 ; i < data.length ; i++)
		{
			if (data[i] >= 'A')
				word = true;
			
			if (word == true && data[i]==' ')
			{
				cnt++;
				word = false;
			}
		}
		
		if (data[data.length-1] != ' ')
			cnt++;
		System.out.println(cnt);
	}
}

