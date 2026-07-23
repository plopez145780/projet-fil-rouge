import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProduitService } from '../produit.service';

@Component({
  selector: 'app-catalogue',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './catalogue.component.html',
  styleUrl: './catalogue.component.css'
})
export class CataloguePage implements OnInit {
  produits: any[] = [];
  error: string | null = null;
  loading = false;

  constructor(private readonly produitService: ProduitService) {}

  ngOnInit() {
    this.loadProduits();
  }

  loadProduits() {
    this.loading = true;
    this.error = null;
    this.produitService.listProduits().pipe().subscribe({
      next: (page: any) => {
        this.produits = Array.isArray(page?.content) ? page.content : [];
        this.loading = false;
      },
      error: () => {
        this.error = 'Impossible de charger les produits (API injoignable).';
        this.loading = false;
      }
    });
  }
}
