<%-- 
    Document   : header
    Created on : Jul 20, 2019, 6:23:52 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>

        <section id="navbar">
            <nav class="navbar navbar-expand-lg">
                <div class="container">
                    <a class="navbar-brand" href="<c:url value="/Index"/>">
                        <img src="<c:url value="/resources/img/nepal.gif"/>" alt="" srcset=""><img src="<c:url value="/resources/img/logo.png"  />" id="logo" /></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#nav1">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="nav1">
                        <ul class="navbar-nav ml-5">
                            <li class="nav-item">
                                <a href="<c:url value="/Index"/>" class="nav-link">Home</a>
                            </li>
                            <c:forEach items="${categorylist}" var="cat">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown">
                                        ${cat.title}
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <c:forEach items="${documentlist}" var="doc">
                                            <c:if test="${doc.category==cat.id}">
                                        <a class="dropdown-item" href="<c:url value="/Document/${doc.id}"/>">${doc.title}</a>
                                        </c:if>
                                       </c:forEach>
                                    </div>
                                </li>
                            </c:forEach>

                            <form method="GET" action="<c:url value="/Search"/>">
                                <input type="text" name="key" placeholder="Search.." class="form-control">
                                
                            </form>
                        </ul>

                    </div>
                </div>
            </nav>
        </section>


    </body>
</html>
