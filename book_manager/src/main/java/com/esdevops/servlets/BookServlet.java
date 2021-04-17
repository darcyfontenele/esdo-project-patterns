package com.esdevops.servlets;

import com.esdevops.entities.Book;
import com.esdevops.services.BookService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
@WebServlet("/books")
public class BookServlet extends HttpServlet {

    private BookService bookService;
    private Gson gson;

    @Override
    public void init() {
        bookService = new BookService();
        gson = new GsonBuilder().create();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long id = nonNull(req.getParameter("id")) ? Long.parseLong(req.getParameter("id")) : null;
        RequestDispatcher rd;
        if(isNull(id)) {
            List<Book> books = bookService.findAll();
            req.setAttribute("books", books);
            rd = req.getRequestDispatcher("/book.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Long id = !req.getParameter("id").isEmpty() ? Long.parseLong(req.getParameter("id")) : null;
        Book book;
        RequestDispatcher rd = req.getRequestDispatcher("/book.jsp");
        switch (action) {
            case "save":
                String title = req.getParameter("title");
                String author = req.getParameter("author");
                String summary = req.getParameter("summary");
                Integer releaseYear = Integer.parseInt(req.getParameter("releaseYear"));
                if(nonNull(id)) {
                    book = bookService.findById(id);
                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setSummary(summary);
                    book.setReleaseYear(releaseYear);
                    bookService.update(book);
                } else {
                    book = new Book(title, author, summary, releaseYear);
                    bookService.save(book);
                }
                req.setAttribute("books", bookService.findAll());
                break;
            case "update":
                book = bookService.findById(id);
                req.setAttribute("book", book);
                rd = req.getRequestDispatcher("/form.jsp");
                break;
            case "delete":
                book = bookService.findById(id);
                bookService.delete(book);
                req.setAttribute("books", bookService.findAll());
                break;
        }
        rd.forward(req, resp);
    }

}
