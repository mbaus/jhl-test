export type BeersFunctionType = {
  setBeers: Dispatch<Array<IBeer>>;
};
export interface IBeer {
  id: string;
  name: string;
  unitPrice: string;
}
