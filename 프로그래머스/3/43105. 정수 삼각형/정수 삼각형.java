class Solution {
    public int solution(int[][] triangle) {
        
        int length = triangle.length;
                
        // 추가 메모리 안써보기
        for(int x = 1; x < length; x++){
            int n = triangle[x-1].length;
            for(int y = 0; y < triangle[x].length; y++){
                int find = 0;
                if(y - 1 >= 0 && y - 1 < n){
                    find = triangle[x-1][y-1];
                }
                if(y >= 0 && y < n){
                    find = Math.max(find, triangle[x-1][y]);
                }
                triangle[x][y] += find;
            }
        }
        
        int max = -1;
        for(int i = 0; i < triangle[length - 1].length; i++){
            max = Math.max(triangle[length - 1][i], max);
        }
        
        return max;
    }
}