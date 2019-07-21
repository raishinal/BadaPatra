<%-- 
    Document   : addcategory
    Created on : Jun 27, 2019, 4:00:09 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Document</title>
        <jsp:include page="static.jsp"/>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/Admin/Home"/>"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Sub Document/Add</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Sub Document</h1>
                </div>
            </div><!--/.row-->


            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Add Sub Document</div>
                        <div class="panel-body">
                            <div class="col-md-6">
                                <form role="form" action="<c:url value="/Admin/SubDocument/Add?${_csrf.parameterName}=${_csrf.token}"/>" method="post" enctype="multipart/form-data">

                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                    <div class="form-group">
                                        <label>Document Title</label>
                                        <input class="form-control" type="text" placeholder="Document title here.." name="title" required>
                                        <p class="help-block">${error_title}</p>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Choose Main Document</label>
                                        <select class="form-control" name="main">

                                            <c:forEach items="${categorylist}" var="cat">
                                                <option value="${cat.id}"> ${cat.title}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Sub Document Description</label>
                                        <textarea class="form-control" name="description" rows="7" required></textarea>
                                    </div>
                                    <input type="radio" name="confirm" value="confirm" required>Confirm
                                
                                    <button type="submit" class="btn btn-default">Submit Button</button>
                                    <button type="reset" class="btn btn-default">Reset Button</button>
                                </form>
                            </div>


                        </div>
                    </div>
                </div><!-- /.col-->
            </div><!-- /.row -->

        </div><!--/.main-->
        <jsp:include page="js.jsp"/>
    </body>
</html>
