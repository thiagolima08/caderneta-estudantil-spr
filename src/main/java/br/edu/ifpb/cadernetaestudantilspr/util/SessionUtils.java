package br.edu.ifpb.cadernetaestudantilspr.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    public static HttpServlet getRequest() {
        return (HttpServlet) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public static String getUserName() {
        HttpSession session =(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        return session.getAttribute("professor").toString();
    }

    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("userid");
        }

        return null;
    }

}
