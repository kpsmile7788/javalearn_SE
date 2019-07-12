package org.wm.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class TestForkJoin extends RecursiveTask<Long> {
    private int start;
    private int end;
    private final int step = 20000000;//最小拆分成几个数相加
    public TestForkJoin(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        long sum = 0;
        if(end - start <= step ){
            //小于5个数，直接求和
            for (int i = start; i <=end; i++) {
                sum+=i;
            }
        }else{
            //大于5个数，分解任务
            int mid = (end + start)/2;
            TestForkJoin leftTask = new TestForkJoin(start,mid);
            TestForkJoin rightTask = new TestForkJoin(mid+1,end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //子任务，执行完，得到执行结果
            long leftSum = leftTask.join();
            long rightSum = rightTask.join();
            sum = leftSum+rightSum;
        }
        return sum;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //如果多核CPU，其实是一个一直使用，其他闲置；怎么办，多线程解决；
        //但是涉及到任务的拆分与合并等众多细节，不要紧，现在使用ForkJoin框架，可以较轻松解决；
        long  start = System.currentTimeMillis();
        long sum = 0;
        for(int i=0;i<=1000000000;i++){
            sum +=i;
        }
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println("for:"+(end - start));
        //使用ForkJoin框架解决
        //创建一个线程池
        ForkJoinPool pool = new ForkJoinPool();
        //定义一个任务
        TestForkJoin sumTask = new TestForkJoin(1,1000000000);
        //将任务交给线程池
        start = System.currentTimeMillis();
        Future<Long> future = pool.submit(sumTask);
        //得到结果并输出
        Long result = future.get();
        System.out.println(result);
        end = System.currentTimeMillis();
        System.out.println("pool:"+(end - start));
    }

}
