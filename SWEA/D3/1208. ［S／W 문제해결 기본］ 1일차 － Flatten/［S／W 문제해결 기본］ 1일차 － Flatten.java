import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int dump = sc.nextInt();
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
			
            for(int i = 0; i < 100; i++){
            	int num = sc.nextInt();
                minHeap.add(num);
                maxHeap.add(num);
            }
            
            for(int i = 0; i < dump; i++){
            	int min = minHeap.poll() + 1;
                int max = maxHeap.poll() - 1;
                
                minHeap.add(min); maxHeap.add(min);
                minHeap.add(max); maxHeap.add(max);
            }
            
            int num = maxHeap.poll() - minHeap.poll();
            System.out.println("#" + test_case + " " + num);
        }
	}
}