class MyHashMap {
    int size=1_000_000;
    int[] val;
    public MyHashMap() {
        val=new int[size+1];
        Arrays.fill(val,-1);
    }
    
    public void put(int key, int value) {
        val[key]=value;
    }
    
    public int get(int key) {
        return val[key];
    }
    
    public void remove(int key) {
        val[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */