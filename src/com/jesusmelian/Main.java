package com.jesusmelian;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Monitor monitor = new Monitor(40);
        Productor productor = new Productor(monitor, 12, 1000);
        Consumer consumer = new Consumer(monitor, 12, 4000);
        productor.start();
        consumer.start();

        //Monitor monitor2 = new Monitor(40);
        Productor productor2 = new Productor(monitor, 5, 1000);
        Consumer consumer2 = new Consumer(monitor, 5, 4000);
        productor2.start();
        consumer2.start();
    }
}
