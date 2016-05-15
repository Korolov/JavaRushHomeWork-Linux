package com.javarush.test.level25.lesson05.home01;

import static java.lang.Thread.State.BLOCKED;
import static java.lang.Thread.State.TERMINATED;
import static java.lang.Thread.State.TIMED_WAITING;

/**
 * Created by alexander on 03.03.16.
 */
public class LoggingStateThread extends Thread implements Runnable

{
    Thread t;
    State state=null;
    State t1=null;

    public LoggingStateThread(Thread t) throws InterruptedException
    {
        this.setDaemon(true);
        this.t = t;
        this.state = t.getState();
        System.out.println(state);
    }
    @Override
    public void run()
    {
        while (state != TERMINATED)
        {
            if (state != (t1 = t.getState()))
            {
                state=t1;

               System.out.println(state);
            }
        }
    }
}


