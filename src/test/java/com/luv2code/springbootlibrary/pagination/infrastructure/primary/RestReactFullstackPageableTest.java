package com.luv2code.springbootlibrary.pagination.infrastructure.primary;

import static com.luv2code.springbootlibrary.BeanValidationAssertions.*;
import static org.assertj.core.api.Assertions.*;

import com.luv2code.springbootlibrary.UnitTest;
import com.luv2code.springbootlibrary.pagination.domain.ReactFullstackPageable;
import org.junit.jupiter.api.Test;

@UnitTest
class RestReactFullstackPageableTest {

  @Test
  void shouldConvertToDomain() {
    ReactFullstackPageable pageable = pageable().toPageable();

    assertThat(pageable.page()).isEqualTo(1);
    assertThat(pageable.pageSize()).isEqualTo(15);
  }

  @Test
  void shouldNotValidateWithPageUnderZero() {
    RestReactFullstackPageable pageable = pageable();
    pageable.setPage(-1);

    assertThatBean(pageable).hasInvalidProperty("page");
  }

  @Test
  void shouldNotValidateWithSizeAtZero() {
    RestReactFullstackPageable pageable = pageable();
    pageable.setPageSize(0);

    assertThatBean(pageable).hasInvalidProperty("pageSize").withParameter("value", 1L);
  }

  @Test
  void shouldNotValidateWithPageSizeOverHundred() {
    RestReactFullstackPageable pageable = pageable();
    pageable.setPageSize(101);

    assertThatBean(pageable).hasInvalidProperty("pageSize");
  }

  private RestReactFullstackPageable pageable() {
    return new RestReactFullstackPageable(1, 15);
  }
}
