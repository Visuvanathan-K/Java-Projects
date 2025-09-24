package bookstore.Service;

import bookstore.Common.ApiResponse;
import bookstore.Common.PaginationMeta;
import bookstore.Data.AuthorData;
import bookstore.Entity.Author;
import bookstore.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public ApiResponse getAuthor(Pageable pageable) {
        ApiResponse apiResponse = new ApiResponse();
         Page<Author> authorsPage = authorRepository.findAll(pageable);

         List<Author> authors = authorsPage.getContent();
        PaginationMeta authorsPagination =   PaginationMeta.createpagination(authorsPage);

        AuthorData authorData = new AuthorData();

        authorData.setAuthors(authors);
        authorData.setPagination(authorsPagination);


         apiResponse.setData(authorData);
        return apiResponse;
    }

    public ApiResponse getAuthorNamedQuery(Pageable pageable) {
        ApiResponse apiResponse = new ApiResponse();
        Page<Author> authorsPage = authorRepository.findAllByOrderByIdDesc(pageable);

        List<Author> authors = authorsPage.getContent();
        PaginationMeta authorsPagination =   PaginationMeta.createpagination(authorsPage);

        AuthorData authorData = new AuthorData();

        authorData.setAuthors(authors);
        authorData.setPagination(authorsPagination);


        apiResponse.setData(authorData);
        return apiResponse;
    }
}
