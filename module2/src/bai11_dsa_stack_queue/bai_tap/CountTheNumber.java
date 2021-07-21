package bai11_dsa_stack_queue.bai_tap;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class CountTheNumber {
    public static void main(String[] args) {
        String[] str = "abccbaddde".split("");
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        for(int i=0;i<str.length;i++){
            String s = str[i].toLowerCase();
            if(treeMap.containsKey(s)){
                int value = treeMap.get(s)+1;
                treeMap.replace(s,value);
            }
            else {
                treeMap.put(s,1);
            }
        }
        Iterator<Map.Entry<String,Integer>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
