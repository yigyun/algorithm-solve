import java.util.Scanner;
import java.lang.Math;
import java.io.*;
public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void hanoi(int n, int one, int two, int three) throws IOException{
		if(n == 1)
		{
			bw.write(one + " " + three + '\n');
			return;
		}
		hanoi(n - 1, one, three, two);
		bw.write(one + " " + three + '\n');
		hanoi(n - 1, two, one, three);
	}
	
	public static void main(String[] args) {    
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			int result = (int)Math.pow(2, n) - 1;
			System.out.println(result);
			hanoi(n, 1, 2, 3);
			bw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}