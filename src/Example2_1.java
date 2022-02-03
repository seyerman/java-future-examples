import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class Example2_1 {
    //based on https://www.baeldung.com/java-future
    public static class SummationCalculator extends RecursiveTask<Long> {
        private Integer n;
        public SummationCalculator(Integer n) {
            this.n = n;
        }
        @Override
        protected Long compute() {
            Utils.writeLog("Counting by "+n);
            if (n <= 1) {
                return (long)1;
            }
            SummationCalculator sc = new SummationCalculator(n-1);
            sc.fork();
            return n+sc.join();
        }
    }
    public static void main(String[] args) throws Exception{
        int n = 1000;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SummationCalculator calculator = new SummationCalculator(n);

        long startTime = System.currentTimeMillis();
        Future<Long> fsum = forkJoinPool.submit(calculator);
        long sum = fsum.get();
        long endTime = System.currentTimeMillis();

        Utils.writeLog("The sum of the first "+n+" numbers is "+sum+", and last "+(endTime-startTime)+" ms");
    }
}
