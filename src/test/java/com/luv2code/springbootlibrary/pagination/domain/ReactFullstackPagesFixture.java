package com.luv2code.springbootlibrary.pagination.domain;

import com.luv2code.springbootlibrary.pagination.domain.ReactFullstackPage.ReactFullstackPageBuilder;
import java.util.List;

public final class ReactFullstackPagesFixture {

  private ReactFullstackPagesFixture() {}

  public static ReactFullstackPage<String> page() {
    return pageBuilder().build();
  }

  public static ReactFullstackPageBuilder<String> pageBuilder() {
    return ReactFullstackPage.builder(List.of("test")).currentPage(2).pageSize(10).totalElementsCount(21);
  }
}
