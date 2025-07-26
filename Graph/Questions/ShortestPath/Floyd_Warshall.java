package ShortestPath;

public class Floyd_Warshall {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        int INF = (int)1e8;

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][k] != INF && dist[k][j] != INF){
                        if((long)dist[i][k] + (long)dist[k][j] < dist[i][j]){
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
    }
}
