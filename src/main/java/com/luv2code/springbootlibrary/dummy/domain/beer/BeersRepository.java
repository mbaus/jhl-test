package com.luv2code.springbootlibrary.dummy.domain.beer;

import com.luv2code.springbootlibrary.dummy.domain.BeerId;
import java.util.Optional;

public interface BeersRepository {
  void save(Beer beer);

  Beers catalog();

  Optional<Beer> get(BeerId beer);
}
