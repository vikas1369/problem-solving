package com.vikas.core.leetcode.heap;

import java.util.*;

public class KClosestPointToOrigin {
    public static void main(String[] args){

    }
    Map<Point, Double> map = new HashMap<>();
    public int[][] kClosest(int[][] points, int k) {
        List<int []> list = new ArrayList<>();
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> map.get(a)));
        for(int[] arr: points){
            Point p = new Point(arr[0], arr[1]);
            map.put(p, Math.sqrt(Math.pow(arr[0],2)+ Math.pow(arr[1], 2)));
            pq.offer(p);
        }

        for(int i =0;i<k;i++){
            Point p = pq.poll();
            int[] point = new int[2];
            point[0] = p.x;
            point[1] = p.y;
            list.add(point);
        }

        return list.toArray(new int[0][]);

    }

    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
