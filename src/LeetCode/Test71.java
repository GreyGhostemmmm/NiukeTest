package LeetCode;

import java.util.LinkedList;

/**
 * @author Administrator
 * @date 2020/7/10 19:18
 */

public class Test71 {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return "";
        }
        LinkedList<Character> list = new LinkedList<>();
        int len = path.length();
        StringBuilder str = new StringBuilder("");
        for(int i = 0; i < len; i++){
            if(path.charAt(i) == '/'){
                if( i+1 < len && path.charAt(i+1) != '/' && path.charAt(i+1) != '.'){
                    list.offer(path.charAt(i));
                }
            }
            else if(path.charAt(i) == '.'){
                if(i+1 < len && path.charAt(i+1) == '/'){
                    continue;
                }
                else if(i+1 < len && path.charAt(i+1) == '.'){
                    while(!list.isEmpty() && list.getLast() != '/'){
                        list.removeLast();
                    }
                    if(!list.isEmpty()){
                        list.removeLast();
                    }
                    i = i + 1;
                }
            }
            else{
                list.offer(path.charAt(i));
            }
        }
        while(!list.isEmpty()){
            str.append(list.removeFirst());
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "/a/./b/../../c/";
        Test71 test71 = new Test71();
        System.out.println(test71.simplifyPath(s));
    }
}
