export interface Produit {
  id: number;
  sku: string;
  libelle: string;
  description: string;
  categorie: { id: number; libelle: string; slug: string } | null;
  grade: string;
  prixHt: number;
  tauxTva: number;
  stock: number;
  actif: boolean;
  garantieMois: number;
  dateAjout: string;
}

export interface PageProduit {
  content: Produit[];
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
}
