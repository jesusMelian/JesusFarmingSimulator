package com.jesusmelian;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Monitor monitor = new Monitor(40);
        Productor productor = new Productor(monitor, 12, 1000);
        Consumer consumer = new Consumer(monitor, 12, 4000);

        productor.start();
        consumer.start();
    }
}
