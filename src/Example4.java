import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Example4 {
    public static void main(String[] args) throws Exception{
        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(200);
                Utils.writeLog("Our first completable future with logic inside");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(100);
                Utils.writeLog("Our second completable future with logic inside");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Value returned of the first supply async";
        });

        cf1.get();

        Utils.writeLog(cf2.get());
    }
}
