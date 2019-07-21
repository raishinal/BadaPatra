<%-- 
    Document   : singledocument
    Created on : Jul 20, 2019, 8:45:27 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <jsp:include page="static.jsp"/>
        <title>Single Document</title>
    </head>
    <body>
          <jsp:include page="header.jsp"/>
          <section id="main-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 mt-4">
                            <img src="<c:url value="/resources/newsimage/${item.headimageName}"/>" class="mb-4">                           
                                <br>
                                 <h4 class="pl-4">${item.title}</h4>
                                 <p>
                                     ${item.description}
                                 </p>
                                 <br>
                            

                        </div>
                        <div class="col-md-4"></div>
                    </div>
                </div>
            </section>



        <footer class="mt-4 p-5">
                <p class="text-center"><strong>*Note: </strong> Reference of information this site delivers are obtained from government sites. We won't be responsible for any inconvinience or misinformation.</p>
                <p class="text-center" id="footer-links">
                    <a href="#"">Terms and Conditions</a>
                    <a href="#">About</a>
                    <a href="#">Contact Us</a>
                </p>
            </footer>
    </body>
</html>
