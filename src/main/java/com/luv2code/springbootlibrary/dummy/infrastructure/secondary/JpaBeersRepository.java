package com.luv2code.springbootlibrary.dummy.infrastructure.secondary;

import com.luv2code.springbootlibrary.dummy.domain.beer.BeerSellingState;
import java.util.Collection;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

interface JpaBeersRepository extends JpaRepository<BeerEntity, UUID> {
  Collection<BeerEntity> findBySellingState(BeerSellingState sellingState);
}
