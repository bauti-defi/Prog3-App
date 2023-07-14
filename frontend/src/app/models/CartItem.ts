import { Nft } from "./Nft";

export class CartItem {

    readonly nft!:Nft;
    quantity!:number;
    constructor(nft: Nft){
        this.nft = nft;
        this.quantity = 1;
    }

}