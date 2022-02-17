package io.github.ailtonbsj.bookstoremanager.mapper;

import io.github.ailtonbsj.bookstoremanager.dto.BookDTO;
import io.github.ailtonbsj.bookstoremanager.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}
