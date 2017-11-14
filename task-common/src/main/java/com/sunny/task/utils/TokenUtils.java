package com.sunny.task.utils;

import com.google.gson.JsonObject;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;

/**
 * @author sunny
 * @className com.sunny.task.common.utils.TokenUtils
 * @date 2017-10-18 09:04
 * @description:
 */
public class TokenUtils {
    private TokenUtils() {
        super();
    }

    //@Value("${token.default_secret_key}")
    public final static String default_secret_key = "task-sunny"; //密钥

    //单位秒
    public final static Long default_expiration = 60 * 60 * 24 * 30L; //token过期时间  一个月


    /**
     * 创建token
     *
     * @param subject
     * @return
     */
    public static String generateToken(Map<String, Object> subject) {

        try {
            String key = (String) subject.getOrDefault("default_secret_key", default_secret_key);
            Date expiration = (Date) subject.getOrDefault("default_expiration", tokenExpirationDate());
            return Jwts.builder()
                    .setIssuedAt(new Date())
                    .setSubject(GsonUtils.getGson().toJson(subject))
                    .setExpiration(expiration)//过期时间
                    .signWith(SignatureAlgorithm.HS256, key)
                    .setIssuer("task")
                    .compact();
        } catch (Exception e) {
            return Jwts.builder()
                    // .setIssuedAt(generateCurrentDate())
                    .setSubject(GsonUtils.getGson().toJson(subject))
                    .setExpiration(tokenExpirationDate())//过期时间
                    .signWith(SignatureAlgorithm.HS256, default_secret_key)
                    .compact();
        }

    }

    /**
     * 使用默认密钥解析
     *
     * @param token
     * @return
     */
    public static JsonObject parseToken(String token) {
        return parseToken(token, default_secret_key);
    }

    /**
     * 根据密钥解析token
     *
     * @param token
     * @param key
     * @return
     */
    public static JsonObject parseToken(String token, String key) {

        String json;
        if (NullUtils.isNull(token)) {
            json = "{\"error_type\":\"entrytoken\",\"error_token\":" + token + "}";
            return GsonUtils.getJsonObject(json);
        }
        try {
            json = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (ExpiredJwtException e) {  //token过时
            json = "{\"error_type\":\"ExpiredJwtException\",\"error_token\":" + token + "}";
        } catch (UnsupportedJwtException e) { //不支持
            json = "{\"error_type\":\"UnsupportedJwtException\",\"error_token\":" + token + "}";
        } catch (MalformedJwtException e) {  //格式错误
            json = "{\"error_type\":\"MalformedJwtException\",\"error_token\":" + token + "}";
        } catch (SignatureException e) {   //解密异常
            json = "{\"error_type\":\"SignatureException\",\"error_token\":" + token + "}";
        } catch (IllegalArgumentException e) {
            json = "{\"error_type\":\"IllegalArgumentException\",\"error_token\":" + token + "}";
        }
        return GsonUtils.getJsonObject(json);
    }

    /**
     * token 过期时间
     *
     * @return
     */
    public static Date tokenExpirationDate() {
        return new Date(System.currentTimeMillis() + default_expiration * 1000);
    }

}
