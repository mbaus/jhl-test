package com.luv2code.springbootlibrary.dummy.application;

import com.luv2code.springbootlibrary.dummy.domain.BeerId;
import com.luv2code.springbootlibrary.dummy.domain.beer.Beer;
import com.luv2code.springbootlibrary.dummy.domain.beer.BeerToCreate;
import com.luv2code.springbootlibrary.dummy.domain.beer.Beers;
import com.luv2code.springbootlibrary.dummy.domain.beer.BeersCreator;
import com.luv2code.springbootlibrary.dummy.domain.beer.BeersRemover;
import com.luv2code.springbootlibrary.dummy.domain.beer.BeersRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BeersApplicationService {

  private final BeersRepository beers;
  private final BeersCreator creator;
  private final BeersRemover remover;

  public BeersApplicationService(BeersRepository beers) {
    this.beers = beers;

    creator = new BeersCreator(beers);
    remover = new BeersRemover(beers);
  }

  @Transactional
  @PreAuthorize("hasRole('ADMIN')")
  public Beer create(BeerToCreate beerToCreate) {
    return creator.create(beerToCreate);
  }

  @Transactional
  @PreAuthorize("hasRole('ADMIN')")
  public void remove(BeerId beer) {
    remover.remove(beer);
  }

  @Transactional(readOnly = true)
  public Beers catalog() {
    return beers.catalog();
  }
}
