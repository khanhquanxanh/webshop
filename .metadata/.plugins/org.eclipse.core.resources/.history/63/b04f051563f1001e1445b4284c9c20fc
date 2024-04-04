//package com.Java.Guides.khanhquanxanh.Interceptor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class JwtTokenInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // Lấy JWT từ nơi bạn lưu trữ nó (ví dụ: cookie, local storage, ...)
//    	Cookie[] cookies = request.getCookies();
//        String jwtToken = null;
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("jwtToken")) {
//                    jwtToken = cookie.getValue();
//                    System.out.println(jwtToken);
//                    break;
//                }
//            }
//        } else System.out.println("ban chua dang nhap");
//        String jwt = jwtToken; // lấy JWT từ request
//
//        // Nếu JWT tồn tại, thêm nó vào header của yêu cầu
//        if (jwt != null) {
//            String tokenWithBearerPrefix = "Bearer " + jwt;
//            response.addHeader("Authorization", tokenWithBearerPrefix);
//        }
//
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        // Not implemented
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        // Not implemented
//    }
//}