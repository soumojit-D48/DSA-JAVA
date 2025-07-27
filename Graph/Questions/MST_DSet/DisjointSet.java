package MST_DSet;

import java.util.List;
import java.util.ArrayList;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0; i <= n; i++){
            rank.add(0);
            parent.add(i);
            // parent = [0, 1, 2, 3, 4, 5, 6, 7]
            // rank   = [0, 0, 0, 0, 0, 0, 0, 0]
        }
    }

    public int findUPar(int node){
        if(parent.get(node) == node){
            return node;
            // If the node is its own parent -> it's the ultimate parent (root).
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return; // belonging to same comp 

        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v); // Attach u's root under v's root
            // Make the parent of ulp_u point to -> ulp_v
        } else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        } else{
            // If both have same rank, attach one under the other (any direction)
            parent.set(ulp_u, ulp_v); // attaching v under u so u++ needed

            int rankU = rank.get(ulp_u);
            rank.set(rankU, rankU + 1);
        }
    }

}

class Main {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);

        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // Check if 3 and 7 are in the same set
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        // Connect 3 and 7
        ds.unionByRank(3, 7); // ****

        // Check again if 3 and 7 are in the same set
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}

