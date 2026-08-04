class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer>result = new ArrayList<>();
        List<List<Integer>> Graph = new ArrayList<>();
        for(int i =0 ;i<graph.length;i++){
            Graph.add(new ArrayList<>());
        }
        int indegree[] = new int[graph.length];
        for(int i = 0 ;i<graph.length;i++){
            for(int gr : graph[i]){
                Graph.get(gr).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> ll = new ArrayDeque<>();
        for(int i=0 ;i<graph.length;i++){
            if(indegree[i]==0){
                ll.add(i);
            }
        }

        while(!ll.isEmpty()){
            int a = ll.poll();
            result.add(a);
            for(int gr : Graph.get(a)){
                indegree[gr]--;
                if(indegree[gr] == 0){
                    ll.add(gr);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}