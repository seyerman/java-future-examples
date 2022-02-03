import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example5 {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> completableFuture1 = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        //Thread.sleep(600);
                        Utils.writeLog("in the supplyAsync 1");
                    } catch (Exception ie) {
                        ie.printStackTrace();
                    }
                    return "Ahoy";
                });

        CompletableFuture<String> future1 = completableFuture1
                .thenApply(s -> {
                    try {
                        //Thread.sleep(500);
                        Utils.writeLog("in the thenApply");
                    } catch (Exception ie) {
                        ie.printStackTrace();
                    }
                    return s + " Twilions";
                });

        CompletableFuture<String> completableFuture2 = CompletableFuture.
                supplyAsync(() -> {
                    try {
                        Thread.sleep(400);
                        Utils.writeLog("in the supplyAsync 2");
                    } catch (Exception ie) {
                        ie.printStackTrace();
                    }
                    return "Ahoy";
                });

        CompletableFuture<Void> future2 = completableFuture2
                .thenAccept(s -> {
                    try {
                        Thread.sleep(300);
                        Utils.writeLog("Computation returned in future2: " + s);
                    } catch (Exception ie) {
                        ie.printStackTrace();
                    }
                });

        CompletableFuture<String> completableFuture3 = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(200);
                        Utils.writeLog("in the supplyAsync 3");
                    } catch (Exception ie) {
                        ie.printStackTrace();
                    }
                    return "Hello";
                });

        CompletableFuture<Void> future3 = completableFuture3
                .thenRun(() -> {
                    try {
                        Thread.sleep(100);
                        Utils.writeLog("Computation returned in future3");
                    } catch (Exception ie) {
                        ie.printStackTrace();
                    }
                });

        Thread.sleep(5000);
    }
}
