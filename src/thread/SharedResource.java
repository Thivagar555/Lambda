package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource
{
    //orElse we can use Synchronized in the void increment function

    AtomicInteger count=new AtomicInteger(0);

     void increment(){
        count.incrementAndGet();
    }

    int getCount()
    {
        return count.get();
    }

}
