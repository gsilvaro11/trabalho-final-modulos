package com.dbc;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaEstados = new ArrayList<>();
        String[][] listaCidades = {
                {"PORTO ALEGRE", "VIAMÃO", "CANOAS"},
                {"RIO DE JANEIRO", "TESTE"}
        };
        String[][][] listaHoteis = {
                {{"HotelPorto", "Hotel1"}, {"HotelViamao", "Hotel1"}, {"HotelPorto", "Hotel1"}},
                {{"HotelPorto", "Hotel1"}, {"HotelViamao", "Hotel1"}}
        };
        Hoteis hoteis = new Hoteis();
        listaEstados.add("RS");
        listaEstados.add("RJ");
        hoteis.setEstados(listaEstados);
        hoteis.setCidades(listaCidades);
        hoteis.setHoteis(listaHoteis);

        //********* PROGRAMA ***********

        while (true) {

            hoteis.imprimeEstado();
            System.out.println("Escolha um indice");
            Integer resposta = scanner.nextInt();

            if (resposta < hoteis.getEstados().size()) {
                hoteis.imprimeCidade(resposta);

                while (true) {
                    System.out.println("Escolha o indice da cidade: ");
                    Integer escolhaCidade = scanner.nextInt();
                    if (escolhaCidade < hoteis.getCidades()[resposta].length) {
                        hoteis.imprimeHoteis(resposta, escolhaCidade);
                    } else {
                        System.err.println("Indice incorreto");
                    }
                }
            } else {
                System.err.println("Indice incorreto");
            }


        }
    }
}
