package DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import app.ProdutoAlimenticioo;
import conexao.Conexao;;

public class ProdutoAlimenticiooDAO {

    //MÉTODO QUE CADASTRA UM NOVO PRODUTO ALIMENTICIO NO BANCO DE DADOS
    public void cadastrarAlimento(ProdutoAlimenticioo pa){//FAZ UM NOVO INSERT DE REGISTROS NA TABELA produto_alimenticios NO BANCO DE DADOS
        String sql = "INSERT INTO produto_alimenticio(preco_custo, preco_venda, data_val, info_nutri, nome) VALUES(?, ?, ?, ?,?)";

        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);//FAZ A CONEXÃO COM O BANCO DE DADOS
            //DEFINIÇÃO DOS VALORES DOS REGISTRO NO SQL
            ps.setDouble(1, pa.getPreco_custo());
            ps.setDouble(2, pa.getPreco_venda());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(pa.getData_val(), formatter);
            ps.setDate(3, java.sql.Date.valueOf(data));
            ps.setString(4, pa.getInfo_nutri());
            ps.setString(5, pa.getNome());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //MÉTODO PARA DELETAR REGISTRO DO BANCO DE DADOS PELO ID
    public void deletarAlimento(int id_alimento) {
        //SQL PARA DELETAR UM REGISTRO DO BANCO DE DADOS PELO ID
        String sql = "DELETE FROM produto_alimenticio WHERE id_alimento = ?";

        //FAZ A CONEXÃO COM O BANCO DE DADOS
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, id_alimento);//DEFINIÇÃO DO ID PARA DELETE NO BANCO DE DADOS
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //MÉTODO QUE ATUALIZA REGISTRO NO BANCO DE DADOS PELO ID
    public void atualizarAlimento(ProdutoAlimenticioo pa) {
        //SQL PARA ATUALIZAR UM REGISTRO DO BANCO DE DADOS PELO ID
        String sql = "UPDATE produto_alimenticio SET preco_custo = ?, preco_venda = ?, data_val = ?, info_nutri = ?, nome = ? WHERE id_alimento = ?";

        //FAZ A CONEXÃO COM O BANCO DE DADOS
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            //DEFINIÇÃO DOS VALORES DE REGISTRO PARA ATUALIZAR NO BANCO DE DADOS
            ps.setDouble(1, pa.getPreco_custo());
            ps.setDouble(2, pa.getPreco_venda());

            // Converter a data para o formato YYYY-MM-DD
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(pa.getData_val(), formatter);
            ps.setDate(3, java.sql.Date.valueOf(data));
            ps.setString(4, pa.getInfo_nutri());
            ps.setString(5, pa.getNome());
            ps.setInt(6, pa.getId_alimento());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
