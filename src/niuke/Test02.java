package niuke;

/**
 * @author Administrator
 * @date 2020/2/12 17:09
 */

public class Test02 {
    static String replaceSpace(StringBuffer str) {
        if(str == null)
            return null;
        String s = "%200000";
        int i = 0;
        int temp = str.length();
        while(i<temp){
            if(str.charAt(i) == ' '){
                str.replace(i,i+1,s);
            }
            i++;
        }
        return str.toString();
    }

    static String replaceSpace2(StringBuffer str) {
        if(str==null)
            return null;
        StringBuffer newstr = new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                newstr.append('%');
                newstr.append('2');
                newstr.append('0');
            }else{
                newstr.append(str.charAt(i));
            }
        }
        return newstr.toString();
    }

    public static void main(String[] args){
        //StringBuffer stringBuffer = new StringBuffer("We Are Happy");
        StringBuffer stringBuffer = new StringBuffer("");
        System.out.println(stringBuffer);
       /* String string = niuke.Test02.replaceSpace(stringBuffer);
        System.out.println(string);*/
        String string = Test02.replaceSpace2(stringBuffer);
        System.out.println(string);

    }
}
