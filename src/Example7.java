import java.util.concurrent.CompletableFuture;

public class Example7 {
    public static void main(String[] args) throws Exception{
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(future1, future2, future3);

        combinedFuture.get();

        Utils.writeLog(future1.get());
        Utils.writeLog(future2.get());
        Utils.writeLog(future3.get());
    }
}
