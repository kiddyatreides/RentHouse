<%
    
    if (session.getAttribute("token") == null){
     response.sendRedirect("Login");
    }
    else{
        session.removeAttribute("idadmin");
        session.removeAttribute("nama");
        session.removeAttribute("username");
        session.removeAttribute("token");
        session.invalidate();
        response.sendRedirect("AdminHome");
    }
    
%>