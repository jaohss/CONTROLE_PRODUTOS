package app;
import java.util.Scanner;
import conexao_produto.*;

public class Main {
    public static void main(String[] args)  {

        //Instanciando objetos
        Scanner scn = new Scanner(System.in);
        InserirDadosPA ida = new InserirDadosPA();
        RemoverDadosPA rda = new RemoverDadosPA();
        ConsultaDadosPA cda = new ConsultaDadosPA();
        AtualizacaoDadosPA ada = new AtualizacaoDadosPA();

        InserirDadosPV idv = new InserirDadosPV();
        RemoverDadosPV rdv = new RemoverDadosPV();
        ConsultaDadosPV cdv = new ConsultaDadosPV();
        AtualizacaoDadosPV adv = new AtualizacaoDadosPV();

        //Definindo a variável de opção
        int opcao = -1;

        do {//Estrutura de repetição para executar o programa pelo menos uma vez
            System.out.println("=====MENU PRINCIPAL - Produto Alimenticio =====");
            System.out.println("1 - Inserir Produto Alimenticio");
            System.out.println("2 - Atualizar Produto Alimenticio");
            System.out.println("3 - Deletar Produto Alimenticio");
            System.out.println("4 - Ler registros dos produtos alimenticios ");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scn.nextInt();
            scn.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    ida.inserirDados();//chama o método de inserção de dados
                    break;
                case 2:
                    ada.atualizarDados();//chama o método de atualização de dados
                    break;
                case 3:
                    rda.removerDados();//chama o método de remoção de dados
                    break;
                case 4:
                    cda.consultaDados();//chama o método de consulta de dados
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0 && opcao <= 1 && opcao >=4 );
        
        opcao = -1;

        do {//Estrutura de repetição para executar o programa pelo menos uma vez
            System.out.println("=====MENU PRINCIPAL - Produto Vestuario =====");
            System.out.println("1 - Inserir Produto Vestuario");
            System.out.println("2 - Atualizar Produto Vestuario");
            System.out.println("3 - Deletar Produto Vestuario");
            System.out.println("4 - Ler registros dos produtos vestuarios ");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scn.nextInt();
            scn.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    idv.inserirDados();//chama o método de inserção de dados
                    break;
                case 2:
                    adv.atualizarDados();//chama o método de atualização de dados
                    break;
                case 3:
                    rdv.removerDados();//chama o método de remoção de dados
                    break;
                case 4:
                    cdv.consultaDados();//chama o método de consulta de dados
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0 && opcao <= 1 && opcao >=4 );
        scn.close();


    }
}