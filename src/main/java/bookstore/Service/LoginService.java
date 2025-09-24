package bookstore.Service;

import bookstore.Common.ApiResponse;
import bookstore.DTO.LoginRequestDto;
import bookstore.DTO.SignUpRequestDto;
import bookstore.Entity.User;
import bookstore.Repository.UserRepository;
import bookstore.Utils.JwtsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtsUtils jwtsUtils;

    public ApiResponse signUp(SignUpRequestDto signUpRequestDto) {
        ApiResponse apiResponse = new ApiResponse();

        User user = new User();
      user.setEmail(signUpRequestDto.getEmail());
      user.setPassword(signUpRequestDto.getPassword());
      user.setIs_active(Boolean.TRUE);
      user.setName(signUpRequestDto.getName());
      user.setGender(signUpRequestDto.getGender());
      user.setPhone_number(signUpRequestDto.getPhoneNumber());

        user = userRepository.save(user);

        apiResponse.setData(user);

        return apiResponse;
    }

    public ApiResponse logIn(LoginRequestDto loginRequestDto) {
        ApiResponse apiResponse = new ApiResponse();
        User user =userRepository.findOneByEmailIgnoreCaseAndPassword(loginRequestDto.getEmail(),loginRequestDto.getPassword());

        if(user==null){
            apiResponse.setData("User login failed");
            return apiResponse;
        }

        String token = jwtsUtils.generateJwtToken(user);

        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        apiResponse.setData(map);

        return apiResponse;
    }
}
