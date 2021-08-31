import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class Example2_2 {
    //taken of https://www.baeldung.com/java-future
    public static class SummationCalculator extends RecursiveTask<Long> {
        private boolean debug;
        private int start;
        private int end;
        public SummationCalculator(int end, boolean debug) {
            this.start = 1;
            this.end = end;
            this.debug = debug;
        }
        private SummationCalculator(int start, int end, boolean debug) {
            this.start = start;
            this.end = end;
            this.debug = debug;
        }
        @Override
        protected Long compute() {
            if(debug) {
                Utils.writeLog("Adding from "+start+" to "+end);
            }
            if (start >= end) {
                return (long)start;
            }
            int middle = (end+start)/2;
            SummationCalculator sc1 = new SummationCalculator(start, middle, debug);
            SummationCalculator sc2 = new SummationCalculator(middle+1, end, debug);
            sc1.fork();
            sc2.fork();
            return sc1.join() + sc2.join();
        }
    }
    public long sum(int n){
        long s = 0;
        for(int i=1;i<=n;i++){
            s += i;
        }
        return s;
    }
    public static void main(String[] args) throws Exception{
        int n = 100000000;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SummationCalculator calculator = new SummationCalculator(n, false);

        long startTime = System.currentTimeMillis();
        Future<Long> fsum = forkJoinPool.submit(calculator);
        long sum = fsum.get();
        long endTime = System.currentTimeMillis();

        Utils.writeLog("The sum of the first "+n+" numbers is "+sum+", and last "+(endTime-startTime)+" ms");

        Utils.writeLog("The sum without additional threads ");
    }
}
