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
        <section id="main">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 mt-4">
                        <img src="<c:url value="/resources/headimage/${item.headimageName}"/>" class="mb-4">
                        <h2> ${item.description}</h2>
                       
                        <c:forEach items="${sublist}" var="sitem">
                            <br>

                            <h4 class="pl-4" id="${sitem.id}">${sitem.title}</h4>
                            <div>
                                ${sitem.descrpition}
                            </div>


                            <br>

                        </c:forEach>
                    </div>


                    <div class="col-md-4 mt-4" id="sidebar">
                        <div class="box">
                            <h4 class="section-title">Jump to</h4>
                            <ul>
                                <c:forEach items="${sublist}" var="item">

                                    <li class="my-2"><a href="#${item.id}">${item.title}</a></li>

                                </c:forEach>
                            </ul>
                        </div>

                        <div class="box">
                            <h4 class="section-title">Administrative details</h4>
                            <div class="container">
                                <label for="#district">Select Your District</label>
                                <select class="form-control mb-3" id="district">

                                    <option value="">Bajhang</option>
                                    <option value="">Bajura</option>
                                    <option value="" selected>Lalitpur</option>
                                    <option value="">Kathmandu</option>
                                </select> 

                                <h5 class="mb-3">Address</h5>
                                <p>Manbhawan, Jawalakhel, Lalitpur</p>

                                <h5 class="mb-3">Contact No.</h5>
                                <p>01-5523141 / 01-5523142</p>

                                <h5 class="mb-3">Opening Hours</h5>
                                <p>10:00 AM-5:00 PM (Sun-Thu)</p>
                                <p>10:00 AM-2:00 PM (Fri)</p>
                            </div>
                        </div>

                    </div>
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
