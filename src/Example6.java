import java.util.concurrent.CompletableFuture;

public class Example6 {
    public static void main(String[] args) throws Exception{
        CompletableFuture<String> completableFuture1
                = CompletableFuture.supplyAsync(() -> "Ahoy")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " Twilions"));

        Utils.writeLog(completableFuture1.get());

        /*
        CompletableFuture<String> completableFuture2
                = CompletableFuture.supplyAsync(() -> "Hola")
                .thenCombine(CompletableFuture.supplyAsync(
                        () -> " Mundo"), (s1, s2) -> s1 + s2);

        Utils.writeLog(completableFuture2.get());

        CompletableFuture future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
                        (s1, s2) -> System.out.println(s1 + s2));
         */
    }
}
