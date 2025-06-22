package com.nsu.movie_ticket_booking.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        String token=null;
        String username=null;

        if (header!=null && header.startsWith("Bearer ")){
            token = header.substring(7);
            username=jwtUtils.extractUsernameFromToken(token);
        }

        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails details = userDetailsService.loadUserByUsername(username);
            if (jwtUtils.validateToken(token,details)){
                UsernamePasswordAuthenticationToken authentication
                        =new UsernamePasswordAuthenticationToken(details,null,details.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request,response);
    }
}
