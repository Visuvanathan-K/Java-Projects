package bookstore.Config;

import bookstore.DTO.RequestMeta;
import bookstore.Utils.JwtsUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtsUtils jwtsUtils;

    private RequestMeta requestMeta;

    public JwtInterceptor(RequestMeta requestMeta) {
        this.requestMeta = requestMeta;

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String auth = request.getHeader("authorization");

       if(! request.getRequestURI().contains("login") || request.getRequestURI().contains("signUp")){
            Claims claims=jwtsUtils.verify(auth);

            requestMeta.setUsername(claims.get("name").toString());
            requestMeta.setEmail(claims.get("email").toString());
            requestMeta.setUserId(Long.valueOf(claims.getIssuer()));
            requestMeta.setUserType(claims.get("type").toString());
        }


        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
