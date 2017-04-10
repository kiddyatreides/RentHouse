 <% 
      if (session.getAttribute("token") != null){
            response.sendRedirect("AdminHome");
        }
      else{
          response.sendRedirect("Login"); 
        }
    
%>