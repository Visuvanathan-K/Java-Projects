package bookstore.Validator;

import bookstore.Common.Error;
import bookstore.Entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookValidator {
    public List<Error> validateNameRequest(Book book) {

        List<Error> errors = new ArrayList<>();

        //name
        if(book.getName() == null){
            Error error = new Error("name","Book name is required");
            errors.add(error);
        }
        //yop
        if(book.getYearOfPublication() == null){
            Error error = new Error("yearOfPublication","Book year is required");
            errors.add(error);

        }
        //booktype
        if(book.getBookType() == null){
            errors.add(new Error("bookType","Book type is required"));
        }
        return errors;
    }
}
