package com.luv2code.springbootlibrary.dummy.infrastructure.secondary;

import com.luv2code.springbootlibrary.dummy.domain.BeerId;
import com.luv2code.springbootlibrary.dummy.domain.beer.Beer;
import com.luv2code.springbootlibrary.dummy.domain.beer.BeerSellingState;
import com.luv2code.springbootlibrary.dummy.domain.beer.Beers;
import com.luv2code.springbootlibrary.dummy.domain.beer.BeersRepository;
import com.luv2code.springbootlibrary.error.domain.Assert;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
class SpringDataBeersRepository implements BeersRepository {

  private final JpaBeersRepository beers;

  public SpringDataBeersRepository(JpaBeersRepository beers) {
    this.beers = beers;
  }

  @Override
  public void save(Beer beer) {
    Assert.notNull("beer", beer);

    beers.save(BeerEntity.from(beer));
  }

  @Override
  public Beers catalog() {
    return new Beers(beers.findBySellingState(BeerSellingState.SOLD).stream().map(BeerEntity::toDomain).toList());
  }

  @Override
  public Optional<Beer> get(BeerId beer) {
    Assert.notNull("beer", beer);

    return beers.findById(beer.get()).map(BeerEntity::toDomain);
  }
}
