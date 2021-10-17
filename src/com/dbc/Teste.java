package com.dbc;

import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {

        ArrayList<String> teste = new ArrayList<>();
        teste.add("teste");
        System.out.println(teste.size());
        teste.remove(0);
        System.out.println(teste.size());
        System.out.println(teste.get(0));

    }
}
