import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class Example2_1 {
    //based on https://www.baeldung.com/java-future
    public static class SummationCalculator extends RecursiveTask<Integer> {
        private Integer n;
        public SummationCalculator(Integer n) {
            this.n = n;
        }
        @Override
        protected Integer compute() {
            Utils.writeLog("Counting by "+n);
            if (n <= 1) {
                return 1;
            }
            SummationCalculator sc = new SummationCalculator(n-1);
            sc.fork();
            return n+sc.join();
        }
    }
    public static void main(String[] args) throws Exception{
        int n = 10;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SummationCalculator calculator = new SummationCalculator(n);
        Future<Integer> fsum = forkJoinPool.submit(calculator);

        Utils.writeLog("The sum of the first "+n+" numbers is "+fsum.get());
    }
}
