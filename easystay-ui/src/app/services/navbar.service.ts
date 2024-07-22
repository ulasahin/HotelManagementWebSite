import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NavbarService {
  private navbarVisible = new BehaviorSubject<boolean>(true);
  currentNavbarVisibility = this.navbarVisible.asObservable();
  constructor() { }

  toggleNavbar() {
    this.navbarVisible.next(!this.navbarVisible.value);
  }

  setNavbarVisibility(visible: boolean) {
    this.navbarVisible.next(visible);
  }
}
