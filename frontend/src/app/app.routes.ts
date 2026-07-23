import { Routes } from '@angular/router';
import { CataloguePage } from './catalogue/catalogue.component';

export const routes: Routes = [
  { path: 'catalogue', component: CataloguePage },
  { path: '', redirectTo: '/catalogue', pathMatch: 'full' }
];
