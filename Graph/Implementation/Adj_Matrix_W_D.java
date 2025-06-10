public class Adj_Matrix_W_D {
    int[][] adjMatrix;
    int vart;

    public Adj_Matrix_W_D(int v) {
        this.vart = v;
        adjMatrix = new int[v][v];
    }

    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1; // directed

        // adjMatrix[src][dest] = weight; 
        //// for directed Weighted Graph
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
        Adj_Matrix_W_D g = new Adj_Matrix_W_D(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        // g.addEdge(0, 1, 5); // UnD_Wt
        System.out.println("The adj Matrix: ");

        g.printGraph();
    }
}
