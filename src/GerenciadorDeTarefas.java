

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class GerenciadorDeTarefas {

    public static void main(String[] args) {

        Scanner join = new Scanner(System.in);

        // Opcoes disponiveis para o menu
        ArrayList<String> opcoesMenu = new ArrayList<>(Arrays.asList(
                "Adicionar",
                "Editar",
                "Listar",
                "Excluir",
                "Concluir",
                "Sair"
                ));
        ArrayList<String> tarefasPendentes = new ArrayList<>(Arrays.asList());
        ArrayList<String> tarefasConcluidas = new ArrayList<>(Arrays.asList());
        int opc = 0;
        String entrada;


        /*
            MENU - Opçoes
         */
        do {
            System.out.println("*=*=*= GERENCIADOR DE TAREFAS =*=*=*");

            // Lista as opções do MENU
            for (int i = 0; i < opcoesMenu.size(); i++) {

                System.out.printf("%d. %S\n", i+1, opcoesMenu.get(i));

            }

            // Solicita a opção para interagir com a lista
            System.out.print("Opcao: ");
            opc = join.nextInt();
            entrada = join.nextLine(); //Limpeza de buffer


            switch (opc) {

                // Adicionar Tarefa
                case 1:
                    System.out.print("Nome da Tarefa para adicionar: ");
                    entrada = join.nextLine();


                    if (!tarefasPendentes.contains(entrada)) {

                        tarefasPendentes.add(entrada);
                        System.out.println("Tarefa adicionada com sucesso!");

                    } else {
                        System.out.println("ERROR[XXX]: Tarefa já presente!");
                    }
                    break;

                // Editar
                case 2:

                    if (!tarefasPendentes.isEmpty()) {

                        System.out.println("-- Lista das Tarefas Pendentes --");
                        for (int i = 0; i < tarefasPendentes.size(); i++) {
                            System.out.printf("%dº %s\n", i+1, tarefasPendentes.get(i));
                        }

                        System.out.print("Nome da Tarefa para editar: ");
                        entrada = join.nextLine();;

                        if (tarefasPendentes.contains(entrada)) {

                            System.out.print("Novo nome da tarefa: ");
                            String novaEntrada = join.nextLine();
                            int pos = tarefasPendentes.indexOf(entrada);
                            tarefasPendentes.set(pos, novaEntrada);
                            System.out.println("Editado com sucesso!");

                        } else {
                            System.out.println("ERROR[XXX]: Tarefa NÃO localizada!");
                        }
                    } else {
                        System.out.println("Lista VAZIA!");
                    }



                    break;

                // Listar os dois status de tarefas
                case 3:

                    System.out.println("1. Tarefas Pendentes");
                    System.out.println("2. Tarefas Concluidas");
                    System.out.print("Escolha: ");
                    entrada = join.nextLine();;

                    if (entrada.equals("1")) {
                        if (!tarefasPendentes.isEmpty()) {
                            System.out.println("-- Lista das Tarefas Pendentes --");
                            for (int i = 0; i < tarefasPendentes.size(); i++) {
                                System.out.printf("%dº %s\n", i+1, tarefasPendentes.get(i));
                            }
                        } else {
                            System.out.println("Lista VAZIA!");
                        }
                        break;
                    } else if (entrada.equals("2")) {
                        if (!tarefasConcluidas.isEmpty()) {
                            System.out.println("=== Lista das Tarefas Concluidas ===");
                            for (int i = 0; i < tarefasConcluidas.size(); i++) {
                                System.out.printf("%dº %s\n", i+1, tarefasConcluidas.get(i));
                            }
                        } else {
                            System.out.println("Lista VAZIA!");
                        }
                        break;
                    }


                // Excluir tarefas
                case 4:

                    System.out.println("1. Tarefas Pendentes");
                    System.out.println("2. Tarefas Concluidas");
                    System.out.print("Escolha: ");
                    entrada = join.nextLine();;

                    if (entrada.equals("1")) {

                        if (!tarefasPendentes.isEmpty()){
                            System.out.println("-- Lista das Tarefas Pendentes --");
                            for (int i = 0; i < tarefasPendentes.size(); i++){
                                System.out.printf("%dº %s\n", i+1, tarefasPendentes.get(i));
                            }
                            System.out.print("Nome para excluir: ");
                            entrada = join.nextLine();;

                            if (tarefasPendentes.contains(entrada)) {

                                tarefasPendentes.remove(entrada);
                                System.out.println("Tarefa Excluida com sucesso.");

                            } else {
                                System.out.println("ERROR[XXX]: Tarefa NÃO localizada!");

                            }
                        } else {
                            System.out.println("Lista VAZIA!");
                        }



                    } else if (entrada.equals("2")) {

                        if (!tarefasConcluidas.isEmpty()) {
                            System.out.println("-- Lista das Tarefas Concluidas --");
                            for (int i = 0; i < tarefasConcluidas.size(); i++){
                                System.out.printf("%dº %s\n", i+1, tarefasConcluidas.get(i));
                            }
                            System.out.print("Nome para excluir: ");
                            entrada = join.nextLine();;

                            if (tarefasConcluidas.contains(entrada)) {

                                tarefasConcluidas.remove(entrada);
                                System.out.println("Tarefa Excluida com sucesso.");

                            } else {
                                System.out.println("ERROR[XXX]: Tarefa NÃO localizada!");

                            }
                        } else {
                            System.out.println("Lista VAZIA!");
                        }



                    }


                    break;

                // Concluir
                case 5:

                    if (!tarefasPendentes.isEmpty()) {
                        System.out.println("-- Lista das Tarefas Pendentes --");
                        for (int i = 0; i < tarefasPendentes.size(); i++){
                            System.out.printf("%dº %s\n", i+1, tarefasPendentes.get(i));
                        }
                        System.out.print("Nome da Tarefa para Concluir: ");
                        entrada = join.nextLine();;
                        if (tarefasPendentes.contains(entrada)) {

                            System.out.printf("Selecionado: %S\n", entrada);
                            System.out.print("Deseja Concluir a tarefa?[S] ou [N]: ");
                            String confirmar = join.next().toLowerCase();

                            if (confirmar.equals("s")) {
                                tarefasPendentes.remove(entrada);
                                tarefasConcluidas.add(entrada);
                                System.out.println("Tarefa concluida com sucesso!");
                            } else {
                                System.out.println("Operação Cancelada");
                            }

                        } else {

                            System.out.println("ERROR[XXX]: Tarefa NÃO localizada!");

                        }
                    } else {
                        System.out.println("Lista VAZIA!");
                    }


                    break;


            }

        } while (opc != 6);

    }

}
