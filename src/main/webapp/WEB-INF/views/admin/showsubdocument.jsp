<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>

        <title>Display Document</title>
        <jsp:include page="static.jsp"/>
    </head>

    <body>
        <jsp:include page="header.jsp"/>

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/Admin/Home"/>"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Display Documents</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Documents</h1>
                </div>
            </div><!--/.row-->


            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">SubDocumentTable</div>
                        <div class="panel-body">
                            <table data-toggle="table" data-url="tables/data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
                                <thead>
                                    <tr>
                                        <th data-field="id" data-checkbox="true" >SubDocument ID</th>
                                        <th data-field="title" data-sortable="true">SubDocument Title</th>
                                        <th data-field="main"  data-sortable="true"> Main Document</th>
                                        <th data-field="description" data-sortable="true">SubDocument Description</th>
                                        <th>Edit</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${itemlist}" var="item">
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.title}</td>
                                            <td>${item.mainDocument}</td>
                                            <td>${item.description}</td>


                                            <td><a href="<c:url value="/Admin/SubDocument/Edit/${item.id}"/>">Edit</a></td>
                                            <td><a href="<c:url value="/Admin/SubDocument/Delete/${item.id}"/>" onclick="return confirm('Are you sure?')">Delete</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div><!--/.row-->	



        </div><!--/.main-->

        <jsp:include page="js.jsp"/>
    </body>

</html>
