package bookstore.Repository;

import bookstore.DTO.BookQueryDslDto;
import bookstore.Entity.Book;

import java.util.List;

public interface BookRepositoryCustom {

    public List<Book> getBooksByQueryDsl(Integer year);

    public List<BookQueryDslDto> getBooksByQueryDslDto(Integer year);

}
