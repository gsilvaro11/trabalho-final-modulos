package com.dbc;

import com.dbc.Service.*;
import com.dbc.model.*;
import com.dbc.repository.ConexaoBancoDeDados;
import com.dbc.repository.UsuarioRepository;

import javax.sound.midi.Soundbank;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        ReservaService reservaService = new ReservaService();
        QuartosService quartosService = new QuartosService();
        UsuarioService usuarioService = new UsuarioService();
        HoteisService hoteisService = new HoteisService();
        CidadeService cidadeService = new CidadeService();
        EstadoService estadoService = new EstadoService();
        EnderecoService enderecoService = new EnderecoService();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataLocal = dtf.format(LocalDateTime.now());

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("========= MENU RESERVA =========");
            System.out.println("Digite [1] para CRIAR reserva\n" + "Digite [2] para LISTAR reserva\n" + "Digite [3] para EDITAR reserva \n" + "Digite [4] para EXCLUIR reserva\n");

            System.out.println("========== MENU HOTEL ==========");
            System.out.println("Digite [5] para CADASTRAR hotel\n" + "Digite [6] para LISTAR hotel\n" + "Digite [7] para EDITAR hotel \n" + "Digite [8] para EXCLUIR hotel\n");
            System.err.println("Digite [0] para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1: { //adicionar

                    Reserva reserva = new Reserva();
                    Hoteis hoteis = new Hoteis();
                    Quartos quartos = new Quartos();
                    Usuario usuario = new Usuario();
                    estadoService.listarEstados();
                    System.out.println("Digite o índice do estado: ");
                    Integer indexEstado = scanner.nextInt();
                    cidadeService.listarCidadesPorEstado(indexEstado);
                    System.out.println("Digite o índice da cidade: ");
                    Integer indexCidade = scanner.nextInt();
                    hoteisService.listarHoteisPorCidade(indexCidade);

                    System.out.println("Digite o índice do Hotel: ");
                    Integer indexHotel = scanner.nextInt();
                    quartosService.listarQuartosPorHotel(indexHotel);
                    System.out.println("Digite o índice do Quarto ");
                    Integer indexQuarto = scanner.nextInt();

                    quartos.setIdQuarto(indexQuarto);
                    //hoteis.setIdHotel(indexHotel);
                    usuario.setIdUsuario(1);

                    reserva.setHoteis(hoteisService.getHoteisPorId(indexHotel));
                    reserva.setQuartos(quartosService.getQuartoPorId(indexQuarto));
                    reserva.setUsuario(usuarioService.getUsuarioPorId(1));
                    reserva.setDataReserva(LocalDate.parse(dataLocal, formatter));
                    reservaService.adicionarReserva(reserva);
                    break;

                }
                case 2: { //listar
                    reservaService.listarReserva();
                    break;
                }
                case 3: { //editar
                    reservaService.listarReserva();
                    System.out.println("Digite o índice da Reserva: ");
                    Integer indiceReserva = scanner.nextInt();

                    Reserva reserva = new Reserva();
                    Hoteis hoteis = new Hoteis();
                    Quartos quartos = new Quartos();
                    Usuario usuario = new Usuario();
                    estadoService.listarEstados();
                    System.out.println("Digite o índice do estado: ");
                    Integer indexEstado = scanner.nextInt();
                    cidadeService.listarCidadesPorEstado(indexEstado);
                    System.out.println("Digite o índice da cidade: ");
                    Integer indexCidade = scanner.nextInt();
                    hoteisService.listarHoteisPorCidade(indexCidade);
                    System.out.println("Digite o índice do Hotel: ");
                    Integer indexHotel = scanner.nextInt();
                    quartosService.listarQuartosPorHotel(indexHotel);
                    System.out.println("Digite o índice do Quarto ");
                    Integer indexQuarto = scanner.nextInt();
                    quartos.setIdQuarto(indexQuarto);
                    hoteis.setIdHotel(indexHotel);
                    usuario.setIdUsuario(1);

                    reserva.setHoteis(hoteis);
                    reserva.setQuartos(quartos);
                    reserva.setUsuario(usuario);
                    reserva.setDataReserva(LocalDate.parse(dataLocal, formatter));

                    reservaService.editarReserva(indiceReserva, reserva);
                    break;
                }
                case 4: { //remover
                    reservaService.listarReserva();
                    System.out.println("Digite o índice da Reserva: ");
                    Integer indexReserva = scanner.nextInt();
                    reservaService.removerReserva(indexReserva);
                    break;
                }
                case 5: { // adc hotel
                    Hoteis hoteis = new Hoteis();
                    Quartos quartos = new Quartos();
                    Endereco endereco = new Endereco();


                    System.out.println("Digite o nome do hotel: ");
                    String nomeHotel = scanner.next();
                    enderecoService.listarEndereco();
                    System.out.println("Digite o indice do endereco: ");
                    Integer indexEndereco = scanner.nextInt();
                    hoteis.setNome(nomeHotel);
                    endereco.setId_endereco(indexEndereco);
                    hoteis.setEndereco(endereco);
                    hoteisService.adicionar(hoteis);
                    break;
                }
                case 6: { //listarHotel
                    hoteisService.listarHoteis();
                    break;
                }
                case 7: { //editarHotel
                    hoteisService.listarHoteis();
                    System.out.println("Digite o índice do Hotel: ");
                    Integer indiceHotel = scanner.nextInt();


                    Hoteis hoteis = new Hoteis();
                    Endereco endereco = new Endereco();

                    System.out.println("Digite o nome do hotel: ");
                    String nomeHotel = scanner.next();
                    enderecoService.listarEndereco();
                    System.out.println("Digite o indice do endereco: ");
                    Integer indexEndereco = scanner.nextInt();
                    hoteis.setNome(nomeHotel);
                    endereco.setId_endereco(indexEndereco);
                    hoteis.setEndereco(endereco);
                    hoteisService.editarHotel(indiceHotel, hoteis);
                    break;
                }
                case 8: { //removerHotel
                    hoteisService.listarHoteis();
                    System.out.println("Digite o índice do Hotel: ");
                    Integer indexHotel = scanner.nextInt();
                    reservaService.removerReservaPorHotel(indexHotel);
                    hoteisService.removerHotel(indexHotel);
                    break;
                }
            }
        }
    }
}










