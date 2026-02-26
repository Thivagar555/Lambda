package thread;

public class MultiThread {
    public static Object sharedObject = new Object();
    public static void main(String[] args) {
        System.out.println("main thread");


       Runnable objRunnable = () ->
       {
           System.out.println(Thread.currentThread().getName() + " is running");
           System.out.println(sharedObject.hashCode());
           try {
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           System.out.println(Thread.currentThread().getName() + " is completed");
       };
       Thread obj1 = new Thread(objRunnable, "Runnable Thread 1");
       obj1.setDaemon(true);

       obj1.start();

        Runnable objRunnable2 = () ->
        {
            System.out.println(Thread.currentThread().getName() + " is running");
            System.out.println(sharedObject.hashCode());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " is completed");
        };
        Thread obj2 = new Thread(objRunnable2, "Runnable Thread 2");
        obj2.start();
       System.out.println("Main thread ended");
    }
}
