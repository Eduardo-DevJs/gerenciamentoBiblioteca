package LivroBiblioteca;
import conexao.Conexao;
import entidade.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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

    public List<Livro> getLivros(){
        String sql = "SELECT * FROM livros";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        List<Livro> livros = new ArrayList<Livro>();

        // Classe que vai recuperar os dados do banco *** SELECT ***
        ResultSet resultSet = null;

        try{
            connection = Conexao.createConnectionMYSQL();
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Livro livro = new Livro();

                livro.setId_livro(resultSet.getInt("id_livro"));
                livro.setTitulo(resultSet.getString("titulo"));
                livro.setAutor(resultSet.getString("autor"));
                livro.setAno_publicacao(resultSet.getInt("ano_publicacao"));

                livros.add(livro);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(connection == null){
                    connection.close();
                }

                if(preparedStatement == null){
                    preparedStatement.close();
                }

                if(resultSet == null){
                    resultSet.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return livros;
    }

    public void atualizarLivros(Livro livro){
        String sql = "UPDATE livros SET titulo=?, autor=?, ano_publicacao=? WHERE id_livro=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Conexao.createConnectionMYSQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setInt(3, livro.getAno_publicacao());

            preparedStatement.setInt(4, livro.getId_livro());

            preparedStatement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deletarLivro(int id){
        String sql = "DELETE FROM livros WHERE id_livro = ? ";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
           connection = Conexao.createConnectionMYSQL();
           preparedStatement = connection.prepareStatement(sql);

           preparedStatement.setInt(1, id);

           preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(preparedStatement != null){
                    preparedStatement.close();
                }

                if(connection != null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
