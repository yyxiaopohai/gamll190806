public class TestThread {
    public static void main(String[] args) {

//        Thread1 thread1 = new Thread1("创建的线程！");
//        thread1.start();
        Thread2 thread2 = new Thread2();
        Thread t = new Thread(thread2,"实现");
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main线程!"+i);
        }
    }
}

class Thread1 extends Thread{
    public Thread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+"正在执行:"+i);
        }
    }
}

//实现接口创建线程
class Thread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            System.out.println(Thread.currentThread().getName()+"正在运行"+i);

        }
    }
}
