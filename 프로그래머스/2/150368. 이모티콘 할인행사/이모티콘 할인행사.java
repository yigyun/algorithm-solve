import java.util.*;

class Solution {
    
    /**
        10%, 20%, 30%, 40%
        x0.9, x0.8, x0.7, 0.6
        1, 2, 3, 4번이라고 하고 
    **/
    static double[] prices = new double[]{ 0, 0.9, 0.8, 0.7, 0.6};
    static int peoples;
    static int price;
    static int[][] user;
    static int[] emoti;
    
    public int[] solution(int[][] users, int[] emoticons) {
        peoples = 0;
        price = 0;
        int[] emoticonPrices = new int[emoticons.length];
        user = users;
        emoti = emoticons;
        
        dfs(emoticonPrices, 0, emoticons.length);
        
        return new int[]{peoples, price};
    }
    
    static void dfs(int[] emoticonPrices, int depth, int limit){
        if(depth == limit){
            // 돌면서 확인하면 끝.
            int tempUser = 0;
            int tempPrice = 0;
            int totalPrice = 0;
            for(int i = 0; i < user.length; i++){
                for(int j = 0; j < emoticonPrices.length; j++){
                    if(user[i][0] <= (emoticonPrices[j] * 10)){
                        tempPrice += (emoti[j] - ((emoti[j] / 10) * emoticonPrices[j])); 
                    }
                }
                if(tempPrice >= user[i][1]) tempUser++;
                else totalPrice += tempPrice;
                tempPrice = 0;
            }

            if(tempUser > peoples){
                peoples = tempUser;
                price = totalPrice;
            }else if(tempUser == peoples){
                if(totalPrice > price){
                    price = totalPrice;
                }
            }
            
            return;
        }
        
        for(int i = 1; i <= 4; i++){
            emoticonPrices[depth] = i;
            dfs(emoticonPrices, depth+1, limit);
        }
    }
}