<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book</title>
    </head>
<body>
    <h3>Book</h3>
    <form action="books?action=save" method="POST">
        <input name="id" type="hidden" value="${book.id}"/>
        <table border="1">
        <tr>
            <td>Title</td>
            <td><input name="title" type="text" value="${book.title}"/></td>
        </tr>
        <tr>
            <td>Author</td>
            <td><input name="author" type="text" value="${book.author}"/></td>
        </tr>
        <tr>
            <td>Summary</td>
            <td><input name="summary" type="text" value="${book.summary}"/></td>
        </tr>
        <tr>
            <td>Release Year</td>
            <td><input name="releaseYear" type="text" value="${book.releaseYear}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="save" value="Save" />
            </td>
        </tr>
        </table>
    </form>
</body>
</html>