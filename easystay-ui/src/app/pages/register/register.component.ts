import {Component} from '@angular/core';
import {Router} from '@angular/router';
import { NgForm } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { ToastrService } from 'ngx-toastr';
import { RegisterModel } from '../../model/register.model';
import { SharedModule } from '../../shared.module';


@Component({
  selector: 'app-register',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  model: RegisterModel = new RegisterModel();
  errorMsg: Array<string> = [];

  constructor(
    private router: Router,
    private authService: AuthService,
    private toastr: ToastrService,
  ) {
  }

  login() {
    this.router.navigate(['login']);
  }

  register(form: NgForm) {
    if (form.valid) {
      if (this.model.password !== this.model.passwordConfirm) {
        this.errorMsg = ['Passwords do not match!'];
        return;
      }
      this.authService.register(this.model).subscribe(response => {
        if (response) {
          this.toastr.success('Kayıt başarılı!');
          this.router.navigateByUrl('/');
        } else {
          this.errorMsg = ['Kayıt başarısız!'];
        }
      }, error => {
        this.errorMsg = [error.error.message || 'Kayıt başarısız!'];
      });
    }
  }
}