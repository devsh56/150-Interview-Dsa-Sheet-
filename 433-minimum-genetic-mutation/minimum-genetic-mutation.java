class Solution {
    class pair{
        String a ;
        int b ;
        public pair(String a, int b){
            this.a=a;
            this.b=b;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<pair> ll = new ArrayDeque<>();
        Set<String> bankSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(int i = 0 ;i<bank.length;i++){
            bankSet.add(bank[i]);
        }
        char [] sg = startGene.toCharArray();
        char [] eg = endGene.toCharArray();
        char [] g = {'A','C','G','T'}; 
        ll.add(new pair(startGene,0));
        while(!ll.isEmpty()){
          pair p = ll.poll();

if(p.a.equals(endGene))
    return p.b;

char[] curr = p.a.toCharArray();

for(int i = 0; i < curr.length; i++) {
    char original = curr[i];

    for(char c : g) {
        if(c == original) continue;

        curr[i] = c;
        String next = new String(curr);

        if(bankSet.contains(next) && !visited.contains(next)) {
            visited.add(next);
            ll.offer(new pair(next, p.b + 1));
        }
    }

    curr[i] = original;
        }
        }
        return -1;
    }
}