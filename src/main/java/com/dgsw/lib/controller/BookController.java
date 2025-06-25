package com.dgsw.lib.controller;

import com.dgsw.lib.dto.request.AddBookRequest;
import com.dgsw.lib.dto.request.BorrowRequest;
import com.dgsw.lib.dto.request.EditBookRequest;
import com.dgsw.lib.dto.request.ReturnRequest;
import com.dgsw.lib.dto.response.BookResponse;
import com.dgsw.lib.dto.response.ResponseDTO;
import com.dgsw.lib.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/book")
    public ResponseDTO addBookRequest(@RequestBody AddBookRequest addBookRequest){
        boolean created = bookService.addBookRequest(addBookRequest);
        return new ResponseDTO(created ? "ok" : "도서 아이디가 이미 존재하거나 생성에 실패하였습니다.");
    }

    @PatchMapping("/return")
    public ResponseDTO returnRequest(@RequestBody @Valid ReturnRequest returnRequest) {
        boolean success = bookService.returnBook(returnRequest.getBookId());

        if (success) {
            return new ResponseDTO("도서가 성공적으로 반납되었습니다.");
        } else {
            return new ResponseDTO("도서가 이미 반납되었거나 존재하지 않습니다.");
        }
    }

    @PatchMapping("/borrow")
    public ResponseDTO borrowRequest(@RequestBody @Valid BorrowRequest borrowRequest){
        boolean success = bookService.borrowBook(borrowRequest.getBookId());

        if (success) {
            return new ResponseDTO("도서가 성공적으로 대출되었습니다.");
        } else {
            return new ResponseDTO("도서가 이미 대출 중이거나 존재하지 않습니다.");
        }
    }

    @GetMapping("/books")
    public List<BookResponse> getAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/not-loaned")
    public List<BookResponse> getNotLoanedBooks() {
        return bookService.getNotLoanedBooks();
    }

    @PutMapping("/book")
    public ResponseDTO editBook(@RequestBody @Valid EditBookRequest request) {
        boolean edited = bookService.editBook(request);
        return new ResponseDTO(edited ? "ok" : "failed");
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseDTO deleteBook(@PathVariable String bookId) {
        boolean deleted = bookService.deleteBook(bookId);
        return new ResponseDTO(deleted ? "ok" : "failed");
    }

}
