import java.util.*;

public class Bits{
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n=sc.nextInt();
        System.out.println("Enter pos");
        int pos=sc.nextInt();

        //Get Bit - (1<<pos)&n

        int bm=1<<pos;//bitMask
        // if((bm & n)==0){
        //     System.out.println("Bit at given pos is 0");
        // }else{
        //     System.out.println("Bit at given pos was 1");
        // }

        //Set Bit - (1<<pos)|n
        // n=bm|n;
        //System.out.println("Set bit" + (bm|n));

        //Clearbit - ~(1<<pos)&n
        //System.out.println("Clear bit"+(~(bm)&n));

        //Update bit to either 0 or 1
        //System.out.println("Update pos 1 to 1 " + (bm|n));
        //System.out.println("Update pos 1 to 0"+ (~(bm)&n));
        System.out.println("Enter the operation to do");
        int opSetTo=sc.nextInt();
        if(opSetTo==1){
            System.out.println(bm|n);
        }else{
            System.out.println(~(bm)&n);
        }
    }
}