package com.godme.leetcode.q1114;

import java.util.concurrent.atomic.AtomicInteger;

class Foo {

    final AtomicInteger flag = new AtomicInteger(1);
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while(flag.get() != 1);
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (flag.get()!=2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (flag.get() != 3);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}