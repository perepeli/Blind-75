package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind();
        int[] result = null;

        for(int[] edge : edges) {
            if(uf.unify(edge[0], edge[1]) == false) result = edge;
        }

        return result;
    }

    class UnionFind {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        public boolean unify(int p, int q) {
            Map.Entry<Integer, Set<Integer>> P = find(p);
            Map.Entry<Integer, Set<Integer>> Q = find(q);

            if (P == null && Q == null) {
                Set<Integer> newValue = new HashSet<>();
                newValue.add(q);
                map.put(p, newValue);
                return true;
            } else if (P == Q) {
                return false;
            } else if (P == null && Q != null) {
                Q.getValue().add(p);
                return true;
            } else if (Q == null && P != null) {
                P.getValue().add(q);
                return true;
            } else {
                if(P.getValue().size() > Q.getValue().size()) {
                    Q.getValue().add(Q.getKey());
                    P.getValue().addAll(Q.getValue());
                    map.remove(Q.getKey());
                } else {
                    P.getValue().add(P.getKey());
                    Q.getValue().addAll(P.getValue());
                    map.remove(P.getKey());
                }
                return true;
            }
        }


        public Map.Entry<Integer, Set<Integer>> find(int i) {
            for(Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
                if(e.getKey().equals(i) || e.getValue().contains(i)) return e;
            }
            return null;
        }
    }
}
