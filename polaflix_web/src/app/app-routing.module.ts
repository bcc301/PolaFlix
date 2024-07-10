import { NgModule } from '@angular/core';
import { HomeComponent } from './components/home/home.component';
import { RouterModule, Routes } from '@angular/router';
import { SeriesComponent } from './components/series/series.component';




const routes: Routes = [

  { path: 'usuarios/:usuarioId/series', component: SeriesComponent },
  { path: 'usuarios/:usuarioId/home', component: HomeComponent },
  { path: '**', component: HomeComponent }

];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})



export class AppRoutingModule {}
