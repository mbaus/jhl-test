import axios from 'axios';

import { getLocalStorage } from '@/common/services/storage';
import { BeersFunctionType } from '@/beers/interface';

const BEERS_URL = '/api/beers';

export const getBeers = ({ setBeers }: BeersFunctionType) => {
  const headers = {
    'Authorization': 'Bearer ' + getLocalStorage('token')
  }
  return axios
    .get(BEERS_URL, {
      headers: headers
    })
    .then(response => {
      setBeers(response.data.beers);
    })
    .catch(error => {
      console.error(error);
    });
};
