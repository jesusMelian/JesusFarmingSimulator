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
        String[] arrNamesVegetals = new String[]{"lettuce",
                "cabbage",
                "onion",
                "spinach",
                "potato",
                "celery",
                "asparagus",
                "radish",
                "broccoli",
                "artichoke",
                "tomato",
                "cucumber",
                "eggplant",
                "carrot",
                "green bean"};



        try {
            if (buffer.getArrVege().length < produceUnit){
                System.out.println("ERROR EL LAS UNIDADES QUE QUIERE PRODUCIR SUPERA LA CAPACIDAD DEL HUERTO");
                return;
            }
            for (int i = 0; i < produceUnit; i++) {
                //Agrego un vegetal con un nombre aleatorio y un precio aleatorio
                vege = new Vegetal(arrNamesVegetals[(int)(Math.random() * 14)], (int)(Math.random() * ((10 + 1))));

                //planto el vegetal
                buffer.plant(vege);

                //tiempo que tardamos en plantar es
                sleep((int) (Math.random() *this.maxPlantTime));
                //VEGETAL PLANTADO
                System.out.println("Planted => "+vege.getName());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
