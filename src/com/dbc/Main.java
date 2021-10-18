package com.dbc;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean verificaLogin = false;

        while (true) {
            if(!verificaLogin){
            System.out.println("Digite o login: ");
            String login = scanner.next();

            System.out.println("Digite a senha: ");
            String senha = scanner.next();

            if(criarAdmin().logar(login,senha)){
                programaAdmin();
            }
            else if(criarCliente().logar(login, senha)){
                System.out.println("*****************************");
                System.out.println("        Login efetuado");
                System.out.println("*****************************");
                verificaLogin = true;
                programaUsuario();
            }else {
                System.err.println("Login ou senha incorretos.");
            }}
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
    static Reserva constroiReserva(){
        Reserva reserva = new Reserva();
        ArrayList<String> listaEstado = new ArrayList<>();
        ArrayList<String> listaCidade = new ArrayList<>();
        ArrayList<String> listaHotel = new ArrayList<>();
        ArrayList<Integer> listaQuarto = new ArrayList<>();
        ArrayList<Double> listaValor = new ArrayList<>();
//
        listaEstado.add("RS");
        listaCidade.add("POA");
        listaHotel.add("HOTEL");
        listaQuarto.add(456);
        listaValor.add(270.05d);

        reserva.setListaCidade(listaCidade);
        reserva.setListaEstado(listaEstado);
        reserva.setListaHotel(listaHotel);
        reserva.setListaQuarto(listaQuarto);
        reserva.setListaValor(listaValor);
        return reserva;
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

                        while (aux) {
                            System.out.println("Digite o index do hotel desejado: ");
                            Integer indexHotel = scanner.nextInt();
                            if (indexHotel < hoteis.getHoteis()[resposta].length) {
                                hoteis.imprimeQuartos(resposta, escolhaCidade, indexHotel);
                                while (aux){
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

                                        System.out.println("Reserva concluída!!!!\n");

                                        aux = false;
                                        return listaReserva.add(reserva);
                                    }else {
                                        System.err.println("Indice incorreto!!");
                                    }
                                }
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
    static Conta criarCliente(){
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

        return usuarioUm;

    }
    static Conta criarAdmin(){
        Usuario usuarioAdmin = new Usuario();
        usuarioAdmin.setLogin("admin");
        usuarioAdmin.setSenha("admin");

        return usuarioAdmin;
    }
    static boolean opcaoDois(){
        try {
            if(listaReserva.size() > 0){
                System.out.println("\n===================================");
                System.out.println("        Reservas realizadas");
                System.out.println("===================================");
                for(int i = 0; i < listaReserva.size(); i++){
                    try {
                        System.out.println("Estado: " + listaReserva.get(i).getListaEstado().get(0));
                        System.out.println("Cidade: " + listaReserva.get(i).getListaCidade().get(0));
                        System.out.println("Hotel: " + listaReserva.get(i).getListaHotel().get(0));
                        System.out.println("Quarto: " + listaReserva.get(i).getListaQuarto().get(0));
                        System.out.println("Valor: " + listaReserva.get(i).getListaValor().get(0));
                        System.out.println("--------------------");
                    }catch (IndexOutOfBoundsException ignored){
                    }

                }
                System.out.println("===================================\n");
                return true;
            }else {
                System.err.println("Não existem reservas ainda.");
            }
        }catch (IndexOutOfBoundsException ignored){
        }
        return false;

    }
    static void opcaoTres(){
        Scanner scanner = new Scanner(System.in);
        try {
            if(listaReserva.size() > 0){
                System.out.println("=============================");
                System.out.println("       CANCELAMENTOS!!");
                System.out.println("=============================");
                System.out.println("Index     Hoteis");
                for (int i = 0; i < listaReserva.size(); i++){
                    try {
                        System.out.println(i + "         " + listaReserva.get(i).getListaHotel().get(0));
                    }catch (IndexOutOfBoundsException ignored){}

                }
                System.out.println("=============================\n");
                while (true){
                    System.out.println("Escolha o index desejado para remoção:");
                    Integer indexRemocao = scanner.nextInt();
                    if(indexRemocao < listaReserva.size()){
                        listaReserva.get(indexRemocao).getListaHotel().remove(0);
                        listaReserva.get(indexRemocao).getListaCidade().remove(0);
                        listaReserva.get(indexRemocao).getListaEstado().remove(0);
                        listaReserva.get(indexRemocao).getListaQuarto().remove(0);
                        listaReserva.get(indexRemocao).getListaValor().remove(0);
                        System.err.println("Reserva cancelada!\n");
                        break;
                    }else {
                        System.err.println("Index incorreto!");
                    }
                }
            }else {
                System.err.println("Nenhuma reserva cadastrada...");
            }
        }catch (IndexOutOfBoundsException ignored){
        }
    }
    static void opçaoQuatro(){
        Scanner scanner = new Scanner(System.in);
        if(opcaoDois()){
            System.out.println("=============================");
            System.out.println("          ATUALIZAR");
            System.out.println("=============================");
            System.out.println("Index     Hoteis");
            for (int i = 0; i < listaReserva.size(); i++){
                try {
                    System.out.println(i + "         " + listaReserva.get(i).getListaHotel().get(0));
                }catch (IndexOutOfBoundsException ignored){}
            }

            System.out.println("=============================");
            while (true){
                System.out.println("Qual indice deseja atualizar? ");
                int indice = scanner.nextInt();

                if(indice < listaReserva.size()){
                    listaReserva.remove(indice);
                    opcaoUm();
                    break;
                }else {
                    System.err.println("Indice incorreto!");
                }
            }
        }
    }
    static void menu(){
        System.out.println("\n=============================");
        System.out.println("            MENU");
        System.out.println("=============================");
        System.out.println("[0] - Sair\n[1] - Cadastrar Reserva\n[2] - Listar Reservas\n[3] - Excluir" +
                "\n[4] - Atualizar");
        System.out.println("=============================");
    }
    static void programaUsuario(){
        Scanner scanner = new Scanner(System.in);
        while (true){
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
                case 4 -> {
                    opçaoQuatro();
                    break;
                }
                default -> {
                    System.err.println("Index errado!");
                }
            }
        }

    }
    static void programaAdmin(){
        System.err.println("ADMIN EM MANUTENÇÃO");

    }
}
