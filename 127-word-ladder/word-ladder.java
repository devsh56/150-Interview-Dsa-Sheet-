class Solution {
    class Pair{
        String a;
        int b ;
        public Pair(String a, int b){
            this.a = a;
            this.b= b;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet();
        HashSet<String> WordList = new HashSet(wordList);
        Queue<Pair> Pq= new ArrayDeque<>();
        Pq.add(new Pair(beginWord,0));
        visited.add(beginWord);
        while(!Pq.isEmpty()){
            Pair p = Pq.poll();
            if(p.a.equals(endWord)) return p.b+1;
            char ch [] = p.a.toCharArray();
            for(int i =0 ;i<ch.length;i++){
                char v = ch[i];
                for(char j = 'a' ; j <= 'z' ; j++){
                    ch[i] = j;
                    String str = new String(ch);
                    if(WordList.contains(str) && !visited.contains(str)){
                        Pq.add(new Pair(str,p.b+1));
                        visited.add(str);
                    }
                }
                ch[i] = v;
            }
        }
        return 0;
    }
}