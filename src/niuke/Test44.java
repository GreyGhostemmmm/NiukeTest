package niuke;

/**
 * @author Administrator
 * @date 2020/3/17 18:17
 */

public class Test44 {
    static String ReverseSentence(String str) {
        String[] string = str.split(" ");
        int start = 0;
        int end = string.length;
        while(start < end){
            String temp = string[start];
            string[start] = string[end];
            string[end] = temp;
            start++;
            end--;
        }
        StringBuffer buffer = new StringBuffer("");
        for(int i = 0;i < string.length;i++){
            buffer = buffer.append(string[i]);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String str = "I am a student.";
        System.out.println(Test44.ReverseSentence(str));
    }
}
