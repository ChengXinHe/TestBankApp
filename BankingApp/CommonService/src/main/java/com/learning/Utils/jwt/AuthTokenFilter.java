package com.learning.Utils.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;


//public class AuthTokenFilter extends OncePerRequestFilter {
//  @Autowired
//  private JwtUtils jwtUtils;
//
//
//  private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
//
//  @Override
//  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//      throws ServletException, IOException {
//
//  }
//
//  private String parseJwt(HttpServletRequest request) {
//    return "";
//  }
//}
