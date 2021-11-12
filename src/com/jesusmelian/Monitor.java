package com.jesusmelian;

import java.util.ArrayList;

public class Monitor {
    private Vegetal arrVege[];
    private int index = 0;

    //indica si ya no queda espacio
    private boolean full = false;
    //indica si esta vacia
    private boolean empty = true;

    public Monitor(int capacity) {
        //creo el array de vegetales con la capacidad que yo quiera, simulando la capacidad del almacen
        this.arrVege = new Vegetal[capacity];
    }

    public synchronized void plant(Vegetal vege) throws InterruptedException {
        //si el array esta lleno espero y si no vcreo un nuevoi valor
        while (full){
            wait();
        }
        System.out.println("Creando un vegetal"+vege.getName());
        //Añado el vegetal
        arrVege[index] = vege;
        index++;
        empty = false;
        //si el indice es mayor o igual que la capacidad del almacen
        full=index >= arrVege.length;
        //despierta los hilos que esten en Wait()
        notifyAll();
    }

    public synchronized Vegetal sell() throws InterruptedException {
        //si el array esta vacio espero
        if(empty){
            wait();
        }
        index--;
        Vegetal v = arrVege[index];
        System.out.println("Selling the vegetable: "+arrVege[index].getName()+ " with a price: " + arrVege[index].getPrice());
        //Si se vendio un vegetal, ya no esta lleno el almacen
        full=false;
        //si hay mas de un vegetal no esta empty
        empty = index <=0;
        //Despierto los hilos que esten en wait()
        notifyAll();
        return  v;
    }
}
