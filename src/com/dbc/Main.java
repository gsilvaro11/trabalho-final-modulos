package com.dbc;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Hoteis> listaHosteis = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        listaHosteis.add(new Hoteis(Estado.PERNAMBUCO, Cidade.RECIFE, "Teste", 3, "teste"));
        listaHosteis.add(new Hoteis(Estado.SAO_PAULO, Cidade.SAO_PAULO, "Teste", 3, "teste"));

        System.out.println("Digite o estado: ");
        Integer index = 2;

        List<Hoteis> filtroEstado = listaHosteis.stream()
                .filter(hoteis -> {
                    return hoteis.getEstado().getIndex().equals(index);
                })
                .collect(Collectors.toList());
        System.out.println(filtroEstado);


    }

}
