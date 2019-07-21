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
                <h1 class="my-3"> Search Results </h1>
                <hr>
                    <c:forEach items="${itemlist}" var="item">
                    <div class="single-product col-lg-4 col-md-6">
                        <img class="img-fluid" src="<c:url value="/resources/headimage/${item.headimageName}"/>" alt="">
                        <div class="product-details mt-3">
                            <h3><a href="<c:url value="/Document/${item.id}"/>">${item.title}</a></h3> 
                        </div>
                    </div>
                    </c:forEach>
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
