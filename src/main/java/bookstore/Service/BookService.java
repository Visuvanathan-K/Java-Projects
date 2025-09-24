package bookstore.Service;

import bookstore.Common.ApiResponse;
import bookstore.Common.BadRequestException;
import bookstore.Common.Error;
import bookstore.DTO.AuthorDTO;
import bookstore.DTO.BookDTO;
import bookstore.DTO.BookQueryDslDto;
import bookstore.DTO.BookRequestDto;
import bookstore.Data.BookData;
import bookstore.Entity.Author;
import bookstore.Entity.Book;
import bookstore.Entity.bookAuthor;
import bookstore.Repository.BookAuthorRepository;
import bookstore.Repository.BookRepository;
import bookstore.Validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Autowired
    private BookValidator bookValidator;

    //GET
    public List<Book> getBooks(Set<Integer> yop,String bookType){
        List<Book> bookList= new ArrayList<>();

        if(yop ==null){
            bookRepository.findAll().forEach(book -> bookList.add(book) );
        } else {
            return bookRepository.findAllByYearOfPublicationInAndBookType(yop,bookType);
        }

        return bookList;
    }

    //Post
    public Book createBooks(Book book) {

        //validate
       List<Error> errors = bookValidator.validateNameRequest(book);
        //if sucess
      if(errors.size() > 0) {
          throw new BadRequestException("message",errors);
      }
      return bookRepository.save(book);}



    public BookDTO getBookId(Long bookId,boolean authorData) {
        Book book;
        List<bookAuthor> bookAuhors=null;
        book = bookRepository.findById(bookId).orElse(null);
        if(authorData){
            bookAuhors = bookAuthorRepository.findByBook_Id(bookId);
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setDesc(book.getDesc());
        bookDTO.setDesc(book.getDesc());
        bookDTO.setYearOfPublication(book.getYearOfPublication());
        bookDTO.setBookType(book.getBookType());


        List<AuthorDTO> authorDTOList = new ArrayList<>();
        if(bookAuhors!=null) {
            for (bookAuthor bookAuthor : bookAuhors) {

                Author author = bookAuthor.getAuthor();

                AuthorDTO authorDTO = new AuthorDTO();
                authorDTO.setId(author.getId());
                authorDTO.setName(author.getName());
                authorDTO.setGender(author.getGender());

                authorDTOList.add(authorDTO);
            }

            bookDTO.setAuthors(authorDTOList);
        }
        return bookDTO;
    }

    public Book updateBooks(Book incomingBooks) {
        return bookRepository.save(incomingBooks);
    }

    public String deleteBooks(Long bookId) {
        bookRepository.deleteById(bookId);

        return "Book Deleted Successfully";}

    public ApiResponse getRawQuery(Set<Integer> yop) {

        ApiResponse apiResponse = new ApiResponse();

        List<Book> bookList =bookRepository.findAllByYearOfPublicationIn(yop);

        BookData bookData = new  BookData();
        bookData.setBooks(bookList);

        apiResponse.setData(bookData);
        return apiResponse;
    }

    public ApiResponse CaughtException(Integer yop) {

        int result = 100/yop;
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(result);
        return apiResponse;
    }

    public ApiResponse getQueryDsl(Integer year) {
        ApiResponse response = new ApiResponse();

       // List<Book> bookList = bookRepository.getBooksByQueryDsl(year);

        List<BookQueryDslDto> bookQueryDslDtoList = bookRepository.getBooksByQueryDslDto(year);

        response.setData(bookQueryDslDtoList);
        return response;
    }

    public ApiResponse BulkService(BookRequestDto bookRequestDto) {

        List<Book> bookEntity = new ArrayList<>();
//        bookRequestDto.getBooks().forEach(each->{
//            Book book = new Book();
//
//            book.setBookType(each.getBookType());
//            book.setName(each.getName());
//            book.setDesc(each.getDesc());
//            book.setYearOfPublication(each.getYearOfPublication());
//
//            bookEntity.add(book);
//        });

        for(int i=0;i<100000;i++){
            Book book = new Book();
            book.setName("book-"+i);
            book.setDesc("book-"+i);
            book.setBookType("book-"+i);
            book.setYearOfPublication(2025);

            bookEntity.add(book);


        }

        bookRepository.saveAll(bookEntity);

        return new ApiResponse();
    }
}
