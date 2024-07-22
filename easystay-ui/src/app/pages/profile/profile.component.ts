import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { SharedModule } from '../../shared.module';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  standalone: true,
  imports: [SharedModule],
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  email: string | undefined;
  firstName: string | undefined;
  lastName: string | undefined;
  password: string | undefined;
  isEditing: boolean = false;


  constructor(private authService: AuthService) {}

  ngOnInit() {
    this.authService.getProfile().subscribe(
      data => {
        this.email = data.email;
        this.firstName = data.firstName;
        this.firstName = data.lastName;
        this.password = data.password;
        console.log(this.firstName)
      },
      error => {
        console.error('Error fetching profile data:', error);
      }
    );
  }
  editProfile() {
    this.isEditing = true;
  }

  saveProfile(form: NgForm) {
    if (form.valid) {
      const updatedData = {
        firstName: this.firstName,
        email: this.email
      };
      this.authService.updateProfile(updatedData).subscribe(
        response => {
          console.log('Profile updated successfully');
          this.isEditing = false;
        },
        error => {
          console.error('Error updating profile:', error);
        }
      );
    }
  }
}

