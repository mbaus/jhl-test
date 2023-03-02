package com.luv2code.springbootlibrary.pagination.infrastructure.primary;

import com.luv2code.springbootlibrary.common.domain.Generated;
import com.luv2code.springbootlibrary.pagination.domain.ReactFullstackPageable;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Schema(name = "ReactFullstackPageable", description = "Pagination information")
public class RestReactFullstackPageable {

  private int page;
  private int pageSize = 10;

  @Generated
  public RestReactFullstackPageable() {}

  public RestReactFullstackPageable(int page, int pageSize) {
    this.page = page;
    this.pageSize = pageSize;
  }

  @Min(value = 0)
  @Schema(description = "Page to display (starts at 0)", example = "0")
  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  @Min(value = 1)
  @Max(value = 100)
  @Schema(description = "Number of elements on each page", example = "10")
  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public ReactFullstackPageable toPageable() {
    return new ReactFullstackPageable(page, pageSize);
  }
}
