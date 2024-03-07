package leetcode.Array_String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class InsertDeleteGetRandomO_380 {

    Set<Integer> rset;

    public InsertDeleteGetRandomO_380() {
        this.rset = new HashSet<>();
    }

    public boolean insert(int val) {
        if(this.rset.contains(val)){
            return false;
        }else{
            this.rset.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(this.rset.contains(val)){
            this.rset.remove(val);
            return true;
        }else{
            return false;
        }
    }

    public int getRandom() {
        List<Integer> list = new ArrayList<>(this.rset);
        return list.get((int) ((Math.random() * 100) % list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
