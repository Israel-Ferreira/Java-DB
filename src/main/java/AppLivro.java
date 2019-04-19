import dao.Livros.LivroDAO;
import models.livros.Livro;


import java.util.List;

public class AppLivro {
    public static void main(String[] args) {
        LivroDAO livroDAO = new LivroDAO("postgres");

        List<Livro> livros = livroDAO.getAll();

        for (Object livro: livros) {
            Livro  book = (Livro) livro;
            System.out.println(book.getTitulo());
        }
    }
}
