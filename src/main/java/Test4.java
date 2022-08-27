/**
 * Project name(项目名称)：java并发编程_共享问题
 * Package(包名): PACKAGE_NAME
 * Class(类名): Test4
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/27
 * Time(创建时间)： 22:18
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test4
{
    public static void main(String[] args) throws InterruptedException
    {
        Room2 room = new Room2();

        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 20000; i++)
                {
                    room.increment();
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 20000; i++)
                {
                    room.decrement();
                }
            }
        }, "t2");

        t1.join();
        t2.join();
        //打印
        System.out.println(room.get());
    }
}


class Room2
{
    private int value = 0;

    /**
     * 加1
     */
    public synchronized void increment()
    {
        value++;
    }

    /**
     * 减1
     */
    public synchronized void decrement()
    {
        value--;
    }

    /**
     * 取值
     *
     * @return value
     */
    public synchronized int get()
    {
        return value;
    }
}


