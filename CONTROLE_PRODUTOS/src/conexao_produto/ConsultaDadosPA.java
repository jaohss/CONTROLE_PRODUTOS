package conexao_produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultaDadosPA {
    //Método para consulta de dados
    public void consultaDados() {
        Connection conexao = ConexaoBD.conectar();
        if(conexao != null){
            String sql = "SELECT * FROM produtoa"; //sintaxe seletora para consulta de todos os itens do banco de dados
            try{
                PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                System.out.println("Registros da tabela 'produtoa':");
                while(rs.next()){
                    //definição das variáveis que serão consultadas
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    double preco_custo = rs.getDouble("preco_custo");
                    double preco_venda = rs.getDouble("preco_venda");
                    String data_val = rs.getString("data_val");
                    String info_nutri = rs.getString("info_nutri");
                    
                    //Exibe a consulta do banco de dados
                    System.out.println("ID: "+ id + ", Nome: " + nome + ", Preço de custo: "+preco_custo + ", Preço de venda: "+preco_venda+ ", Data de validade:" + data_val + ", Informações nutricionais: "+info_nutri);
                }
            }catch (SQLException e){
                System.err.println("Erro ao ler dados: " + e.getMessage());
            } finally{
                try{
                    if(conexao != null) conexao.close();
                }catch (SQLException e){
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        } 
    }
}
