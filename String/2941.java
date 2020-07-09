import java.util.Scanner;
public class Main {
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		char [] data = sc.nextLine().toCharArray();
		int cnt = 0;
		for (int i = 0 ; i < data.length; i++)
		{
			if(data[i] == 'c' && i+1 < data.length)
			{
				if (data[i+1] == '=')
					cnt++;
				else if (data[i+1] == '-')
					cnt++;
			}
			else if (data[i] == 'z'&& i+1 < data.length)
			{
				if (data[i+1] == '=' && data[i-1] == 'd')
					cnt+=2;
				else if (data[i+1] == '=')
					cnt++;
			}
			else if (data[i] == 'l' && i+1 < data.length && data[i+1] == 'j')
			{
				cnt++;
			}
			else if (data[i] == 'n' && i+1 < data.length && data[i+1] == 'j')
			{
				cnt++;
			}
			else if (data[i] == 's' && i+1 < data.length && data[i+1] == '=')
			{
				cnt++;
			}
			
		}
		System.out.println(data.length-cnt);
	}
}

