import { CartItem } from "./CartItem";

export class Cart {

    items!:CartItem[];
    constructor(cartItems: CartItem[] = []) {
        this.items = cartItems;
    }

}