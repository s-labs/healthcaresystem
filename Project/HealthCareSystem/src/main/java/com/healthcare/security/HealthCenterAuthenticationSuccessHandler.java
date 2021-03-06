package com.healthcare.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.healthcare.dao.UserDao;
import com.healthcare.model.UserEntity;

public class HealthCenterAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    
    @Autowired
	private UserDao userDao;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication) throws IOException {
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }
 
    protected void handle(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication) throws IOException {
    	
    	String name = authentication.getName();
    	Object detials = authentication.getDetails();
    	UserEntity user = userDao.getUserByUsername(name);
    	System.out.println(" --------------name ::: "+name);
    	request.getSession().setAttribute("username", name);
    	request.getSession().setAttribute("user", user);
    	System.out.println(" detila "+ detials.getClass().getCanonicalName());
        String targetUrl = determineTargetUrl(authentication);
 
        if (response.isCommitted()) {
           
            return;
        }
 
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
 
    /** Builds the target URL according to the logic defined in the main class Javadoc. */
    protected String determineTargetUrl(Authentication authentication) {
        boolean isHealthcenter = false;
        boolean isAdmin = false;
        boolean isdhs = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_HEALTHCENTER")) {
                isHealthcenter = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            }
            else if (grantedAuthority.getAuthority().equals("ROLE_DHS")) {
                isdhs = true;
                break;
            }
        }
 
        if (isHealthcenter) {
            return "/healthCenter/";
        } else if (isAdmin) {
            return "/admin/";
        }  else if (isdhs) {
            return "/dhs/";
        } else {
            throw new IllegalStateException();
        }
    }
 
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}