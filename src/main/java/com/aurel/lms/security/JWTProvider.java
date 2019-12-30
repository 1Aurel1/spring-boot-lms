package com.aurel.lms.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(JWTProvider.class);

    private static int JWT_VALIDITY_IN_MS = 3600000;

    private static String secret = "verySecret";

    public String getUsernameFromToken(String token){

        return getClaimFromToken(token, Claims::getSubject);
    }

    //generate token for user
    public String generateToken(Authentication authentication) {

        Map<String, Object> claims = new HashMap<>();
        System.out.println("authentication name: " + authentication.getName());
        return doGenerateToken(claims, authentication.getName());
    }

    public String getUserIdFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex){
            LOGGER.error("Invalid JWT signature");
        } catch (MalformedJwtException ex){
            LOGGER.error("Invalid JWT token");
        } catch (ExpiredJwtException ex){
            LOGGER.error("Expired JWT token");
        } catch (UnsupportedJwtException ex){
            LOGGER.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex){
            LOGGER.error("JWT claims string is empty");
        }
        return false;
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver){

        final Claims claims = getAllClaimsFromToken(token);
        return claimResolver.apply(claims);
    }

    //for retrieveing any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token){

        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    //retrieve expiration date from jwt token
    private Date getExpirationDateFromToken(String token){

        return getClaimFromToken(token, Claims::getExpiration);
    }

    //while creating the token -
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string
    private String doGenerateToken(Map<String, Object> claims, String subject) {


        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_VALIDITY_IN_MS);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
