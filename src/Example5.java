import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example5 {
    public static void main(String[] args) throws Exception{
        CompletableFuture<String> completableFuture1
                = CompletableFuture.supplyAsync(() -> "Ahoy");

        CompletableFuture<String> future1 = completableFuture1
                .thenApply(s -> s + " Twilions");

        Utils.writeLog(future1.get());

        /*
        CompletableFuture<String> completableFuture2
                = CompletableFuture.supplyAsync(() -> "Ahoy");

        CompletableFuture<Void> future2 = completableFuture2
                .thenAccept(s -> Utils.writeLog("Computation returned in future2: " + s));

        future2.get();

        CompletableFuture<String> completableFuture3
          = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future3 = completableFuture3
          .thenRun(() -> Utils.writeLog("Computation finished in future3."));

        future3.get();
        */
    }
}
