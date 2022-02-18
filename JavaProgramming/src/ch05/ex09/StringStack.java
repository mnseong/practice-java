package ch05.ex09;

public class StringStack implements Stack {
    private String st[];
    private int cnt = 0;
    
    public StringStack(int n) {
        st = new String[n];
        for (int i = 0; i < st.length; i++)
            st[i] = "";
    }
    @Override
    public int length() {
        return cnt;
    }
    @Override
    public int capacity() {
        return (st.length - cnt);
    }
    @Override
    public String pop() {
        String ret = st[cnt - 1];
        st[cnt - 1] = "";
        cnt--;
        return ret;
    }
    @Override
    public void push(String val) {
        if (cnt < st.length) {
            st[cnt] = val;
            cnt++;
        } else System.out.println("스택이 꽉 차서 푸시 불가!");
    }
}
