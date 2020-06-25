import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	
	public static void main(String [] args) {
		int Max = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char result = '?';
		int [] cnt = new int[26];
		try {
			char [] data = br.readLine().toUpperCase().toCharArray();
			
			for(int i = 0 ; i < data.length; i++)
			{
				cnt[data[i]-'A']++;
			}
			
			for(int i = 0 ; i < 26 ; i++)
			{
				if(cnt[i] > Max)
				{
					Max = cnt[i];
					result = (char)('A'+i);
				}
				else if (cnt[i] == Max)
					result = '?';
			}
			System.out.println(result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
