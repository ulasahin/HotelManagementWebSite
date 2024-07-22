import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { SharedModule } from '../shared.module';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { LoginComponent } from '../pages/login/login.component';
import { NavbarService } from '../services/navbar.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [SharedModule,LoginComponent],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit{
  isLoggedIn: boolean = false;

  @Output() hotelInfoClicked = new EventEmitter<void>();

  constructor(private authService: AuthService, private router: Router,
  ) {}

  ngOnInit() {
    this.authService.isLoggedIn$.subscribe(status => {
      this.isLoggedIn = status;
    });
  }

  logout() {
    this.authService.logout();
    this.isLoggedIn = false;
    this.router.navigate(['/login']);
  }
  login() {
    this.router.navigate(['/login']);
  }

  showHotelInfo() {
    this.hotelInfoClicked.emit();
  }
}
