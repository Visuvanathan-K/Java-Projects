package bookstore.Controller;

import bookstore.Common.ApiResponse;
import bookstore.DTO.BookDTO;
import bookstore.DTO.BookRequestDto;
import bookstore.Entity.Book;
import bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books")
    public List<Book> getBooks(@RequestParam(value = "yearOfPublications", required = false) Set<Integer> yop,
                               @RequestParam(value = "bookType", required = false) String bookType) {
        return bookService.getBooks(yop,bookType);
    }

    @RequestMapping(value="/books", method = RequestMethod.POST)
    public Book createBooks(@RequestBody Book book){
        return bookService.createBooks(book);}

    @RequestMapping(value = "/books/{id}")
    public BookDTO getBookId(@PathVariable("id") Long bookId,
                             @RequestParam(value = "authorData",required = false)boolean authorData){
        return bookService.getBookId(bookId,authorData);}

    @RequestMapping(value = "/books",method = RequestMethod.PUT)
    public Book updateBooks(@RequestBody Book incomingBooks){
        return bookService.updateBooks(incomingBooks);}

    @RequestMapping(value = "/books/{id}",method = RequestMethod.DELETE)
    public String deleteBooks(@PathVariable("id") Long bookId){
        return bookService.deleteBooks(bookId);}

    @GetMapping("/raw/books")
    public ApiResponse getRawQuery(@RequestParam(value = "yop") Set<Integer> yop){
        return bookService.getRawQuery(yop);
    }
    @GetMapping("CaughtException")
    public ApiResponse CaughtException(@RequestParam(value = "number") Integer yop){
        return bookService.CaughtException(yop);
    }

    @GetMapping("/queryDsl/books")
    public ApiResponse getQueryDsl(@RequestParam(value = "year") Integer year){
        return bookService.getQueryDsl(year);
    }

    @PostMapping("/bulkBooks")
    public ApiResponse bulkBooks(@RequestBody BookRequestDto  bookRequestDto){
        return bookService.BulkService(bookRequestDto);
    }



}
