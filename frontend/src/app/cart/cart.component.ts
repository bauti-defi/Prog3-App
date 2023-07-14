import { Component, OnDestroy, OnInit } from '@angular/core';
import { CartService } from '../services/cart/cart.service';
import { CartItem } from '../models/CartItem';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { SessionService } from '../services/session.service';
import { submitPurchase } from '../services/api.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit, OnDestroy{

  items!:CartItem[];
  hasSession!: boolean;
  private hasSessionSubscription?: Subscription;
  constructor(
    private cartService: CartService,
    private sessionService: SessionService,
    private router: Router
  ) {
  }
  ngOnDestroy(): void {
    if (this.hasSessionSubscription) {
      this.hasSessionSubscription.unsubscribe();
    }
  }

  ngOnInit(): void {
    this.items = this.cartService.cart.items;

    this.hasSessionSubscription = this.sessionService.getHasSessionObservable().subscribe(hasSession => {
      this.hasSession = hasSession;
    });
  }

  removeFromCart(item: CartItem): void {
    this.cartService.removeFromCart(item.nft);
    this.items = this.cartService.cart.items;
  }

  getTotalPrice(): number {
    return this.items.reduce((total, item) => total + (item.nft.price * item.quantity), 0);
  }

  async purchase(): Promise<void> {
    if(!this.hasSession) throw new Error("User is not logged in");

    // TODO: Implement the purchase logic here.
    console.log('Purchase clicked!');

    const response = await submitPurchase(this.cartService.cart, this.sessionService.getUser()!);

    if(response){
      this.cartService.clear();
      this.router.navigate(['/purchase-confirmation'])
    }
    
    throw new Error("Purchase failed");
  }
}
