package control;

public class MyThread extends Thread {

    private boolean suspend = false;

    public synchronized void toSuspend() {
        suspend = true;
    }

    public synchronized void toResume() {
        notify();//The currently waiting thread continues execution
        suspend = false;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {

            synchronized (this) {
                while (suspend) {
                    try {
                        wait();//Let the thread enter the waiting state
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
