package io.github.ailtonbsj.bookstoremanager.repository;

import io.github.ailtonbsj.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
