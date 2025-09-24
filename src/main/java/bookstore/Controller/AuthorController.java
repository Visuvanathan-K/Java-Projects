package bookstore.Controller;

import bookstore.Common.ApiResponse;
import bookstore.DTO.RequestMeta;
import bookstore.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private RequestMeta requestMeta;

    @GetMapping(value = "/authors")
    public ApiResponse getAuthor(@SortDefault(value = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        System.out.println(requestMeta.getEmail());
        ApiResponse apiResponse = authorService.getAuthor(pageable);
        return apiResponse;
    }

    @GetMapping(value = "/authorsNamedQuery")
    public ApiResponse getAuthorNamedQuery(Pageable pageable) {
        ApiResponse apiResponse = authorService.getAuthorNamedQuery(pageable);
        return apiResponse;

    }

}