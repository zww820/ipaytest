import java.awt.*;

/**
 * author:Audience
 * date:2017/10/7
 * time:17:21
 */
public class ReturnT {

    public static void main(String[] args){
        int a=2;
        if(a==1){
            System.out.println("++"+a);
            return;
        }
        System.out.println(a);
    }
}
