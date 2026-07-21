class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> Graph = new ArrayList<>();

        for(int i =0 ;i<numCourses;i++){
            Graph.add(new ArrayList<>());
        }

        int indegree[] = new int [numCourses];

        for(int i =0 ;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            Graph.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> ll = new LinkedList<>();
        
        for(int i =0 ;i<indegree.length;i++){
            if(indegree[i] == 0) ll.add(i);
        }
        int count = 0;
        while(!ll.isEmpty()){
            count++;
            int a = ll.poll();
            for(int arr : Graph.get(a)){
                indegree[arr]--;
                if(indegree[arr] == 0)ll.add(arr);
            }
        }
        return count == numCourses ? true : false;
    }
}