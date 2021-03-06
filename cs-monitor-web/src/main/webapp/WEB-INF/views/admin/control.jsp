<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form class="form-inline" method="post" style="text-align: center;"
	action="<c:url value='/admin/executerconcommand' />">
	<input type="text" class="input-large" name="rcon_command" style="width: 60%;"
		placeholder="<spring:message code="text.rcon.command"/>" required>
	<button type="submit" class="btn">
		<spring:message code="text.execute" />
	</button>
</form>

<div style="text-align: center">
	<ul class="nav nav-pills nav-stacked">
		<c:forEach items="${info}" var="element">
			<li><span class="label" style="margin-bottom: 5px;">${element.key}:
					${element.value}</span>
			<li>
		</c:forEach>
	</ul>
</div>