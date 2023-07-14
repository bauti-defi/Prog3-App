import { Component, OnInit, OnDestroy } from '@angular/core';
import { CartService } from '../services/cart/cart.service';
import { CookieService } from 'ngx-cookie-service';
import { Subscription } from 'rxjs';
import { SessionService } from '../services/session.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {

  cartSize!: number;
  cartTitle!: string;
  hasSession!: boolean;
  private cartSubscription?: Subscription;
  private hasSessionSubscription?: Subscription;
  constructor(
    private cartService: CartService,
    private sessionService: SessionService
    ) { 
    this.cartSize = this.cartService.getCartSize();
    this.hasSession = this.sessionService.hasSession();
  }

  ngOnInit(): void {
    // Assuming cartService has a getCartSizeObservable method that returns an Observable of the cart size.
    this.cartSubscription = this.cartService.getCartSizeObservable().subscribe(size => {
      this.cartSize = size;
      this.cartTitle = this.cartSize > 0 ? `Cart (${this.cartSize})` : 'Cart';
    });
    
    this.hasSessionSubscription = this.sessionService.getHasSessionObservable().subscribe(hasSession => {
      this.hasSession = hasSession;
    });
  }

  ngOnDestroy(): void {
    // Clean up subscription
    if (this.cartSubscription) {
      this.cartSubscription.unsubscribe();
    }

    if (this.hasSessionSubscription) {
      this.hasSessionSubscription.unsubscribe();
    }
  }

  logout(): void {
    this.sessionService.closeSession();
    this.hasSession = false;
  }

}
