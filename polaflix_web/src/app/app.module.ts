import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { HttpClientModule } from '@angular/common/http';
import { HomeSeriesComponent } from './components/home-series/home-series.component';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { BannerComponent } from './components/banner/banner.component';
import { HomeComponent } from './components/home/home.component';
import { SeriesComponent } from './components/series/series.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { CabeceraComponent } from './components/cabecera/cabecera.component';
import { AppRoutingModule } from './app-routing.module';


@NgModule({

  declarations: [
    CabeceraComponent,
    AppComponent,
    SeriesComponent,
    HomeComponent,
    BannerComponent,
    HomeSeriesComponent
  ],

  imports: [
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    BrowserModule,
    FontAwesomeModule
  ],

  providers: [],
  bootstrap: [AppComponent]
})


export class AppModule { }
