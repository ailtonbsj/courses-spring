package br.ailtonbsj.usermanagerdemo.constant;

public class SecurityConstant {
    public static long EXPIRATION_TIME = 432_000_000;
    public static String TOKEN_PREFIX = "Bearer ";
    public static String JWT_TOKEN_HEADER = "Jwt-Token";
    public static String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static String AUTHORITIES = "Authorities";
    public static String FORBIDDEN_MESSAGE = "You need to log in to access this page";
    public static String ACCESS_DENIED_MESSAGE = "You dont have permission to access";
    public static String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static String DOMAIN_NAME = "Demo Corp";
    public static String APPLICATION_NAME = "User manager";
    public static String[] PUBLIC_URLS = {
        "/user/login", "/user/register", "/user/resetpassword/**", "/user/image/**" };
}
