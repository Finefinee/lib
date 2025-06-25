package com.dgsw.lib.service;

import com.dgsw.lib.dto.request.AddBookRequest;
import com.dgsw.lib.dto.request.EditBookRequest;
import com.dgsw.lib.dto.response.BookResponse;
import com.dgsw.lib.entity.BookEntity;
import com.dgsw.lib.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public boolean addBookRequest(AddBookRequest addBookRequest){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookID(addBookRequest.getBookID());
        bookEntity.setBookName(addBookRequest.getBookName());
        bookEntity.setAuthor(addBookRequest.getAuthor());
        bookEntity.setLoaned(addBookRequest.getIsLoaned());
        BookEntity saved = bookRepository.save(bookEntity);
        return saved != null;
    }

    public boolean returnBook(String bookId){
        Optional<BookEntity> optional = bookRepository.findById(bookId);
        if(optional.isPresent()){
            BookEntity bookEntity = optional.get();
            if(!bookEntity.isLoaned()){
                return false;
            }
            bookEntity.setLoaned(false);
            bookRepository.save(bookEntity);
            return true;
        }
        return false;
    }

    public boolean borrowBook(String bookId){
        Optional<BookEntity> optional = bookRepository.findById(bookId);
        if (optional.isPresent()) {
            BookEntity bookEntity = optional.get();
            if (bookEntity.isLoaned()) {
                return false;
            }
            bookEntity.setLoaned(true);
            bookRepository.save(bookEntity);
            return true;
        }
        return false;
    }

    public List<BookResponse> getBooks() {
        return bookRepository.findAll()
                .stream()
                .map(entity -> new BookResponse(
                                entity.getBookID(),
                                entity.getBookName(),
                                entity.getAuthor(),
                                entity.isLoaned()
                        )
                ).toList();
    }

    public boolean editBook(EditBookRequest request) {
        Optional<BookEntity> book = bookRepository.findById(request.getId());
        if (book.isPresent()) {
            BookEntity bookEntity = book.get();
            bookEntity.setBookName(request.getTitle());
            bookEntity.setAuthor(request.getAuthor());
            bookEntity.setLoaned(request.isLoaned());
            bookRepository.save(bookEntity);
            return true;
        }
        return false;
    }

    public boolean deleteBook(String id) {
        Optional<BookEntity> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
            return true;
        }
        return false;
    }
}
