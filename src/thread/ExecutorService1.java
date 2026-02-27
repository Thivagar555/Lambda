package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorService1 {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for(int i=1; i<=5 ; i++)
        {
            final int taskId = i;
            singleThreadExecutor.execute(() -> {
                System.out.println("Single Thread task " + taskId + " executed by Thread: "+ Thread.currentThread().getName());
            });
        }
        singleThreadExecutor.shutdown();

        //ToDo fixedThreadExecutor
        ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(3);
        for(int i=1; i<=5; i++)
        {
            final int taskId = i;
            fixedThreadExecutor.execute(() -> {
                System.out.println("fixed Thread task " + taskId + " executed by Thread: "+ Thread.currentThread().getName());
            });
        }
        fixedThreadExecutor.shutdown();

        //TODO cachedThread Poll
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i =1; i<=5; i++)
        {
            final int taskId = i;
            cachedThreadPool.execute(() ->{
                System.out.println("cached Thread task " + taskId + " executed by Thread: "+ Thread.currentThread().getName());
            });
        }
        cachedThreadPool.shutdown();
        //TODO SCHEDULED THREAD POOL

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        for (int i=1; i<=5; i++)
        {
            final int taskId = i;
            scheduledThreadPool.schedule(() -> {
                System.out.println("run after 5 sec");
                System.out.println("scheduled Thread task " + taskId + " executed by Thread: "+ Thread.currentThread().getName());
            }, 5, TimeUnit.SECONDS);
        }
        scheduledThreadPool.shutdown();
    }
}
