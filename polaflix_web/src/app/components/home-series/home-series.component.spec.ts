import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HomeSeriesComponent } from './home-series.component';


describe('HomeSeriesComponent', () => {
  let component: HomeSeriesComponent;
  let fixture: ComponentFixture<HomeSeriesComponent>;


  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeSeriesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeSeriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });


  it('should create', () => {
    expect(component).toBeTruthy();
  });

  
});
