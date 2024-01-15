package de.aittr.g_27_data_jpa.controller;

import de.aittr.g_27_data_jpa.domain.Book;
import de.aittr.g_27_data_jpa.services.BookService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/books")
public class BookController {

  private BookService service;

  public BookController(BookService service) {
    this.service = service;
  }

  @GetMapping("/get_all")
  public List<Book> getAll(){
    return service.getAll();
  }
}
