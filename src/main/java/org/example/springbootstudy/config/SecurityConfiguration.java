package org.example.springbootstudy.config;

//@Configuration
public class SecurityConfiguration {
    // @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         return http
// //                .authorizeHttpRequests(conf -> {
// ////                    conf.anyRequest().authenticated();
// //                })
// //                .formLogin(conf -> {
// //                    conf.loginProcessingUrl("/api/auth/login");
// ////                    conf.successHandler(this::onAuthenticationSuccess);
// //                    conf.successHandler(this::handleProcess);
// ////                    conf.failureHandler(this::onAuthenticationFailure);
// //                    conf.failureHandler(this::handleProcess);
// //                })
// //                .csrf(AbstractHttpConfigurer::disable)
// //                .cors(conf -> {
// //                    CorsConfiguration cors = new CorsConfiguration();
// ////                    cors.addAllowedOrigin("http://localhost:8080");
// //                    cors.addAllowedOriginPattern("*");
// //                    cors.setAllowCredentials(true);
// //                    cors.addAllowedHeader("*");
// //                    cors.addAllowedMethod("*");
// //                    cors.addExposedHeader("*");
// //                    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
// //                    source.registerCorsConfiguration("/**", cors);
// //                    conf.configurationSource(source);
// //                })
// //                .exceptionHandling(conf -> {
// //                    conf.accessDeniedHandler(this::handleProcess);
// //                    conf.authenticationEntryPoint(this::handleProcess);
// //                })
// //                .logout(conf -> {
// //                    conf.logoutUrl("/api/auth/logout");
// //                    conf.logoutSuccessHandler(this::onLogoutSuccess);
// //                })
// //                .sessionManagement(conf -> {
// //                    conf.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// //                })
// //                .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                 .build();
//     }

//     private void handleProcess(HttpServletRequest request,
//                                HttpServletResponse response,
//                                Object exceptionOrAuthentication) throws IOException {
//         response.setContentType("application/json;charset=utf-8");
//         PrintWriter writer = response.getWriter();
//         if (exceptionOrAuthentication instanceof AccessDeniedException exception) {
//             writer.write(RestBean.failure(403, exception.getMessage()).asJsonString());
//         } else if (exceptionOrAuthentication instanceof Exception exception) {
//             writer.write(RestBean.failure(401, exception.getMessage()).asJsonString());
//         } else if (exceptionOrAuthentication instanceof Authentication authentication) {
// //            writer.write(RestBean.success(authentication.getName()).asJsonString());
//             writer.write(RestBean.success(JWTUtils.createJwt((User) authentication.getPrincipal())).asJsonString());
//         }
//     }

    // void onAuthenticationFailure(HttpServletRequest request,
    //                              HttpServletResponse response,
    //                              AuthenticationException exception) throws IOException {
    //     response.setCharacterEncoding("utf-8");
    //     response.setContentType("application/json");
    //     PrintWriter writer = response.getWriter();
    //     writer.write(RestBean.failure(401, exception.getMessage()).asJsonString());
    // }
    //
    // void onAuthenticationSuccess(HttpServletRequest request,
    //                              HttpServletResponse response,
    //                              Authentication authentication) throws IOException {
    //     response.setCharacterEncoding("utf-8");
    //     response.setContentType("application/json");
    //     PrintWriter writer = response.getWriter();
    //     writer.write(RestBean.success(authentication.getName()).asJsonString());
    // }
    //
    // void onLogoutSuccess(HttpServletRequest request,
    //                      HttpServletResponse response,
    //                      Authentication authentication) throws IOException {
    //     response.setContentType("application/json;charset=utf-8");
    //     PrintWriter writer = response.getWriter();
    //     String authorization = request.getHeader("Authorization");
    //     if (authorization != null && authorization.startsWith("Bearer ")) {
    //         String token = authorization.substring(7);
    //         if (JWTUtils.invalidate(token)) {
    //             writer.write(RestBean.success("退出登录成功").asJsonString());
    //             return;
    //         }
    //     }
    //     writer.write(RestBean.failure(400, "退出登录失败").asJsonString());
    // }
}
