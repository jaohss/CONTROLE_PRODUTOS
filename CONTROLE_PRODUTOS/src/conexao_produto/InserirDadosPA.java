package conexao_produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirDadosPA {
    
        public void inserirDados(){//Método para a inserção de dados
            Connection conexao = ConexaoBD.conectar();
            if(conexao != null){
                String sql = "INSERT INTO produtoa(nome, preco_custo, preco_venda, data_val, info_nutri) VALUES(?, ?, ?, ?, ?)";

                try(PreparedStatement stmt = conexao.prepareStatement(sql)){
    
                    //Fazendo a inserção de dados
                    stmt.setString(1, "Farofa");
                    stmt.setDouble(2, 5.99);
                    stmt.setDouble(3, 20.99);
                    stmt.setString(4,"10/04/2012");
                    stmt.setString(5, "Muito sódio adicionado");
                    stmt.executeUpdate();

                    stmt.setString(1, "Chocolate");
                    stmt.setDouble(2, 1.99);
                    stmt.setDouble(3, 13.99);
                    stmt.setString(4,"12/02/2020");
                    stmt.setString(5, "Muito açúcar adicionado");
                    stmt.executeUpdate();

                    stmt.setString(1, "Coca Cola");
                    stmt.setDouble(2, 0.99);
                    stmt.setDouble(3, 8.99);
                    stmt.setString(4,"31/08/1980");
                    stmt.setString(5, "Muito sódio e açucar adicionado");
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