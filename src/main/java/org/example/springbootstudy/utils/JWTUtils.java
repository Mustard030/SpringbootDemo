package org.example.springbootstudy.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.*;

public class JWTUtils {
    //密钥
    private static final String key = "abcdefghijklmn";

    private static final HashSet<String> blackList = new HashSet<>();

    //加入黑名单方法
    public static boolean invalidate(String token){
        Algorithm algorithm = Algorithm.HMAC256(key);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            DecodedJWT verify = jwtVerifier.verify(token);
            Map<String, Claim> claims = verify.getClaims();
            return blackList.add(verify.getId());
        } catch (JWTVerificationException e){
            return false;
        }
    }

    // //根据用户信息创建JWT令牌
    // public static String createJwt(UserDetails user) {
    //     Algorithm algorithm = Algorithm.HMAC256(key);
    //     Calendar calendar = Calendar.getInstance();
    //     Date now = calendar.getTime();
    //     calendar.add(Calendar.SECOND, 3600 * 24 * 7);
    //     return JWT.create()
    //             .withJWTId(UUID.randomUUID().toString())
    //             .withClaim("name", user.getUsername())
    //             .withClaim("authorities", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
    //             .withExpiresAt(calendar.getTime())
    //             .withIssuedAt(now)
    //             .sign(algorithm);
    // }
    //
    // public static UserDetails resolveJwt(String token){
    //     Algorithm algorithm = Algorithm.HMAC256(key);
    //     JWTVerifier jwtVerifier = JWT.require(algorithm).build();
    //     try {
    //         DecodedJWT verify = jwtVerifier.verify(token);  //对JWT令牌进行验证，看看是否被修改
    //         if (blackList.contains(verify.getId())) return null;    //判断是否存在于黑名单中
    //         Map<String, Claim> claims = verify.getClaims();  //获取令牌中内容
    //         if(new Date().after(claims.get("exp").asDate())) //如果是过期令牌则返回null
    //             return null;
    //         else
    //             //重新组装为UserDetails对象，包括用户名、授权信息等
    //             return User
    //                     .withUsername(claims.get("name").asString())
    //                     .password("")
    //                     .authorities(claims.get("authorities").asArray(String.class))
    //                     .build();
    //     } catch (JWTVerificationException e) {
    //         return null;
    //     }
    // }
}
