class LRUCache {
    private int count = 0;
    private int LruSize = 0;
    class Node{
        int v;
        int k;
        Node next;
        Node prev;
        public Node(int val,int key){
            this.v = val;
            this.k = key;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head;
    private Node tail;
    private Map<Integer,Node> map;
    public LRUCache(int capacity) {
            head = new Node(0,-1);
            tail = new Node(0,-1);
            head.next = tail;
            tail.prev = head;
            map=new HashMap<>();
            LruSize = capacity;
    }
    
    public int get(int key) {
        if(map.get(key) == null) return -1;
        Node latest = map.get(key);
        map.remove(latest.k);
        removeNode(latest);
        Node gg = addNode(latest.v,latest.k);
        map.put(latest.k,gg);
        return latest.v;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node repeated = map.get(key);
            removeNode(repeated);
            map.remove(key);
            count--;
        }
        if(count == LruSize){
            Node leastUsed = head.next;
         //   System.out.println(leastUsed.k);
            map.remove(leastUsed.k);
            removeNode(leastUsed);
            count--;
        }
        Node added = addNode(value,key);
        map.put(key,added);
        count++;
    }

    public Node addNode(int v,int key){
        Node aa = new Node(v,key);
        Node g = tail.prev;
        g.next = aa;
        aa.prev=g;
        aa.next=tail;
        tail.prev=aa;
        return aa;
    }
    public void removeNode(Node a){
        Node p = a.prev;
        Node n = a.next;
        p.next=n;
        n.prev=p;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */