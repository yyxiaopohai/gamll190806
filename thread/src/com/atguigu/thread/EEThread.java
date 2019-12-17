package com.atguigu.thread;



import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EEThread {
    public static void main(String[] args) {
        Ticker ticker = new Ticker();//资源类

        new Thread(()-> {for (int i = 1; i <=35; i++) ticker.sale();},"A").start();
        new Thread(()-> {for (int i = 1; i <=35; i++) ticker.sale();},"B").start();
        new Thread(()-> {for (int i = 1; i <=35; i++) ticker.sale();},"C").start();

        //线程
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=35; i++) {
                    ticker.sale();
                }

            }
        }, "A").start();
        //操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=35; i++) {
                    ticker.sale();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=35; i++) {
                    ticker.sale();
                }
            }
        }, "C").start();*/
    }
}

class Ticker {
    private  int ticker = 30;
    private  Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if (ticker>0){
                System.out.println(Thread.currentThread().getName()+"卖第："+(ticker--)+"剩下"+ticker);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    /*public synchronized void sale(){
        if (ticker>0){
            System.out.println(Thread.currentThread().getName()+"卖第："+(ticker--)+"剩下"+ticker);

        }
    }*/
}
