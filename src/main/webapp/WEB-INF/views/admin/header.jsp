<%-- 
    Document   : header
    Created on : Jun 27, 2019, 4:00:38 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span> Panel</span>Admin</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> User <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="<c:url value="/Index"/>"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Home Page</a></li>
                                                        <li><a href="<c:url value="/Logout"/>"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		
		<ul class="nav menu">
			<li class="active"><a href="<c:url value="/Admin/Home"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Dashboard</a></li>
			<li class="active"><a href="<c:url value="/Admin/Category/Add"/>"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Add Category</a></li>
			<li class="active"><a href="<c:url value="/Admin/Category/Show"/>"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Display Category</a></li>
			<li class="active"><a href="<c:url value="/Admin/Document/Add"/>"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Add Documents</a></li>
			<li class="active"><a href="<c:url value="/Admin/Document/Show"/>"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Display Documents</a></li>
			<li class="active"><a href="<c:url value="/Admin/SubDocument/Add"/>"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Add SubDocuments</a></li>
			<li class="active"><a href="<c:url value="/Admin/SubDocument/Show"/>"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Display SubDocuments</a></li>
			<li class="active"><a href="<c:url value="/Admin/News/Add"/>"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Add News</a></li>
			<li class="active"><a href="<c:url value="/Admin/News/Show"/>"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Display News</a></li>
			<li class="active"><a href="<c:url value="/Admin/Register"/>"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Registration</a></li>
			
		</ul>

	</div><!--/.sidebar-->
		
    </body>
</html>
