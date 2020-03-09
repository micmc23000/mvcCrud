<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="allBrewerie.title" /> </title>
    </head>
    <body>
        <table style="width:100%">
            <tr>
                <th align="left"><spring:message code="label.id" /></th>
                <th align="left"><spring:message code="label.name" /></th>
                <th align="left"><spring:message code="label.address1" /></th>
                <th align="left"><spring:message code="label.address2" /></th>
                <th align="left"><spring:message code="label.city" /></th>
                <th align="left"><spring:message code="label.state" /></th>
                <th align="left"><spring:message code="label.code" /></th>
                <th align="left"><spring:message code="label.country" /></th>
                <th align="left"><spring:message code="label.phone" /></th>
                <th align="left"><spring:message code="label.website" /></th>
                <th align="left"><spring:message code="label.description" /></th>
                <th align="left"><spring:message code="label.addUser" /></th>
                <th align="left"><spring:message code="label.last_mod" /></th>
                <th align="left"><spring:message code="label.credit_limit" /></th>
                <th align="left"><spring:message code="label.email" /></th>
            </tr>
            <c:forEach items="${brewerieList}" var="brewerie"> 
                <tr>
                    <td>${brewerie.id}</td>
                    <td>${brewerie.address1}</td>
                    <td>${brewerie.address2}</td>
                    <td>${brewerie.city}</td>
                    <td>${brewerie.state}</td>
                    <td>${brewerie.code}</td>
                    <td>${brewerie.country}</td>
                    <td>${brewerie.phone}</td>
                    <td>${brewerie.website}</td>
                    <td>${brewerie.state}</td>
                    <td>${brewerie.description}</td>
                    <td>${brewerie.addUser}</td>
                    <td>${brewerie.lastMod}</td>
                    <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${brewerie.creditLimit}" /></td>
                    <td>${brewerie.email}</td>
               
                    <td>

                        <a href="/mvcCRUD/home/delete?id=${brewerie.Id}"><spring:message code="label.delete" /></a>
                        <spring:url value="/home/edit?id=${brewerie.Id}" var="editURL"/>
                        <a href="${editURL}"z><spring:message code="label.edit" /></a>
                        
                    </td>

                </tr>
            </c:forEach>
        </table>
    </body>
</html>