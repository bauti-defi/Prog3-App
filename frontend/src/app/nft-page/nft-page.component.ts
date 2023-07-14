import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { NftService } from '../services/nft.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Nft } from '../models/Nft';
import { CartService } from '../services/cart/cart.service';

@Component({
  selector: 'app-nft-page',
  templateUrl: './nft-page.component.html',
  styleUrls: ['./nft-page.component.css']
})
export class NftPageComponent implements OnInit {

  nft!: Nft;
  address!: string;
  tokenId!: string;
  canAddToCart!:boolean
  constructor(
    private nftService:NftService,
    private cartService: CartService,
    private router: Router,
    private activatedRoute: ActivatedRoute
    ){
    activatedRoute.params.subscribe(async ({address, tokenId}) => {
      this.address = address;
      this.tokenId = tokenId;
    })
  }

  async ngOnInit(): Promise<void> {
    if(!this.nft) this.nft = await this.nftService.getNft({address: this.address, tokenId: this.tokenId});
    this.canAddToCart = !this.cartService.contains(this.nft);
  }

  public toggleInCart(): void {
    if(this.canAddToCart) this.addToCart();
    else this.removeFromCart();
  }

  public addToCart(): void {
    this.cartService.addToCart(this.nft);
    this.canAddToCart = false;
  }

  public removeFromCart(): void {
    this.cartService.removeFromCart(this.nft);
    this.canAddToCart = true;
  }

  public buyNow(): void {
    this.cartService.clear();
    this.cartService.addToCart(this.nft);
    this.router.navigate(['cart/checkout']);
  }

}
