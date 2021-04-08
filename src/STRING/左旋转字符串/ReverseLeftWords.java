package STRING.左旋转字符串;

public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        String front = s.substring(0,n);
        String next = s.substring(n);
        return next+front;
    }
}
