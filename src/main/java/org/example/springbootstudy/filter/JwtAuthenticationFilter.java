package org.example.springbootstudy.filter;

// public class JwtAuthenticationFilter extends OncePerRequestFilter {
    // @Override
    // protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    //     String authorization = request.getHeader("Authorization");
    //     if (authorization != null && authorization.startsWith("Bearer ")) {
    //         String token = authorization.substring(7);
    //         UserDetails user = JWTUtils.resolveJwt(token);
    //         if (user != null) {
    //             UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    //             authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    //             SecurityContextHolder.getContext().setAuthentication(authentication);
    //         }
    //     }
    //
    //     filterChain.doFilter(request, response);
    // }
// }
