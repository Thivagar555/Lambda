package thread;

public class Thread2 {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();

        Thread t1 = new Thread(() -> {
            System.out.println("thread 1 started");
            for(int i=0; i<500; i++)
            {
                sharedResource.increment();
            }
            System.out.println("thread 1 completed");
        });

        Thread t2 = new Thread(() -> {
                System.out.println("thread 2 started");
        for(int i=0; i<500; i++)
        {
            sharedResource.increment();
        }
        System.out.println("thread 2 completed");
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(sharedResource.getCount());
    }

}
