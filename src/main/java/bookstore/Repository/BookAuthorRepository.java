package bookstore.Repository;

import bookstore.Entity.bookAuthor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookAuthorRepository extends CrudRepository<bookAuthor,Long> {
    List<bookAuthor> findByBook_Id(Long bookId);

}
