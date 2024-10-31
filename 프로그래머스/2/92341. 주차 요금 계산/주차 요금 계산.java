import java.util.*;

class Solution {
    
    static class Car{
        int value;
        String number;
        Car(int value, String number){
            this.value = value;
            this.number = number;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {        
        Map<String, Integer> feeM = new HashMap<>();
        Map<String, Integer> parking = new HashMap<>();
        
        for(String str : records){
            String[] strs = str.split(" ");
            if(strs[2].equals("IN")){
                input(parking, strs[0], strs[1]);
            }else{
                out(parking, feeM, strs[0], strs[1]);
            }
        }
        
        for(String key : parking.keySet()){
            out(parking, feeM, "23:59", key);
        }
        
        List<Car> list = new ArrayList<>();
        for(String key : feeM.keySet()){
            int fee = 0;
            if(feeM.get(key) <= fees[0]){ 
                fee = fees[1];
            }
            else{
                int t = (int)Math.ceil((feeM.get(key) - fees[0]) / (double)fees[2]);
                fee = fees[1] + t * fees[3];
            }
            list.add(new Car(fee, key));
        }
        
        Collections.sort(list, (o1, o2) -> {
            return o1.number.compareTo(o2.number);
        });
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i).value;
        }
        
        return answer;
    }
    
    static void out(Map<String, Integer> parking, Map<String, Integer> feeM, String time, String number){
        String[] times = time.split(":");
        int minute = ((Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1])) - parking.get(number);
        feeM.put(number, feeM.getOrDefault(number, 0) + minute);
        parking.put(number, 1439);
    }
    
    static void input(Map<String, Integer> parking, String time, String number){
        String[] times = time.split(":");
        int minute = (Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1]);
        parking.put(number, minute);
    }
}