<%-- 
    Document   : Dashboard
    Created on : Jul 20, 2019, 2:23:42 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="static.jsp"/>
        <title>Dashboard</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">		
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Icons</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Widgets</h1>
                </div>
            </div><!--/.row-->

            <div class="row">
                <!--			<div class="col-xs-12 col-md-6 col-lg-3">
                                                <div class="panel panel-blue panel-widget ">
                                                        <div class="row no-padding">
                                                                <div class="col-sm-3 col-lg-5 widget-left">
                                                                        <svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg>
                                                                </div>
                                                                <div class="col-sm-9 col-lg-7 widget-right">
                                                                        <div class="large">120</div>
                                                                        <div class="text-muted">New Orders</div>
                                                                </div>
                                                        </div>
                                                </div>
                                        </div>
                                        <div class="col-xs-12 col-md-6 col-lg-3">
                                                <div class="panel panel-orange panel-widget">
                                                        <div class="row no-padding">
                                                                <div class="col-sm-3 col-lg-5 widget-left">
                                                                        <svg class="glyph stroked empty-message"><use xlink:href="#stroked-empty-message"></use></svg>
                                                                </div>
                                                                <div class="col-sm-9 col-lg-7 widget-right">
                                                                        <div class="large">52</div>
                                                                        <div class="text-muted">Comments</div>
                                                                </div>
                                                        </div>
                                                </div>
                                        </div>
                                        <div class="col-xs-12 col-md-6 col-lg-3">
                                                <div class="panel panel-teal panel-widget">
                                                        <div class="row no-padding">
                                                                <div class="col-sm-3 col-lg-5 widget-left">
                                                                        <svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg>
                                                                </div>
                                                                <div class="col-sm-9 col-lg-7 widget-right">
                                                                        <div class="large">24</div>
                                                                        <div class="text-muted">New Users</div>
                                                                </div>
                                                        </div>
                                                </div>
                                        </div>-->
                <div class="col-xs-12 col-md-6 col-lg-3">
                    <div class="panel panel-red panel-widget">
                        <div class="row no-padding">
                            <div class="col-sm-2 col-lg-3 widget-left">
                                <svg class="glyph stroked app-window-with-content"><use xlink:href="#stroked-app-window-with-content"></use></svg>
                            </div>
                            <div class="col-sm-11 col-lg-9 widget-right">
                                <div class="large">${pageviewcount} </div>
                                <div class="text-muted">Page Views <a href="<c:url value="/Admin/Pagecount/Reset"/>" onclick="return confirm('Are you sure?')">Reset</a> </div>
                                <div class="text-muted">${pageviewcountdate}</div>
                            </div>
                        </div>
                    </div>
                </div><!--/.row-->

                <div class="row">
                    <div class="col-md-8">


                    </div><!--/.col-->

                    <div class="col-md-4">

                        <div class="panel panel-red">
                            <div class="panel-heading dark-overlay"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg>Calendar</div>
                            <div class="panel-body">
                                <div id="calendar"></div>
                            </div>
                        </div>



                    </div><!--/.col-->
                </div><!--/.row-->
                <div class="row">
                    <div class="col-md-8">


                        <div class="panel panel-default">
                            <div class="panel-heading">Session Counts</div>
                            <div class="panel-body">
                                <table data-toggle="table" data-url="tables/data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
                                    <thead>
                                        <tr>
                                            <th data-field="id" data-checkbox="true" >Session ID</th>
                                            <th data-field="counts"  data-sortable="true">Session Counts/th>
                                            <th data-field="startdate" data-sortable="true">Session StartDate</th>

                                            <th>Reset</th>
                                            <th data-field="documetid" data-sortable="true">Session DocumentID</th>


                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${sessions}" var="ses">
                                            <tr>
                                                <td>${ses.id}</td>
                                                <td>${ses.count}</td>
                                                <td>${ses.date}</td>
                                                <td><a href="<c:url value="/Admin/Pagecount/Reset/${ses.id}"/>" onclick="return confirm('Are you sure?')">Reset</a></td>
                                                <c:forEach items="${documents}" var="doc">
                                                    <c:if test="${doc.id==ses.documentid}">
                                                        <td>${doc.title}</td>
                                                    </c:if>
                                                </c:forEach>



                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>


                    </div><!--/.col-->
                </div>
            </div>	<!--/.main-->


            <jsp:include page="js.jsp"/>
            <script>
                $('#calendar').datepicker({
                });

                !function ($) {
                    $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
                        $(this).find('em:first').toggleClass("glyphicon-minus");
                    });
                    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
                }(window.jQuery);

                $(window).on('resize', function () {
                    if ($(window).width() > 768)
                        $('#sidebar-collapse').collapse('show')
                })
                $(window).on('resize', function () {
                    if ($(window).width() <= 767)
                        $('#sidebar-collapse').collapse('hide')
                })
            </script>
    </body>
</html>
