import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ValidDirective } from './valid.directive';
import { AuthInterceptor } from './interceptors/auth.interceptor';
import { NavbarComponent } from './navbar/navbar.component';





@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    ValidDirective,
    
    
  ],
  exports: [
    CommonModule,
    FormsModule,
    RouterModule,
    ValidDirective,
    
    
  ],
})
export class SharedModule { }