package com.example;



public class Giardino {
    private int ingressoA = 5;
    private int ingressoB = 10;
    private char ing;

    public synchronized char entra(Persona p) {
        String name = Thread.currentThread().getName();
       
        try {
            while ( (ingressoA == 0) && (ingressoB == 0)) {
                System.out.println("Entrambi gli ingressi sono pieni " + name + " aspetta");
               wait();
            }
            if(ingressoA == 0)
            {
                ingressoB--;
                ing = 'B';
            }
            else
            {
            ingressoA--; 
            ing = 'A';
            }  
            System.out.println(name + " entra nel giardino dall'ingresso " + ing);
        } catch ( InterruptedException e) { }
        return ing;
    }

    public synchronized void esci(char ingresso) {
        String name = Thread.currentThread().getName();
        if(ingresso == 'A'){
        ingressoA++;
        }
        else{
        ingressoB++;
        }
        System.out.println(name + " esce dal giardino dall'ingresso " + ingresso);
        notifyAll();
    }

    public char getIngresso(){
        return ing; 
    }
}
