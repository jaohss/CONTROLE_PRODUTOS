package conexao_produto;

//importando package SQL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizacaoDadosPA {
    public void atualizarDados() {//Método para atualizar os dados
        Connection conexao = ConexaoBD.conectar();
        if(conexao != null){
            String sql = "UPDATE produtoa SET nome = ?, preco_custo = ?, preco_venda = ?, data_val = ?, info_nutri = ? WHERE id = ?";
            Scanner scn = new Scanner(System.in);
            try{
                System.out.println("Digite o ID do produto alimenticio que deseja atualizar: ");
                int id = scn.nextInt();//recebe qual id do produto que deseja atualizar
                scn.nextLine();

                System.out.println("Digite o novo nome do produto alimenticio: ");
                String nome = scn.nextLine();//recebe o nome novo do produto

                System.out.println("Digite o novo preço de custo do produto alimenticio: ");
                double preco_custo = scn.nextInt();//recebe o novo preço custo do produto alimenticio

                System.out.println("Digite o novo preço de venda do produto alimenticio: ");
                double preco_venda = scn.nextInt();//recebe o novo preço custo do produto alimenticio

                System.out.println("Digite o nova data de validade do produto alimenticio: ");
                String data_val = scn.nextLine();//recebe a nova data de validade do produto alimenticio

                System.out.println("Digite as novas informações nutricionais do produto alimenticio: ");
                String info_nutri = scn.nextLine();//recebe a nova informação nutricional do produto alimenticio

                PreparedStatement stmt =  conexao.prepareStatement(sql);//definindo a ordem das variaveis de acordo com a string sql
                stmt.setString(1, nome);
                stmt.setDouble(2, preco_custo);
                stmt.setDouble(3, preco_venda);
                stmt.setString(4, data_val);
                stmt.setString(5, info_nutri);
                stmt.setInt(6, id);

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
