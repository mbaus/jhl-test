package com.luv2code.springbootlibrary.pagination.infrastructure.secondary;

import com.luv2code.springbootlibrary.error.domain.Assert;
import com.luv2code.springbootlibrary.pagination.domain.ReactFullstackPage;
import com.luv2code.springbootlibrary.pagination.domain.ReactFullstackPageable;
import java.util.function.Function;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public final class ReactFullstackPages {

  private ReactFullstackPages() {}

  public static Pageable from(ReactFullstackPageable pagination) {
    return from(pagination, Sort.unsorted());
  }

  public static Pageable from(ReactFullstackPageable pagination, Sort sort) {
    Assert.notNull("pagination", pagination);
    Assert.notNull("sort", sort);

    return PageRequest.of(pagination.page(), pagination.pageSize(), sort);
  }

  public static <S, T> ReactFullstackPage<T> from(Page<S> springPage, Function<S, T> mapper) {
    Assert.notNull("springPage", springPage);
    Assert.notNull("mapper", mapper);

    return ReactFullstackPage
      .builder(springPage.getContent().parallelStream().map(mapper).toList())
      .currentPage(springPage.getNumber())
      .pageSize(springPage.getSize())
      .totalElementsCount(springPage.getTotalElements())
      .build();
  }
}
