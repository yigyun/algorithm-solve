import java.io.*;
import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
	public static boolean[] visit;
	public static int[] numarray;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		numarray = new int[M];
		visit = new boolean[N];
		backTracking(N, M, 0);
		System.out.println(sb);
	}
	public static void backTracking(int N, int M, int depth) {
		if(M == depth)
		{
			for(int i = 0; i < M; i++)
			{
				sb.append(numarray[i]).append(' '); 
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < N; i++)
		{
			if(visit[i] == false)
			{
				visit[i] = true;
				numarray[depth] = i+1;
				backTracking(N, M, depth+1);
				visit[i] = false; 
			}
		}
	}
}