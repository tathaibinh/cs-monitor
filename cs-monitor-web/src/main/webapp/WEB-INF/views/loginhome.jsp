<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:url value="/resources/" var="resources" />
<c:url value="/" var="app" />

<html>
<tiles:insertAttribute name="before" />

<c:choose>
	<c:when test="${empty error}">
		<c:set value="url('${resources}img/background1.jpg') !important;"
			var="background" />
	</c:when>
	<c:otherwise>
		<c:set value="url('${resources}img/errorbackground.jpg') !important;"
			var="background" />
	</c:otherwise>
</c:choose>
<style>
body 
{
	background-image: ${background};
	background-size:cover !important;
	padding-top:100px !important;
} 
</style>

<head>
<link REL="SHORTCUT ICON" HREF="${app}favicon.ico" />
<title>Home</title>
</head>
<body data-spy="scroll" data-target=".bs-docs-sidebar" id="homebody" data-twttr-rendered="true">
	<tiles:insertAttribute name="menu" />
	<div class="container" >
		<tiles:insertAttribute name="content" />
	</div>
</body>
<tiles:insertAttribute name="after" />
</html>
