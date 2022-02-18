package ch05.ex10;

public class Dictionary extends PairMap{
    private int cnt;
    private int capacity;
    
    public Dictionary(int num) {
        this.cnt = 0;
        this.capacity = num;
        keyArray = new String[num];
        valueArray = new String[num];
    }
    
    private int search(String key) {
        int idx = 0;
        for (String s : keyArray) {
            if (s != null && s.equals(key))
                return idx;
            idx++;
        }
        return 999;
    }
    
    @Override
    public String get(String key) {
        int idx = search(key);
        if (idx == 999) {
            return null;
        } else return valueArray[idx];
    }
    @Override
    public void put(String key, String value) {
        int idx = search(key);
        if (this.cnt < this.capacity) {
            if (idx == 999) {
                keyArray[cnt] = key;
                valueArray[cnt] = value;
                cnt++;
            } else valueArray[idx] = value;
        } else System.out.println("가득 찼습니다!");
    }
    @Override
    public String delete(String key) {
        int idx = search(key);
        if (idx != 999) {
            keyArray[idx] = null;
            valueArray[idx] = null;
            
            for (int i = idx; i < capacity - 1; i++) {
                keyArray[i] = keyArray[i + 1];
                valueArray[i] = valueArray[i + 1];
            }
            cnt--;
        }
        return null;
    }
    @Override
    public int length() {
        return this.cnt;
    }
}
