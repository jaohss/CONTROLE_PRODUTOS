package DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import app.ProdutoVestuarioo;
import conexao.Conexao;

public class ProdutoVestuarioDAO {

    //MÉTODO QUE CADASTRA UM NOVO PRODUTO ADE VESTUARIO NO BANCO DE DADOS
    public void cadastrarVestuario(ProdutoVestuarioo pv){//FAZ UM NOVO INSERT DE REGISTROS NA TABELA produtos_vestuario NO BANCO DE DADOS
        String sql = "INSERT INTO produtos_vestuario(preco_custo, preco_venda, tamanho, material, cor, nome) VALUES(?, ?, ?, ?,?, ?)";

        PreparedStatement ps = null;
        try {
            //FAZ A CONEXÃO COM O BANCO DE DADOS
            ps = Conexao.getConexao().prepareStatement(sql);
            //DEFINIÇÃO DOS VALORES DOS REGISTRO NO SQL
            ps.setDouble(1, pv.getPreco_custo());
            ps.setDouble(2, pv.getPreco_venda());
            ps.setString(3, pv.getTamanho());
            ps.setString(4, pv.getMaterial());
            ps.setString(5, pv.getCor());
            ps.setString(6, pv.getNome());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //MÉTODO PARA DELETAR REGISTRO DO BANCO DE DADOS PELO ID
    public void deletarVestuario(int id_vestuario) {
        //SQL PARA DELETAR UM REGISTRO DO BANCO DE DADOS PELO ID
        String sql = "DELETE FROM produtos_vestuario WHERE id_vestuario = ?";

        //FAZ A CONEXÃO COM O BANCO DE DADOS
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, id_vestuario);//DEFINIÇÃO DO ID PARA DELETE NO BANCO DE DADOS
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //MÉTODO QUE ATUALIZA REGISTRO NO BANCO DE DADOS PELO ID
    public void atualizarVestuario(ProdutoVestuarioo pv) {
         //SQL PARA ATUALIZAR UM REGISTRO DO BANCO DE DADOS PELO ID
        String sql = "UPDATE produtos_vestuario SET preco_custo = ?, preco_venda = ?, tamanho = ?, material = ?, cor = ?, nome = ? WHERE id_vestuario = ?";

        //FAZ A CONEXÃO COM O BANCO DE DADOS
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setDouble(1, pv.getPreco_custo());
            ps.setDouble(2, pv.getPreco_venda());
            ps.setString(3, pv.getTamanho());
            ps.setString(4, pv.getMaterial());
            ps.setString(5, pv.getCor());
            ps.setString(6, pv.getNome());
            ps.setInt(7, pv.getCodigo());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}