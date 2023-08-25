package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private static final String DATABASE = "jdbc:mysql://localhost:3306/db_biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection createConnectionMYSQL() throws Exception {
        //Criando conexao com o banco
        Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection connection = createConnectionMYSQL();

        if (connection != null){
            System.out.println("Conexão feita com sucesso!");
            connection.close();
        }
    }


}
