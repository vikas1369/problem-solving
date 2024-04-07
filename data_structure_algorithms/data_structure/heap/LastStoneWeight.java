package data_structure.heap;/*
https://leetcode.com/problems/last-stone-weight/
*/
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1){
            return stones[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        pq.addAll(Arrays.stream(stones).boxed().collect(Collectors.toList()));

        while(pq.size()>1){
            int mostHeavy = pq.poll();
            int secondMostHeavy = pq.poll();
            if(mostHeavy == secondMostHeavy){
                //do nothing
            }else if(mostHeavy > secondMostHeavy){
                pq.offer(mostHeavy-secondMostHeavy);
            }
        }
        return pq.size()==1 ? pq.poll(): 0;

    }
}