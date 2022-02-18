package ch07.openchallenge;

class Word {
    private String eng, kor;
    public Word(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }
    String getEng() { return eng; }
    String getKor() { return kor; }
}
