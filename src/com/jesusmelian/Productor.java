package com.jesusmelian;

public class Productor extends Thread{
    private Monitor buffer;
    private int produceUnit;
    private int maxPlantTime;

    public Productor(Monitor buffer, int produceUnit, int maxPlantTime) {
        this.buffer = buffer;
        this.produceUnit = produceUnit;
        this.maxPlantTime = maxPlantTime;
    }

    @Override
    public void run() {
        Vegetal vege;

        try {
            for (int i = 0; i < produceUnit; i++) {
                //SE LE SUMA EL VALOR DE EL CODIGO ASCII Y SERIA EL SIGUIENTE B ,C
                vege = new Vegetal(name, price);
                //planto el vegetal
                buffer.plant(vege);
                System.out.println("Planted => "+vege.getName());
                //tiempo que tardamos en plantar
                sleep((int) (Math.random() *this.maxPlantTime));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
