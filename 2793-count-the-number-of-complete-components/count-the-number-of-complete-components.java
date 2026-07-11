class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i =0 ;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i =0 ;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }


        HashSet<Integer>seen = new HashSet();
        int count = 0;
      //  int v[]=new int[2];
        for(int i =0 ;i<n;i++){
            int v[]=new int[2];
            if(!seen.contains(i)){
                dfs(i,graph,seen,v);
                int countedges = v[1]/2;
                int nodes = v[0];
                if(countedges == (nodes *(nodes-1)/2))count++;
            }
        }
        return count;
    }
    public static void dfs(int c, List<List<Integer>> g, HashSet<Integer>seen,int v[]){
        seen.add(c);
        v[0]++;
        v[1]+= g.get(c).size();
        for(int src : g.get(c)){
            if(!seen.contains(src)){
                dfs(src,g,seen,v);
            }
        }
    }
}