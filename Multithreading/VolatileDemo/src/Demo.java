import java.util.concurrent.TimeUnit;

public class Demo {

    private static boolean stopRequested = false;

    private static synchronized boolean getRequestStatus () {
        return stopRequested;
    }

    private static synchronized void stopRequested() {
        stopRequested = true;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while(!stopRequested){ //<- if uncommented, will never stop
                //while (!getRequestStatus()) {
                    i ++;
                }
                System.out.println(i);
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true; //<-- if uncommented will never stop
        //stopRequested();
        System.out.println("I finished "+stopRequested);
    }
}

//while (!stopRequested) i++
//turns into if(!stopRequested) while(true) i++
