package bookstore.Utils;

import bookstore.Common.AccessDeniedExpection;
import bookstore.Entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;


import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtsUtils {

    private String secret = "This_is_a_very_long_secret_key_1234567890";
    private SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    private static long expirydurationInMinutes = 60*60 ; // 60 minutes expiration

    public String generateJwtToken(User user) {
        long millis = System.currentTimeMillis();
        long expiryTime = millis + expirydurationInMinutes * 1000; // convert minutes to milliseconds

        Date issueDate = new Date(millis);
        Date expiryDate = new Date(expiryTime);

        Claims claims = Jwts.claims()
                .setIssuer(user.getId().toString())
                .setIssuedAt(issueDate)
                .setExpiration(expiryDate);

        claims.put("name", user.getName());
        claims.put("type", user.getUser_type());
        claims.put("email", user.getEmail());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }
    public Claims verify(String authorization) throws Exception{

        try {
            Claims claims =Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(authorization)
                    .getBody();
            System.out.println(claims.get("name"));
            return claims;
        }
        catch (Exception e){
            throw new AccessDeniedExpection("access denied");
        }

    }
}

