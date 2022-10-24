package com.hakim.entities;

import com.hakim.dao.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Hakim
 */
public class SecurityContext {

    private static final String AUTH_KEY = "auth.key";

    public static void login(HttpServletRequest request, User user) {
        HttpSession oldSession = request.getSession(false);

        if (oldSession != null) {
            oldSession.invalidate();
        }

        HttpSession session = request.getSession(true);
        session.setAttribute(AUTH_KEY, user);
    }

    public static void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute(AUTH_KEY);
    }

    public static User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        return (User) session.getAttribute(AUTH_KEY);
    }

    public static boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        return session.getAttribute(AUTH_KEY) != null;
    }
}
