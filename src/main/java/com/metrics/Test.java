package com.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @program: yarn
 * @description:
 * @author: liang.man
 * @create: 2019-01-30 16:06
 **/
public class Test {
    private static final MetricRegistry metrics = new MetricRegistry();

    private static Queue<String> queue = new LinkedBlockingDeque<String>();

    /**
     * 在控制台上打印输出
     */
    private static ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();

    //private static ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();

    public static void main(String[] args){
        reporter.start(3, TimeUnit.SECONDS);
        Gauge gauge = new Gauge(){

            @Override
            public Object getValue() {
                return queue.size();
            }
        };

        metrics.register(MetricRegistry.name(Test.class,"pendding-job","size"),gauge);
        for (int i=0; i<20; i++){
            queue.add("a");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
