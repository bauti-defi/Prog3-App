import { Component, OnInit } from '@angular/core';
import { createUser } from '../services/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  username!: string;
  wallet!: string;
  confirmWallet!: string;
  errorMessage!: string; // New error message property
  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
    this.username = '';
    this.wallet = '';
    this.confirmWallet = '';
  }

  async register(): Promise<void> {
    try {
      if(this.username && this.wallet && this.confirmWallet === this.wallet) {
        const response = await createUser(this.username, this.wallet);

        if(response) {
          this.router.navigate(['/login']);
          return;
        } else {
          this.errorMessage = 'Registration failed, please try again';
        }
      } else {
        this.errorMessage = 'Invalid registration data. Please ensure all fields are filled out correctly and wallet addresses match';
      }
    } catch (error) {
      this.errorMessage = 'An error occurred while registering. Please try again later.';
    }
  }
}
