import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SharedModule } from './shared.module';
import { NavbarComponent } from './navbar/navbar.component';
import { HotelInfoComponent } from './hotel-info/hotel-info.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,SharedModule,NavbarComponent,HotelInfoComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'easystay-ui-v1';
  showHotelInfo = false;

  toggleHotelInfo() {
    this.showHotelInfo = !this.showHotelInfo;
  }
}
