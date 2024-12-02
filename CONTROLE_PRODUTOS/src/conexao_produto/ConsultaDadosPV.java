package conexao_produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaDadosPV {
    //Método para consulta de dados
    public void consultaDados() {
        Connection conexao = ConexaoBD.conectar();
        if(conexao != null){
            String sql = "SELECT * FROM produtov"; //sintaxe seletora para consulta de todos os itens do banco de dados
            try{
                PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                System.out.println("Registros da tabela 'produtov':");
                while(rs.next()){
                    //definição das variáveis que serão consultadas
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String cor = rs.getString("cor");
                    String material = rs.getString("material");
                    String tamanho = rs.getString("tamanho");
                    double preco_custo = rs.getDouble("preco_custo");
                    double preco_venda = rs.getDouble("preco_venda");
                    
                    
                    //Exibe a consulta do banco de dados
                    System.out.println("ID: "+ id + ", Nome: " + nome + ", Cor: "+cor+", material: "+material + ", Tamanho: "+tamanho+ ", Preço de custo:" + preco_custo + ", Preço de venda: "+preco_venda);
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
