package com.cursor.library;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book createBook(
            final String name,
            final String author,
            final Integer year,
            final String genre
    ) throws CreateBookException {
        if (name == null) {
            throw new CreateBookException("Name field cannot be null");
        }
        if (year == null || year > 2021) {
            throw new CreateBookException("Illegal year argument");
        }
        return bookRepo.saveBook(
                name.trim(),
                author == null ? null : author.trim(),
                year,
                genre == null ? null : genre.trim());
    }

    public List<Book> getAll() {
        return bookRepo.getAll();
    }

    public Book findById(String bookId) {
        return bookRepo.findById(bookId);
    }
}
