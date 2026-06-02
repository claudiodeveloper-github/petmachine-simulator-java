import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.nanoTime() > 0 ? System.in : null); // Inicialização segura do Scanner
        PetMachine machine = new PetMachine();
        int opcao = -1;

        System.out.println("=======================================");
        System.out.println("  SISTEMA DE CONTROLE DE BANHO - v1.0  ");
        System.out.println("=======================================");

        while (opcao != 0) {
            System.out.println("\n--- MENU DE OPERAÇÕES ---");
            System.out.println("1. Colocar pet na máquina");
            System.out.println("2. Dar banho no pet");
            System.out.println("3. Retirar pet da máquina");
            System.out.println("4. Abastecer Água (+2L)");
            System.out.println("5. Abastecer Shampoo (+2L)");
            System.out.println("6. Verificar nível de Água");
            System.out.println("7. Verificar nível de Shampoo");
            System.out.println("8. Verificar se há pet na máquina");
            System.out.println("9. Limpar máquina");
            System.out.println("10. Exibir Relatório do Petshop");
            System.out.println("0. Sair do programa");
            System.out.print("Escolha uma opção: ");

            // Validação para evitar que o programa quebre se o usuário digitar uma letra
            if (!scanner.hasNextInt()) {
                System.out.println(" Erro: Por favor, digite um número válido!");
                scanner.next(); // Descarta a entrada inválida
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            System.out.println(); // Salta uma linha para organizar visualmente

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do pet: ");
                    String nomePet = scanner.nextLine();
                    if (nomePet.trim().isEmpty()) {
                        System.out.println(" Erro: O nome do pet não pode ser vazio.");
                    } else {
                        Pet novoPet = new Pet(nomePet);
                        machine.putPet(novoPet);
                    }
                    break;
                case 2:
                    machine.takeShower();
                    break;
                case 3:
                    machine.removePet();
                    break;
                case 4:
                    machine.refillWater();
                    break;
                case 5:
                    machine.refillShampoo();
                    break;
                case 6:
                    machine.checkWaterLevel();
                    break;
                case 7:
                    machine.checkShampooLevel();
                    break;
                case 8:
                    machine.checkPetInMachine();
                    break;
                case 9:
                    machine.cleanMachine();
                    break;
                case 10:
                    machine.exibirRelatorioGeral();
                    break;
                case 0:
                    System.out.println(" Encerrando o sistema. Até mais!");
                    break;
                default:
                    System.out.println(" Opção inválida! Escolha um número de 0 a 10.");
                    break;
            }
        }
        scanner.close();
    }
}