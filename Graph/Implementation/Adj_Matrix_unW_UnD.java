public class Adj_Matrix_unW_UnD {
    int[][] adjMatrix;
    int vart;

    public Adj_Matrix_unW_UnD(int v) {
        this.vart = v;
        adjMatrix = new int[v][v]; // initialize 2D matrix with 0s
    }

    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;

        // adjMatrix[src][dest] = weight; // Undirected Weighted Graph
        // adjMatrix[dest][src] = weight; 
    }

    public void printGraph() {
        for (int i = 0; i < vart; i++) {
            for (int j = 0; j < vart; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Adj_Matrix_unW_UnD g = new Adj_Matrix_unW_UnD(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        // g.addEdge(0, 1, 5); // UnD_Wt

        g.printGraph();
    }
}
