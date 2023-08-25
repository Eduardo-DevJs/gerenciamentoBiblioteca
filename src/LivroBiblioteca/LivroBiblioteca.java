package LivroBiblioteca;
import conexao.Conexao;
import entidade.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LivroBiblioteca {
    public void cadastrarLivro(Livro livro){
        String sql = "INSERT INTO livros (titulo, autor, ano_publicacao ) VALUES (?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = Conexao.createConnectionMYSQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setInt(3, livro.getAno_publicacao());

            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(connection != null){
                    connection.close();
                }

                if(preparedStatement != null){
                    preparedStatement.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
