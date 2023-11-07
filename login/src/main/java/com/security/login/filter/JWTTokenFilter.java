package com.security.login.filter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String jwtToken = null ;
        String email = null ;
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
            jwtToken = authorizationHeader.substring(7);
            try{
                 email =  tokenService.getEmail(jwtToken);
            }catch (Exception e){
                //handle any exception that arise from token service
            }
        }

        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            Users user = userDao.getUserFromEmail(email);
            if(//conditionMatch){

                    SecurityContextHolder.getContext().getAuthentication().setAuthenticated();
        }
        filterChain.doFilter(request, response);
        }


    }
}
