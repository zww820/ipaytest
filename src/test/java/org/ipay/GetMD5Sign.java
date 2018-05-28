package org.ipay;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * author:Audience
 * date:2017/9/22
 * time:20:32
 */
public class GetMD5Sign {
    public static String getMD5Sign(Object o,String privateKey) throws IllegalArgumentException, IllegalAccessException{
        ArrayList<Object> list = new ArrayList<Object>();
        Class cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.get(o) != null && f.get(o) != "") {
                if(!"serialVersionUID".equals(f.getName())){
                    list.add(f.getName() + "=" + f.get(o) + "&");
                }
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        sb.append("privateKey=").append(privateKey);
        String result = sb.toString();
        result = org.ipay.MD5Util.MD5Encode(result, null);
        System.out.println(result);
        return result;
    }

    public static void main(String args[]) throws IllegalAccessException {

        PosRequestProtocol posRequestProtocol=new PosRequestProtocol();
        posRequestProtocol.setAmount(0.01);
//        posRequestProtocol.setAuthCode("1");
        posRequestProtocol.setMerchantNo(args[0]);
        posRequestProtocol.setShopNo(args[1]);
        posRequestProtocol.setEmpNo(args[2]);
//        posRequestProtocol.setPosIp("127.0.0.1");
        posRequestProtocol.setTerminalNo(args[3]);
        getMD5Sign(posRequestProtocol,"POS9BEIgU2wYRT52k5kuR2Ot7qMrK1mA");
    }
}
