package niuke;

import java.util.HashMap;

public class Test
{
   /* public static int aMethod(int i)throws Exception
    {
        try{
            return 10/i;
        }
        catch (Exception ex)
        {
            throw new Exception("exception in a aMethod");
        }finally{
            System.out.printf("finally");
        }
    }
    public static void main(String[] args){
        try
        {
            aMethod(0);
        }
        catch (Exception ex)
        {
            System.out.printf("exception in main");
        }
        System.out.printf("finished");
    }*/
   public static void main(String[] args) {
       Runnable runnable = new Runnable() {
           @Override
           public void run() {
               System.out.println("foo");
           }
       };
       Thread thread = new Thread(runnable);
       thread.start();
       //thread.run();
       System.out.println("bar");

       HashMap<Integer,String> map = new HashMap<>();
   }
}