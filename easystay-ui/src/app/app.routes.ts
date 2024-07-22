import { Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';

export const routes: Routes = [
    {
        path: "login",
        loadComponent: 
            ()=> import("./pages/login/login.component")
            .then(c=> c.LoginComponent),
            canActivate: [AuthGuard]
    },
    {
        path: "register",
        loadComponent: 
            ()=> import("./pages/register/register.component")
            .then(c=> c.RegisterComponent),
            canActivate: [AuthGuard]
    },
    {
        path: "home",
        loadComponent: 
            ()=> import("./pages/home/home.component")
            .then(c=> c.HomeComponent)     
    },
    {
        path: "profile",
        loadComponent: 
            ()=> import("./pages/profile/profile.component")
            .then(c=> c.ProfileComponent)     
    },
    {
        path: "rooms",
        loadComponent: 
            ()=> import("./pages/room/room.component")
            .then(c=> c.RoomComponent)     
    },

];
