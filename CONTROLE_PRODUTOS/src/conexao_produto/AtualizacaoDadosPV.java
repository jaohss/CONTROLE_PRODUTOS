package conexao_produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizacaoDadosPV {
    public void atualizarDados() {//Método para atualizar os dados
        Connection conexao = ConexaoBD.conectar();
        if(conexao != null){
            String sql = "UPDATE produtov SET nome = ?, cor = ?, material = ?, tamanho = ?, preco_custo = ?, preco_venda = ? WHERE id = ?";
            Scanner scn = new Scanner(System.in);
            try{
                System.out.println("Digite o ID do produto de vestuario que deseja atualizar: ");
                int id = scn.nextInt();//recebe qual id do produto de vestuario que deseja atualizar
                scn.nextLine();

                System.out.println("Digite o novo nome do produto de vestuario: ");
                String nome = scn.nextLine();//recebe o nome do novo produto

                System.out.println("Digite a nova cor do produto de vestuario: ");
                String cor = scn.nextLine();//recebe o novo preço custo do produto vestuario

                System.out.println("Digite o novo material do produto de vestuario: ");
                String material = scn.nextLine();//recebe o novo preço custo do produto de vestuario

                System.out.println("Digite o novo tamanho do produto de vestuario: ");
                String tamanho = scn.nextLine();//recebe o novo tamanho do produto de vestuario

                System.out.println("Digite o novo preço de custo do produto vestuario: ");
                double preco_custo = scn.nextDouble();//recebe  novo preço de custo do produto vestuario

                System.out.println("Digite o novo preço de venda do produto vestuario: ");
                double preco_venda = scn.nextDouble();//recebe  novo preço de venda do produto vestuario

                PreparedStatement stmt =  conexao.prepareStatement(sql);//definindo a ordem das variaveis de acordo com a string sql
                stmt.setString(1, nome);
                stmt.setString(2, cor);
                stmt.setString(3, material);
                stmt.setString(4, tamanho);
                stmt.setDouble(5, preco_custo);
                stmt.setDouble(6, preco_venda);
                stmt.setInt(7, id);

                int rowsUpdated = stmt.executeUpdate();

                if(rowsUpdated > 0){
                    System.out.println("Registro atualizado com sucesso !");
                }
                else{
                    System.out.println("Nenhum registro encontrado com ID especificado");
                }

            }catch(SQLException e){//Erro se houver falha ao atualizar os dados
                System.err.println("Erro ao atualizar dados dados: " + e.getMessage());
            } finally{
                try{
                    if (conexao !=null) conexao.close();
                } catch(SQLException e){
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
                scn.close();
            }
        }
    }
}
