package niuke; /**
 * @author Administrator
 * @date 2020/2/25 12:11
 */
import java.util.*;
public class Test34 {
    public int FirstNotRepeatingChar(String str) {
        if(str.length() == 0)
            return -1;
        List string = new ArrayList();
        List count = new ArrayList();
        int i = 0;
        while(i < str.length()){
            char c = str.charAt(i);
            if(string.indexOf(c) == -1){
                string.add(c);
                count.add(1);
            }
            else{
                int index = string.indexOf(c);
                int num = (int)count.get(index);
                num++;
                count.set(index,num);
            }
            i++;
        }
        if(count.indexOf(1) == -1){
            return -1;
        }
        int index = count.indexOf(1);
        char first = (char)string.get(index);
        int num = str.indexOf(first);
        return num;
    }

    public static void main(String[] args) {
        String str = "google";
        Test34 test34 = new Test34();
        int result = test34.FirstNotRepeatingChar(str);
        System.out.println(result);
    }
}
