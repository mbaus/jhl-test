import {useState, useEffect} from 'react';
import {getBeers} from '@/beers/services/beers';
import {IBeer} from '@/beers/interface';

export default function Beers() {
  const [beers, setBeers] = useState<Array<IBeer>>([]);

  useEffect(() => {
    getBeers({setBeers})
  }, []);

  return (
    <>
      <h2>Beers</h2>
      <ul>
        {/* eslint-disable-next-line react/jsx-key */}
        {beers.length > 0 && beers.map(beer => (<li>{beer.name}: ${beer.unitPrice}</li>))}
      </ul>
    </>
  );
}
