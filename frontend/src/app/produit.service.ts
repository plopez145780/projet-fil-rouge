import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PageProduit } from './produit.model';

@Injectable({ providedIn: 'root' })
export class ProduitService {
  private readonly baseUrl = '/api';

  constructor(private readonly http: HttpClient) {}

  listProduits() {
    return this.http.get<PageProduit>(`${this.baseUrl}/produits`);
  }
}
