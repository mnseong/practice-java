package ch06.openchallenge;

public class Histogram {
    private String text;
    private StringBuffer[] alphabet = new StringBuffer[26];
    public Histogram(String text) {
        for (int i = 0; i < 26; i++)
            alphabet[i] = new StringBuffer("");
        
        this.text = text;
        for (int i = 0; i < text.length(); i++) {
            int n = (int)text.charAt(i);
            if (n >= 65 && n <= 90)
                alphabet[n - 65].append("-");
            else if (n >= 97 && n <= 122)
                alphabet[n - 97].append("-");
            else
                continue;
        }
    }
    public void show() {
        System.out.println();
        System.out.println("히스토그램을 그립니다.");
        for (int i = 0; i < alphabet.length; i++) {
            char c = (char)(i + 65);
            System.out.print(c);
            System.out.println(alphabet[i]);
        }
    }
}
