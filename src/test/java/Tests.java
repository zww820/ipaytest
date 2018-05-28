import org.ipay.utils.httpcall.HttpRequestUtil;

/**
 * author:Audience
 * date:2017/9/20
 * time:9:45
 */
public class Tests {
    public static void main(String[] args){
//      HttpRequestUtil.sendGet("http://200.100.49.168:8181/ipay-task/bill/downloadBill",
//                "checkDate=20170910&channelId=2","UTF-8");
//        HttpRequestUtil.sendPost("http://200.100.49.158/view/ipay-oms/staff/login",
//                "loginName=test08&password=670b14728ad9902aecba32e22fa4f6bd","UTF-8");
        for(int i=0;i<10;i++){
            if(i==0){
                if(1==1){
                    System.out.println("fddf");
                    continue;
                }
                System.out.println(i);
            }else {
                System.out.println(i);
                break;
            }
        }
    }
}
