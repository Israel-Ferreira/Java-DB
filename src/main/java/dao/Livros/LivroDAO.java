package dao.Livros;


import dao.ObjectDAO;
import models.livros.Livro;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO extends ObjectDAO implements ILivro {

    public LivroDAO(String url){
        createConnection(url);
    }


    public List<Livro> getAll() {
        List<Livro> livros = new ArrayList<>();
        String sql ="SELECT * FROM livros";
        try{
            setRes(sql);

            while(res.next()){
                Livro livro =  new Livro();
                livro.setTitulo(res.getString("titulo"));
                livros.add(livro);
            }
        }catch(SQLException e){
            System.err.println(e);
        }

        return livros;
    }


    public Livro getById(int id) {
        String sql =  "SELECT * FROM Livros WHERE id="+id;
        Livro livro = null;

        try{
            setRes(sql);
            livro = (Livro) res.getObject(0);
        }catch (Exception e){
            System.err.println(e);
        }

        return livro;
    }


    public boolean delete(int id) {
        String sql = "DELETE FROM Livros WHERE id="+id;
        boolean isDeleted = false;

        try{
            setRes(sql);
            isDeleted = true;
        }catch(Exception e){
            System.err.println(e);
        }

        return isDeleted;
    }

    @Override
    public <T> T create(Class<T> obj) throws SQLException {
        return null;
    }


    public Livro create(Livro livro) throws SQLException {
        String sql = "INSERT INTO Livros VALUES (" + livro.getId() + ", " + livro.getTitulo() + ", " + livro.getAutor() + ", " + livro.getIsbn() + ")";
        Livro livro1 =  new Livro();

        try{
            setRes(sql);
            livro1.setTitulo(res.getString("titulo"));
        }catch (SQLException e){
            throw  e;
        }
        return livro;
    }

    public Livro update(int id, Livro livro) throws SQLException {
        String sql = "UPDATE Livros SET id=" + livro.getId() + ", titulo=" + livro.getTitulo() + ", autor=" +livro.getAutor() + ", isbn=" + livro.getIsbn();
        Livro livro1 = null;

        try{
            setRes(sql);
            livro1 = getById(id);
        }catch (SQLException e){
            throw e;
        }


        return livro1;
    }
}
