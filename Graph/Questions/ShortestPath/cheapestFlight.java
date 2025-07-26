package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class cheapestFlight {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : flights){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[] {v,w});
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {0, src, 0}); // stops, cost, curCity

        int distance[] = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;


        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int stops = cur[0];          
            int city = cur[1];          
            int cost = cur[2]; 

            if(stops <= k){

                for(int[] nei : adj.get(city)){
                    int nextCity = nei[0];
                    int costCity = nei[1];

                    int nextcost = cost + costCity;

                    if(nextcost < distance[nextCity]){
                        distance[nextCity] = nextcost;
                        q.offer(new int[] {stops + 1, nextCity, nextcost});
                    }
                }
            }
        }
        if (distance[dst] == Integer.MAX_VALUE) return -1;
        return distance[dst];
    }



     // public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    //     List<List<int[]>> adj = new ArrayList<>();

    //     for(int i = 0; i < n; i++){
    //         adj.add(new ArrayList<>());
    //     }

    //     for(int[] edge : flights){
    //         int u = edge[0];
    //         int v = edge[1];
    //         int w = edge[2];

    //         adj.get(u).add(new int[] {v,w});
    //     }

    //     PriorityQueue<int[]> pq = new PriorityQueue<>(
    //         (a,b) -> a[0] - b[0]
    //     );

    //     pq.add(new int[] {0, src, 0}); // cost, curCity, stops

    //     int vis[] = new int[n];
    //     Arrays.fill(vis, Integer.MAX_VALUE);
    //     vis[src] = 0;


    //     while (!pq.isEmpty()) {
    //         int[] cur = pq.poll();
    //         int cost = cur[0];          
    //         int city = cur[1];          
    //         int stops = cur[2]; 
            
    //         if(city == dst) return stops;
    //         if(stops > k) continue; // exclude it and continue is q is not empty

    //         for(int[] nei : adj.get(city)){
    //             int nodenei = nei[0];
    //             int costnei = nei[1];
    //             int nextcost = cost + costnei;

    //             if(nextcost < vis[nodenei]){
    //                 vis[nodenei] = nextcost;
    //                 pq.offer(new int[] {nextcost, nodenei, stops + 1});
    //             }
    //         }
    //     }
    //     return -1;
    // }

   
}
