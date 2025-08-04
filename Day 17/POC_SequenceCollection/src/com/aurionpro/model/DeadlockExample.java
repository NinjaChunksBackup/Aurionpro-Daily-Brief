package com.aurionpro.model;

public class DeadlockExample 
{

    static final Object resourceA = new Object();
    static final Object resourceB = new Object();

    public static void main(String[] args) 
    {
        // Thread 1
        Thread t1 = new Thread(() -> 
        {
            synchronized (resourceA) 
            {
                System.out.println("Thread 1: locked A");

                try { Thread.sleep(100); } catch (Exception ignored) {}

                synchronized (resourceB) 
                {
                    System.out.println("Thread 1: locked B");
                }
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> 
        {
            synchronized (resourceB) 
            {
                System.out.println("Thread 2: locked B");

                try { Thread.sleep(100); } catch (Exception ignored) {}

                synchronized (resourceA) 
                {
                    System.out.println("Thread 2: locked A");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

//public synchronized void printData() 
//{
//    System.out.println("Thread-safe code");
//}
//
//
//


//ReentrantLock lock = new ReentrantLock();
//
//public void printData() 
//{
//    lock.lock();
//    try 
//    {
//        System.out.println("Thread-safe code");
//    } finally {
//        lock.unlock();
//    }
//}

