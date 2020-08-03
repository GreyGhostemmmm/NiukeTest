package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/7/31 11:13
 */

public class ArrayListTest {

    int[] test(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        int[] i = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            i[j] = list.get(j);
        }
        return i;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        Integer[] nums = new Integer[list.size()];
        list.toArray(nums);
        for(Iterator i =  list.iterator(); i.hasNext();){
            //list.add(6);
            System.out.println(i.next());
        }
    }
}
