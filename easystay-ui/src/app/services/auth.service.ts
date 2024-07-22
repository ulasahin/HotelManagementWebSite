import { Injectable } from '@angular/core';
import { LoginModel } from '../model/login.model';
import { LoginResponseModel } from '../model/login-response.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { BehaviorSubject, catchError, Observable, of, tap } from 'rxjs';
import { RegisterModel } from '../model/register.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loginUrl = 'http://localhost:8080/auths/login'; // Backend URL
  private registerUrl = 'http://localhost:8080/auths/register';
  private profileUrl = 'http://localhost:8080/users/myprofile';
  private userIdKey = 'userId'; // User ID için key

  private loggedIn = new BehaviorSubject<boolean>(this.isLoggedIn());

  constructor(private http: HttpClient, private router: Router) {}

  login(email: string, password: string): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const body = JSON.stringify({ email, password });

    return this.http.post<any>(this.loginUrl, body, { headers, responseType: 'text' as 'json' }).pipe(
      tap(response => {
        // Token'ı ve userId'yi doğrudan yerel depolamaya kaydetme
        localStorage.setItem('token', response.token);
        localStorage.setItem(this.userIdKey, response.userId);
        this.loggedIn.next(true);
        this.router.navigateByUrl('/');
      }),
      catchError(error => {
        console.error('Login error:', error);
        return of(null);
      })
    );
  }

  register(model: RegisterModel): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const body = JSON.stringify(model);

    return this.http.post<any>(this.registerUrl, body, { headers, responseType: 'text' as 'json' }).pipe(
      tap(response => {
        localStorage.setItem('token', response.token);
        localStorage.setItem(this.userIdKey, response.userId);
        this.loggedIn.next(true);
        this.router.navigateByUrl('/');
      }),
      catchError(error => {
        console.error('Register error:', error);
        return of(null);
      })
    );
  }

  logout(): void {
    localStorage.removeItem('token');
    localStorage.removeItem(this.userIdKey);
    this.loggedIn.next(false);
    this.router.navigateByUrl('/login');
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('token') !== null;
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  getUserId(): string | null {
    return localStorage.getItem(this.userIdKey);
  }

  get isLoggedIn$(): Observable<boolean> {
    return this.loggedIn.asObservable();
  }

  getProfile(): Observable<any> {
    return this.http.get<any>(this.profileUrl);
  }

  updateProfile(data: any): Observable<any> {
    return this.http.put<any>(this.profileUrl, data);
  }
}
