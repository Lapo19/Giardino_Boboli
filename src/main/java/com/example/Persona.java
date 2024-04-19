package com.example;

public class Persona extends Thread{
    private Giardino giardino;
    private int num;

    public Persona(int num, Giardino giardino){
        this.num = num;
        this.giardino = giardino;
    }
    @Override
    public void run(){
        try{
            char ingresso = giardino.entra(this);
            if (ingresso=='A'){
            sleep(3000);
            }
            else{
            int t = 1000 + (int) (Math.random()*4000);
            sleep(t);
            }
            giardino.esci(ingresso);
        }catch(InterruptedException i){
            i.printStackTrace();
        }
    }
    }

