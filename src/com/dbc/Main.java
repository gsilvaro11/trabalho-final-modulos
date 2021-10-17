package com.dbc;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();
            System.out.println("Digite o index desejado: ");
            int index = scanner.nextInt();

            switch (index) {
                case 0 -> {
                    System.exit(0);
                }
                case 1 -> {
                    opcaoUm();
                    break;
                }
                case 2 -> {
                    opcaoDois();
                    break;
                }
                case 3 -> {
                    opcaoTres();
                    break;
                }
                default -> {
                    System.err.println("Index errado!");
                }
            }
        }


    }
    static ArrayList<Reserva> listaReserva = new ArrayList<>();
    static Hoteis constroiHotel(){
        ArrayList<Estado> listaEstados = new ArrayList<>();
        Cidade[][] listaCidades = {
                {Cidade.PORTO_ALEGRE, Cidade.GRAMADO},
                {Cidade.RECIFE, Cidade.OLINDA},
                {Cidade.GUARATINGUETA, Cidade.SAO_PAULO}
        };
        String[][][] listaHoteis = {
                {{"HOTEL LAGHETOO", "HOTEL DEVILLE"}, {"PRODIGY HOTEL", "HOTEL FIOREZE"}},
                {{"IBIS", "HOLLYDAY"}, {"HOTEL COSTEIRO", "HOTEL 7 COLINAS"}},
                {{"LOTUS", "GUARA INN"}, {"SAN MICHEL", "SAN RAPHAEL"}}
        };

        Integer[][][] listaNumeroQuarto = {
                {{320, 110}, {8, 27}},
                {{88, 12}, {369, 458}},
                {{340, 157}, {478, 69}}
        };

        String[][][] listaDescricaoQuarto = {
                {{"Casal", "Solteiro"}, {"Casal", "Solteiro"}},
                {{"Casal", "Solteiro"}, {"Casal", "Solteiro"}},
                {{"Casal", "Solteiro"}, {"Casal", "Solteiro"}}
        };

        Double[][][] listaValorQuarto = {
                {{270.0d, 158.0d}, {326.0d, 257.0d}},
                {{425.0d, 175.0d}, {177.99d, 110.0d}},
                {{127.0d}, {255.99d, 427.0d}}
        };


        Hoteis hoteis = new Hoteis();
        listaEstados.add(Estado.RIO_GRANDE_DO_SUL);
        listaEstados.add(Estado.PERNAMBUCO);
        listaEstados.add(Estado.SAO_PAULO);

        hoteis.setEstados(listaEstados);
        hoteis.setCidades(listaCidades);
        hoteis.setHoteis(listaHoteis);
        hoteis.setNumeroQuarto(listaNumeroQuarto);
        hoteis.setDescricao(listaDescricaoQuarto);
        hoteis.setValorQuarto(listaValorQuarto);

        return hoteis;
    }
    static Object opcaoUm() {
        Scanner scanner = new Scanner(System.in);
        Hoteis hoteis = constroiHotel();
        Reserva reserva = new Reserva();


        boolean aux = true;
        while (aux) {
            hoteis.imprime();
            System.out.println("Escolha um indice: ");
            Integer resposta = scanner.nextInt();

            if (resposta < hoteis.getEstados().size()) {
                hoteis.imprime(resposta);

                while (aux) {
                    System.out.println("Escolha o indice da cidade: ");
                    Integer escolhaCidade = scanner.nextInt();
                    if (escolhaCidade < hoteis.getCidades()[resposta].length) {
                        hoteis.imprime(resposta, escolhaCidade);
                        System.out.println("Digite o index do hotel desejado: ");
                        Integer indexHotel = scanner.nextInt();

                        while (aux) {
                            if (indexHotel < hoteis.getHoteis()[resposta].length) {
                                hoteis.imprimeQuartos(resposta, escolhaCidade, indexHotel);
                                System.out.println("Digite index do quarto desejado");
                                Integer escolhaQuarto = scanner.nextInt();

                                if (escolhaQuarto < hoteis.getNumeroQuarto()[resposta][indexHotel].length) {
                                    ArrayList<String> listaEstado = new ArrayList<>();
                                    ArrayList<String> listaCidade = new ArrayList<>();
                                    ArrayList<String> listaHotel = new ArrayList<>();
                                    ArrayList<Integer> listaQuarto = new ArrayList<>();
                                    ArrayList<Double> listaValor = new ArrayList<>();
//
                                    listaEstado.add(hoteis.getEstados().get(resposta).getName());
                                    listaCidade.add(hoteis.getCidades()[resposta][escolhaCidade].getName());
                                    listaHotel.add(hoteis.getHoteis()[resposta][escolhaCidade][indexHotel]);
                                    listaQuarto.add(hoteis.getNumeroQuarto()[resposta][escolhaCidade][escolhaQuarto]);
                                    listaValor.add(hoteis.getValorQuarto()[resposta][escolhaCidade][escolhaQuarto]);

                                    reserva.setListaCidade(listaCidade);
                                    reserva.setListaEstado(listaEstado);
                                    reserva.setListaHotel(listaHotel);
                                    reserva.setListaQuarto(listaQuarto);
                                    reserva.setListaValor(listaValor);


                                    System.out.println("Reserva concluída\n");

                                    aux = false;
                                    return listaReserva.add(reserva);
                                }

                            } else {
                                System.err.println("Indice incorreto!!");
                            }
                        }

                    } else {
                        System.err.println("Indice incorreto!!");
                    }
                }
            } else {
                System.err.println("Indice incorreto!!");
            }

        }
        return listaReserva.add(reserva);
    }
    static void opcaoDois(){

        try {
            if(listaReserva.size() > 0){
                System.out.println("\n===================================");
                System.out.println("Reservas realizadas");
                for(int i = 0; i < listaReserva.size(); i++){
                    System.out.println("Estado: " + listaReserva.get(i).getListaEstado().get(0));
                    System.out.println("Cidade: " + listaReserva.get(i).getListaCidade().get(0));
                    System.out.println("Hotel: " + listaReserva.get(i).getListaHotel().get(0));
                    System.out.println("Quarto: " + listaReserva.get(i).getListaQuarto().get(0));
                    System.out.println("Valor: " + listaReserva.get(i).getListaValor().get(0));
                }
                System.out.println("===================================\n");
            }else {
                System.err.println("Não existem reservas ainda.");
            }
        }catch (IndexOutOfBoundsException e){

        }


    }
    static void opcaoTres(){
        Scanner scanner = new Scanner(System.in);

        if(listaReserva.size() > 0){
            for (int i = 0; i < listaReserva.size(); i++){
                System.out.println(i + " " + listaReserva.get(i).getListaHotel().get(0));
            }
            while (true){
                System.out.println("Escolha o index desejado para remoção:");
                Integer indexRemocao = scanner.nextInt();
                if(indexRemocao < listaReserva.size()){
                    listaReserva.get(indexRemocao).getListaHotel().remove(0);
                    listaReserva.get(indexRemocao).getListaCidade().remove(0);
                    listaReserva.get(indexRemocao).getListaEstado().remove(0);
                    listaReserva.get(indexRemocao).getListaQuarto().remove(0);
                    listaReserva.get(indexRemocao).getListaValor().remove(0);

                    break;
                }else {
                    System.err.println("Index incorreto!");
                }
            }
        }else {
            System.err.println("Nenhuma reserva cadastrada...");
        }


    }
    static void menu(){
        System.out.println("=============================");
        System.out.println("[0] - Sair\n[1] - Cadastrar Reserva\n[2] - Listar Reservas\n[3] - Excluir");
        System.out.println("=============================");
    }
    public static void criarCliente(){
        Endereco enderecoUm = new Endereco();
        enderecoUm.setEstado("SP");
        enderecoUm.setCidade("Guaratinguetá");
        enderecoUm.setNumero(484);
        enderecoUm.setCep("12504-010");

        Contato contatoUm = new Contato();
        contatoUm.setTelefone("12981117598");
        contatoUm.setEmail("Matheus.camilo16@hotmail.com");

        Usuario usuarioUm = new Usuario();
        usuarioUm.setNome("Matheus Camilo");
        usuarioUm.setCpf("41286811805");
        usuarioUm.setContato(contatoUm);
        usuarioUm.setEndereco(enderecoUm);
        usuarioUm.setLogin("mathcamilo");
        usuarioUm.setSenha("123");



    }
}

