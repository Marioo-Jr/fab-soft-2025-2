
export class Page {
    "content": [
  ]
  pageable: {
    pageNumber: number,
    pageSize: number,
    sort: {
      unsorted: true,
      sorted: false,
      empty: true
    },
    offset: 0,
    unpaged: false,
    paged: true
  }
  totalElements: number
  totalPages: number
  last: true
  size: number
  number: number
  sort: {
    unsorted: true,
    sorted: false,
    empty: true
  }
  numberOfElements: number
  first: true
  empty: false
}

//
// export interface Page<T> {
//   content: T[];
//   totalElements: number;
//   totalPages: number;
//   size: number;
//   number: number;
//   numberOfElements: number;
//   first: boolean;
//   last: boolean;
//   empty: boolean;
// }
