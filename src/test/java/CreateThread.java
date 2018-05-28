/**
 * author:Audience
 * date:2017/9/27
 * time:11:29
 */
public class CreateThread extends Thread{

    public CreateThread(){}

    @Override
    public void run(){
        try {
            //每个线程睡眠5s
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        long begin=System.currentTimeMillis();

        for (int i=0;i<10;i++){
            Thread thread=new Thread();
            thread.start();
            System.out.println("activeCount:"+Thread.activeCount());
        }
        System.out.println("activeCountMain1:"+Thread.activeCount());
        //每一个进程都有一个主进程，java里面通常都指的是main方法
        //Thread.activeCount()==1时只有main线程在运行，其他的都结束或者挂起或者撤销了
        //把while这段代码注释掉之后再运行一次
        while (true){
            if(Thread.activeCount()==1) break;
        }
        System.out.println("activeCountMain2:"+Thread.activeCount());
        long end=System.currentTimeMillis();
        System.out.println("Total Time:"+(end-begin)+"ms");
    }
}
