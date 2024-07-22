import { CommonModule } from "@angular/common";
import { importProvidersFrom, Provider } from "@angular/core";
import { bootstrapApplication, BrowserModule } from "@angular/platform-browser";
import { RouterModule } from "@angular/router";
import { HTTP_INTERCEPTORS, provideHttpClient, withInterceptors, withInterceptorsFromDi } from '@angular/common/http'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ToastrModule } from "ngx-toastr";

import { AppComponent } from "./app/app.component";

import { NgxSpinnerModule } from "ngx-spinner";
import { routes } from "./app/app.routes";
import { AuthInterceptor } from "./app/interceptors/auth.interceptor";


bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(
      withInterceptorsFromDi(),
    ), // HttpClient sağlayıcısını ekleyin
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
    },
    importProvidersFrom(
      BrowserModule,
      CommonModule,
      BrowserAnimationsModule,
      NgxSpinnerModule,
      ToastrModule.forRoot({
        closeButton: true,
        progressBar: true
      }),
      RouterModule.forRoot(routes)
    )
  ]
});
