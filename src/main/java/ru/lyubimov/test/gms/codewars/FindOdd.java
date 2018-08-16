package ru.lyubimov.test.gms.codewars;

import java.util.HashMap;
import java.util.Map;

class FindOdd {
    static int findIt(int[] a) {
        HashMap<Integer, Integer> pairs = new HashMap<>();
        int result = 0;
        for (int element : a) {
            Integer mapElem = pairs.get(element);
            if (mapElem == null) {
                pairs.put(element, 1);
            } else {
                pairs.replace(element, ++mapElem);
            }
        }
        for(Map.Entry<Integer, Integer> entry : pairs.entrySet()) {
            int entryCount =  entry.getValue();
            if(entryCount % 2 != 0) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5});
    }
}
