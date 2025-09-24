package bookstore.Controller;

import bookstore.Common.ApiResponse;
import bookstore.DTO.LoginRequestDto;
import bookstore.DTO.SignUpRequestDto;
import bookstore.Service.LoginService;
import bookstore.Utils.JwtsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtsUtils jwtsUtils;

    @PostMapping("/signUp")
    public ResponseEntity<ApiResponse> signup(@RequestBody SignUpRequestDto signUpRequestDto) {

        ApiResponse apiResponse = loginService.signUp(signUpRequestDto);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> longIn(@RequestBody LoginRequestDto loginRequestDto) {

        ApiResponse apiResponse = loginService.logIn(loginRequestDto);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }

    @GetMapping("private")
    public ResponseEntity<ApiResponse> privateApi(@RequestHeader(value = "authorization",defaultValue = " ")String auth) throws Exception {
        ApiResponse apiResponse = new ApiResponse();


      jwtsUtils.verify(auth);

        apiResponse.setData("This is a private ");
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
}
