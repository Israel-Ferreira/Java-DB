package dao.Livros;

import java.sql.SQLException;
import java.util.List;

public interface ICrud {
    <T> List<T> getAll();
    <T>  T getById(int id);
    boolean delete(int id);
    <T> T create(Class<T> obj) throws SQLException;
}
