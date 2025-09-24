package bookstore.Repository;

import bookstore.DTO.BookQueryDslDto;
import bookstore.Entity.Book;
import bookstore.Entity.QBook;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.ArrayList;
import java.util.List;


public class BookRepositoryImpl implements BookRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    public static QBook qBook = QBook.book;


    @Override
    public List<Book> getBooksByQueryDsl(Integer year) {

        JPAQuery<Book> jpaQuery = new JPAQuery<>(em);


//        List<Tuple> tuples = jpaQuery
//                .select(qBook.id, qBook.bookType)
//                .from(qBook)
//                .where(qBook.yearOfPublication.eq(year))
//                .fetch();
//
//        List<Book> books = new ArrayList<>();
//
//        for(Tuple eachTuple : tuples) {
//            Book book = new Book();
//            book.setId(eachTuple.get(qBook.id));
//            book.setBookType(eachTuple.get(qBook.bookType));
//
//            books.add(book);
//        }
        QBean<Book> qBean = Projections.bean(Book.class,qBook.bookType,qBook.id);

        List<Book> books=jpaQuery
                .select(qBean)
               .from(qBook)
               .where(qBook.yearOfPublication.eq(year))
               .fetch();

        return books;
    }

    @Override
    public List<BookQueryDslDto> getBooksByQueryDslDto(Integer year) {

        JPAQuery<Book> jpaQueryDto= new JPAQuery<>(em);

        QBean<BookQueryDslDto> qBeanQuery = Projections.bean(BookQueryDslDto.class,qBook.bookType.as("type"),qBook.id);

        List<BookQueryDslDto> bookQueryDslDtos = jpaQueryDto
                .select(qBeanQuery)
                .from(qBook)
                .where(qBook.yearOfPublication.eq(year))
                .fetch();


        return bookQueryDslDtos;
    }
}
