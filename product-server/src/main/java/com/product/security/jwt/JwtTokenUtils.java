package com.product.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;


public class JwtTokenUtils {

	public static final String SECRET_KEY = TextCodec.BASE64.encode("AAA");
	
	public static final String TOKEN_NAME = "myToken";
	/**
	 * 创建Token
	 * @param map
	 * @return
	 */
	public static String createToken(Map<String, Object> map) {
		// 过期时间
		// Date expirationDate = new Date(System.currentTimeMillis() + 2592000L * 1000);
		
		JwtBuilder builder = Jwts.builder()
				.setPayload(JSONObject.toJSONString(map))
				//.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY);
		
		return builder.compact();
	}
	
	/**
	 * 解析Token
	 * @param token
	 * @return
	 */
	public static Claims parseToken(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
		return claims;
	}
	
	public static boolean validateToken(String token) {
		return Jwts.parser().isSigned(token);
	}
	
}
