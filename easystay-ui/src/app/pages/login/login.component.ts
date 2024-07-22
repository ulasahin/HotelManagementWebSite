import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../../services/auth.service';
import { SharedModule } from '../../shared.module';
import { LoginModel } from '../../model/login.model';
import { NavbarService } from '../../services/navbar.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  model: LoginModel = new LoginModel();
  errorMsg: string[] = [];

  constructor(
    private authService: AuthService,
    private toastr: ToastrService,
    private router: Router,
    private navbarService: NavbarService
  ) {}

  login(form: NgForm) {
    this.navbarService.setNavbarVisibility(false);
    if (form.valid) {
      this.authService.login(this.model.email, this.model.password).subscribe(response => {
        if (response) {
          this.toastr.success('Giriş başarılı!');
          this.router.navigateByUrl('/home');
        } else {
          this.errorMsg = ['Giriş başarısız!'];
        }
      }, error => {
        this.errorMsg = [error.error.message || 'Giriş başarısız!'];
      });
    }
  }

  register() {
    this.router.navigateByUrl('/register');
  }
}
