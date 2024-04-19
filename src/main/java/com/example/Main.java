package com.example;

public class Main {
    public static void main(String[] args) {
        Giardino giardino = new Giardino();

        for(int i=0;i<16;i++){
            Persona t = new Persona(i, giardino);
            t.start();
        }
    }
}