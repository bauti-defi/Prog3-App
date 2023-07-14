import { Component, OnInit } from '@angular/core';
import { authUser } from '../services/api.service';
import { SessionService } from '../services/session.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  username!: string;
  wallet!: string;
  errorMessage!: string;
  constructor(
    private sessionService: SessionService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.username = '';
    this.wallet = '';
  }

  async login(): Promise<void> {
    try {
      if(this.username && this.wallet) {
        console.log("login")
        console.log(this.username, this.wallet);

        const response = await authUser(this.username, this.wallet);

        if(response) {
          this.sessionService.startSession(this.username,this.wallet);
          this.router.navigate(['/']);
        } else {
          this.errorMessage = 'Invalid username or wallet address';
        }

      } else {
        this.errorMessage = 'Username and Wallet address are required';
      }
    } catch (error) {
      this.errorMessage = 'An error occurred while logging in. Please try again later.';
    }
  }

}
