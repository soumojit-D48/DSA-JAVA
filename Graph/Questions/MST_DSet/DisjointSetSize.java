package MST_DSet;
import java.util.*;

public class DisjointSetSize {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSetSize(int n){
        for(int i = 0; i <= n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findPar(int node){
        if(node == parent.get(node)) return node;

        int up = findPar(node);
        parent.set(node, up);
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);

        if (ulp_u == ulp_v) {
            return;
        }

        if(size.get(ulp_u) > size.get(ulp_v)){
            parent.set(ulp_v, ulp_u);   // attach u → v
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_u, ulp_v); // attach v → u
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
