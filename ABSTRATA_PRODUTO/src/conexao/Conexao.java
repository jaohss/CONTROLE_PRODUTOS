package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//CLASSE DE CONEXÃO COM BANCO DE DADOS
public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/produtos";
    private static final String user = "root";
    private static final String password = "12345"; 

    private static Connection conn;

    public static Connection getConexao(){
        try {
            if(conn == null){//SE A CONEXÃO FOR ESTABELECIDA SERÁ EXIBIDA ESSA MENSAGEM
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão estabelecida com sucesso!");
                return conn;
            } else {
                return conn;
            } 
        } catch (SQLException e) {  
            System.err.println("Erro ao estabelecer conexão: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}




