<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>BadaPatra</title>
        <jsp:include page="static.jsp"/>

    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <section id="about-us" class="mt-4">
            <div class="container">
                <div class="jumbotron">
                    <btn id="cancel-btn"><img src="<c:url value="/resources/img/cancel.png"/>" /></btn>
                    <h3>
                        About Badapatra 
                    </h3>
                    <p class="lead mt-4">Have you ever been to government office, waited for hours in line for your turn and realised that some of your documents are missing and your work can't preceed further? How annoying is that?
                    <p class="lead">Now, We have a solution to this problem. BadaPatra is an digital platform which lets you know the documents required to carry on any government works. We save your time and energy. Remember us for consulting any governmental works.</p>
                    </p>
                </div>
            </div>
        </section>

        <section id="popular" class="">
            <div class="container bg-white p-4">
                <div class="row">
                    <div class="col-md-8">

                        <div class="box">
                            <h4 class="section-title">Latest News</h4>

                            <ul>
                                <c:forEach items="${news}" var="news">
                                    <li class="mt-4"><a href="<c:url value="/News/${news.id}"/>">${news.title}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>
                    
                    
                    <div class="col-md-4" id="sidebar">


                         <div class="card-title">
                                <form action="" class="form-inline">
                                <input type="text" placeholder="Search.." class="form-control">
                                <button class="btn btn-primary ml-2">Search</button>
                                </form>
                        </div> 

                        <div class="box">
                            <h4 class="section-title">Most Visited</h4>

                            <ul>
                                <c:forEach items="${populardocument}" var="pdoc">
                                    <c:forEach items="${documentlist}" var="doc">
                                        <c:if test="${doc.id==pdoc.documentid}">
                                            <li class="mt-4"><a href="<c:url value="/Document/${doc.id}"/>">${doc.title}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>

                            </ul>
                        </div>

                        <div class="box">
                            <h4 class="section-title">
                                Useful Links
                            </h4>
                            <ul>
                                <li><a href="#">Ministry of Education</a></li>
                                <li><a href="#">Ministry of Education</a></li>
                                <li><a href="#">Ministry of Education</a></li>
                                <li><a href="#">Ministry of Education</a></li>
                                <li><a href="#">Ministry of Education</a></li>
                            </ul>
                        </div>



                    </div>
                </div>

            </div>
        </section>

        <!-- footer section -->
        <footer class="mt-4 p-5">
            <p class="text-center"><strong>*Note: </strong> Reference of information this site delivers are obtained from government sites. We won't be responsible for any inconvinience or misinformation.</p>
            <p class="text-center"><a href="#" class="text-white">Terms and Conditions</a></p>
            
        </footer>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>	
        <script src="<c:url value="/resources/js/main.js"/>"></script>
    </body>
</html>