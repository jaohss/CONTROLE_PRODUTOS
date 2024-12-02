package conexao_produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirDadosPV {
    public void inserirDados(){//Método para a inserção de dados
            Connection conexao = ConexaoBD.conectar();
            if(conexao != null){
                String sql = "INSERT INTO produtov(nome, cor, material, tamanho, preco_custo, preco_venda) VALUES(?, ?, ?, ?, ?, ?)";

                try(PreparedStatement stmt = conexao.prepareStatement(sql)){
    
                    //Fazendo a inserção de dados
                    stmt.setString(1, "Camisa do corinthians");
                    stmt.setString(2, "Preto e branco");
                    stmt.setString(3, "Algodão");
                    stmt.setString(4, "GG");
                    stmt.setDouble(2, 50.99);
                    stmt.setDouble(3, 150.99);
                    
                    stmt.executeUpdate();

                    stmt.setString(1, "Camisa do Brasil");
                    stmt.setString(2, "Amarelo e verda");
                    stmt.setString(3, "Algodão");
                    stmt.setString(4, "PP");
                    stmt.setDouble(2, 65.99);
                    stmt.setDouble(3, 450.89);
                    stmt.executeUpdate();

                    stmt.setString(1, "Camisa do Flamengo");
                    stmt.setString(2, "Preto e vermelho");
                    stmt.setString(3, "Algodão");
                    stmt.setString(4, "M");
                    stmt.setDouble(2, 40.89);
                    stmt.setDouble(3, 250.98);
                    stmt.executeUpdate();

                    System.out.println("Dados inseridos com sucesso !");
                    stmt.close();

                } catch (SQLException e){//Mensagem de erro se houver falhas ao inserir dados
                    System.err.println("Erro ao inserir dados: "+e.getMessage());
                }

                finally{
                    try{
                        if(conexao!=null) conexao.close();
                    }catch(SQLException e){
                        System.err.println("Erro ao fechar conexão: "+e.getMessage());
                    }
                }

            }
        
        

    }
    
}
