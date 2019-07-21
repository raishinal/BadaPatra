<%-- 
    Document   : edititem
    Created on : Jun 28, 2019, 10:13:01 AM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="static.jsp"/>
        <title>Edit Item</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/Admin/Home"/>"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Document/Edit</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Document</h1>
                </div>
            </div><!--/.row-->


            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Edit Document</div>
                        <div class="panel-body">
                            <div class="col-md-6">

                                <form role="form" action="<c:url value="/Admin/Document/Update?${_csrf.parameterName}=${_csrf.token}"/>" method="post" enctype="multipart/form-data">

                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <div class="form-group">
                                        <label>Document Id</label>
                                        <input class="form-control" type="number" value="${item.id}" name="id" readonly>
                                        <p class="help-block">${error_title}</p>
                                    </div>
                                    <div class="form-group">
                                        <label>Document Title</label>
                                        <input class="form-control" type="text" value="${item.title}" name="title">
                                        <p class="help-block">${error_title}</p>
                                    </div>

                                    <div class="form-group">
                                        <label>Document Description</label>
                                        <textarea class="form-control"  name="description" rows="7">${item.description}</textarea>
                                    </div>



                                    <div class="form-group">
                                        <label>Category</label>
                                        <input class="form-control" type="number" value="${item.category}" name="category" readonly>

                                    </div>
                                    <div class="form-group">
                                        <label>Sample Image</label>
                                        <input class="form-control" type="text" value="${item.headimageName}" name="headimagename" readonly>

                                    </div>
                                    <div class="form-group">
                                        <label>Head Document Image</label>
                                        <input type="file" name="headimage" placeholder="Select image file if u want to edit">
                                        <p class="help-block"></p>
                                    </div>

                                    <div class="form-group">
                                        <label>Sample Image</label>
                                        <input class="form-control" type="text" value="${item.sampleimageName}" name="sampleimagename" readonly>

                                    </div>
                                    <div class="form-group">
                                        <label>Sample Document Image</label>
                                        <input type="file" name="sampleimage" placeholder="Select image file if u want to edit">
                                        <p class="help-block"></p>
                                    </div>

                                    <button type="submit" class="btn btn-default">Submit Button</button>
                                    <button type="reset" class="btn btn-default" >Reset Button</button>
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
