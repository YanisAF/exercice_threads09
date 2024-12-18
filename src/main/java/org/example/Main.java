package org.example;

import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    private static final AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                    while (true) {
                        int count = counter.get();
                        if (count >= 10) {

                        }

                        // compareAndSet verifier et met a jour la valeur de maniere atomique
                        if(counter.compareAndSet(count, count + 1)){
                            System.out.println(Thread.currentThread().getName()+ " a incrementé le compteur à "+(count + 1));
                            break;
                        }
                    }

                // compareAndSet verifier et met a jour la valeur de maniere atomique

            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(counter);

    }
}