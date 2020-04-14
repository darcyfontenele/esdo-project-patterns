<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book</title>
    </head>
<body>
    <form id="form1" action="form.jsp" method="post">
        <a href="javascript:;" onclick="document.getElementById('form1').submit();">+ NEW</a>
    </form>
    <h4>Books</h4>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Summary</th>
                <th>Release Year</th>
                <th colspan="2">Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.summary}</td>
                    <td>${book.releaseYear}</td>
                    <td>
                        <form action="books?action=update&id=${book.id}" method="POST">
                            <input type="submit" value="Update"/>
                        </form>
                    </td>
                    <td>
                        <form action="books?action=delete&id=${book.id}" method="POST">
                            <input type="submit" value="Delete"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>