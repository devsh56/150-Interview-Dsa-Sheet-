public class Node {
    Node next;
    Node prev;
    int Key;
    int Value;
    public Node(int key,int value){
        this.Key=key;
        this.Value = value;
    }
}

class LRUCache {
    public HashMap<Integer,Node> map;
    public Node head;
    public Node tail;
    public int size =0;
    public int Count =0;
    public LRUCache(int capacity) {
       size = capacity;
       head = new Node(-1,-1);
       tail = new Node(-1,-1);
       map = new HashMap<Integer,Node>(); 
       head.next = tail;
       tail.prev = head;
    }
    
    public int get(int key) {
         if(!map.containsKey(key))
        return -1;
    Node node = map.get(key);
    removeNode(node);
    addNode(node);
    return node.Value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
        Node node = map.get(key);
        removeNode(node);
        map.remove(key);
        Count--;
    }
        if(size == Count){
            Node a = removeNode(tail.prev);
           map.remove(a.Key);
           Count--;
        }
        Node aa = new Node(key,value);
        map.put(key,aa);
        addNode(aa);
        Count++;
        
    }
    public void addNode(Node dd){
        Node temp = head.next;
        head.next = dd;
        temp.prev = dd;
        dd.next = temp;
        dd.prev = head;
    }
    public Node removeNode(Node dd){
        Node Next = dd.next;
        Node Prev = dd.prev;
        Prev.next = Next;
        Next.prev = Prev;
        return dd;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */