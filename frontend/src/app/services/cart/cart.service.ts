import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Cart } from 'src/app/models/Cart';
import { Nft } from 'src/app/models/Nft';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private cartSizeSubject: BehaviorSubject<number>;
  cart!: Cart;
  constructor() {
    this.cart = new Cart();
    this.cartSizeSubject = new BehaviorSubject<number>(0); // Assuming cart starts out empty.
  }

  getCartSizeObservable(): Observable<number> {
    return this.cartSizeSubject.asObservable();
  }

  public addToCart(nft: Nft): void {
    this.cart.items.push({nft: nft, quantity: 1});

    // Update the cart size.
    this.cartSizeSubject.next(this.cart.items.length);
  }

  public contains(nft: Nft): boolean {
    return this.cart.items.some((item) => item.nft.contractAddress == nft.contractAddress && item.nft.tokenId == nft.tokenId);
  }

  public removeFromCart(nft: Nft): void {
    this.cart.items = this.cart.items.filter((item) => item.nft.contractAddress != nft.contractAddress && item.nft.tokenId != nft.tokenId);

    // Update the cart size.
    this.cartSizeSubject.next(this.cart.items.length);
  }

  public getCartSize(): number {
    return this.cart.items.length;
  }

  public clear(): void {
    this.cart.items = [];
    this.cartSizeSubject.next(0);
  }

  public printCart(): void {
    console.log(this.cart);
  }
  
}
