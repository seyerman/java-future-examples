import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Example3 {
    public static void main(String[] args) throws Exception{
        Future<String> cf = CompletableFuture.completedFuture("Hello World");

        Utils.writeLog(cf.get());
    }
}
