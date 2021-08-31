import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example1 {
    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Utils.writeLog("Welcome to the Future");
        Future<?> fr = executor.submit(()->{
            try {
                Thread.sleep(200);
                Utils.writeLog("Using My First Java Future");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Future<Integer> fc = executor.submit(()->{
            try {
                Thread.sleep(100);
                Utils.writeLog("Using My Second Java Future");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 69;
        });

        Utils.writeLog("fc is done with the output: "+fc.get());

        Utils.writeLog("fr is done with the output: "+fr.get());

        executor.shutdown();
    }
}
