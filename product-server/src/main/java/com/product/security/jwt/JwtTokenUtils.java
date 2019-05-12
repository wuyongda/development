package com.product.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

import java.util.Date;
import java.util.Map;


public class JwtTokenUtils {

	public static final String SECRET_KEY = TextCodec.BASE64.encode("wyd");
	
	public static final String TOKEN_NAME = "myToken";
	/**
	 * 创建Token
	 * @param map
	 * @return
	 */
	public static String createToken(Map<String, Object> map) {
		// 过期时间
		Date expirationDate = new Date(System.currentTimeMillis() + 8 * 60 * 60 * 1000); //毫秒数
		JwtBuilder builder = Jwts.builder()
				.addClaims(map)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY);
		return builder.compact();
	}
	
	/**
	 * 解析Token
	 * @param token
	 * @return
	 */
	public static Claims parseToken(String token) {
		Claims claims = null;
		try {
			claims = Jwts.parser()
					.setSigningKey(SECRET_KEY)
					.parseClaimsJws(token)
					.getBody();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return claims;
	}
	
	public static boolean validateToken(String token) {
		return Jwts.parser().isSigned(token);
	}
	
}
