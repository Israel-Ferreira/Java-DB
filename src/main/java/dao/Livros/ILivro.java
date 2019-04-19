package dao.Livros;

import models.livros.Livro;

import java.sql.SQLException;
import java.util.List;

public interface ILivro extends ICrud{
    List<Livro> getAll();
    Livro getById(int id);


    Livro create(Livro obj) throws SQLException;

    Livro update(int id, Livro livro) throws SQLException;


}
