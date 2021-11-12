package com.jesusmelian;

public class Consumer extends Thread{
    private Monitor buffer;
    private int expectedUnits;
    private int maxSellTime;

    public Consumer(Monitor buffer, int expectedUnits, int maxSellTime) {
        this.buffer = buffer;
        this.expectedUnits = expectedUnits;
        this.maxSellTime = maxSellTime;
    }

    @Override
    public void run() {
        Vegetal vege;

        try {
            for (int i = 0; i < expectedUnits; i++) {
                //Vendo el vegetal
                vege = buffer.sell();
                sleep((int) (Math.random() * maxSellTime));
                System.out.println("sold: "+ vege.toString());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
