package leetcode.Array_String.hard;

class Candy_135 {
    public int candy(int[] ratings) {
        int count = ratings.length;
        int[] candys = new int[ratings.length];
        if(ratings.length == 1) return 1;
        for(int i = 0; i < candys.length; i++) candys[i] = 1;
        for(int j = 0; j < candys.length; j++){
            int temp = candys[j];
            if(j == 0){
                if(ratings[j] > ratings[j+1] && candys[j] <= candys[j+1]){
                    candys[j] = candys[j+1] + 1;
                    count += candys[j] - temp;
                }
            }else if(j == ratings.length-1){
                if(ratings[j] > ratings[j-1] && candys[j] <= candys[j-1]){
                    candys[j] = candys[j-1] + 1;
                    count += candys[j] - temp;
                }
            } else{
                if(ratings[j] > ratings[j-1] && candys[j] <= candys[j-1]){
                    candys[j] = candys[j-1] + 1;
                    count += candys[j] - temp;
                }else if(ratings[j] > ratings[j+1] && candys[j] <= candys[j+1]){
                    candys[j] = candys[j+1] + 1;
                    count += candys[j] - temp;
                    int t = j;
                    int rating = ratings[j];
                    while( t > 0 && ratings[t-1] > ratings[t]){
                        if(candys[t] >= candys[t-1]){
                            int temp2 = candys[t-1];
                            candys[t-1] = candys[t] + 1;
                            count += candys[t-1] - temp2;
                            t--;
                        }else break;
                    }
                }
            }
        }
        return count;
    }
}
