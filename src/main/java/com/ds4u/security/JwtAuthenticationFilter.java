package com.ds4u.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class JwtAuthenticationFilter  extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationFilter() {
        super("/**");
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            throw new JwtTokenMissingException("No JWT token found in request headers");
        }

        String authToken = header.substring(7);
        
        String username = "pervez"; //logic to extract username from token
        String role = "ROLE_USER"; //extract role information from token
        

        //JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

        
        
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken("pervez", authToken);
        
        return getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
    		FilterChain arg2) throws IOException, ServletException {
    	// TODO Auto-generated method stub
    	super.doFilter(arg0, arg1, arg2);
    }
    
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        // As this authentication is in HTTP header, after success we need to continue the request normally
        // and return the response as if the resource was not secured at all
        
        System.out.println("successfull authenticatin");
        chain.doFilter(request, response);
    }
    
    
}