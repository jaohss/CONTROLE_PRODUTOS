package conexao_produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoverDadosPV {
     public void removerDados() {//Método para remover dados
        Connection conexao = ConexaoBD.conectar();
        if(conexao != null){
            String sql = "DELETE FROM produtov WHERE id = ?";
            Scanner scn = new Scanner(System.in);
            try{
                //Recebe qual id do produto deseja remover
                System.out.println("Digite o ID do produto vestuario que deseja deletar: ");
                int id = scn.nextInt();

                PreparedStatement stmt =  conexao.prepareStatement(sql);
                stmt.setInt(1, id);

                int rowsDeleted = stmt.executeUpdate();

                if(rowsDeleted > 0){
                    System.out.println("Registro deletado com sucesso");
                }
                else{
                    System.out.println("Nenhum registro encontrado com ID especificado");
                }

            }catch(SQLException e){//Mensagem de erro da remoção de dados caso haja falhas
                System.err.println("Erro ao deletar dados: " + e.getMessage());
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
