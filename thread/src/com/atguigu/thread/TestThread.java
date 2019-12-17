package com.atguigu.thread;

import jdk.nashorn.internal.objects.annotations.Where;

import javax.xml.bind.SchemaOutputResolver;

public class TestThread {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        Thread1 t3 = new Thread1();

        t1.start();
        t2.start();
        t3.start();

    }
}

class Thread1 extends Thread{
    private static int ticket = 30;
    @Override
    public void run() {
        while (true){
            if (ticket<=0){
                System.out.println("卖没了");
            }
            else{
                String name = Thread.currentThread().getName();
                System.out.println(name+"正在卖"+ticket--);
            }
        }
    }
}

