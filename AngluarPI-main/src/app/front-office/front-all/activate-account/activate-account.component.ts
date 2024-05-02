import {Component, NgModule} from '@angular/core';
import {Router} from '@angular/router';
import {AuthenticationService} from '../serives/authentication.service';
import {skipUntil} from 'rxjs';
//import {CodeInputModule} from "angular-code-input";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-activate-account',
  templateUrl: './activate-account.component.html',
  standalone: true,
  imports: [
    //CodeInputModule,
    CommonModule
  ],
  styleUrls: ['./activate-account.component.scss']
})

export class ActivateAccountComponent {

  message = '';
  isOkay = true;
  submitted = false;
  constructor(
    private router: Router,
    private authService: AuthenticationService
  ) {}

  private confirmAccount(token: string) {
    this.authService.confirm(
      token
    ).subscribe({
      next: () => {
        this.message = 'Your account has been successfully activated.\nNow you can proceed to login';
        this.submitted = true;
      },
      error: () => {
        this.message = 'Token has been expired or invalid';
        this.submitted = true;
        this.isOkay = false;
      }
    });
  }

  redirectToLogin() {
    this.router.navigate(['login']);
  }

  onCodeCompleted(emailtoken: string) {
    this.confirmAccount(emailtoken);
  }

  protected readonly skipUntil = skipUntil;
}
