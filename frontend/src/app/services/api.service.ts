import { Cart } from "../models/Cart";
import { Collection } from "../models/Collection";

export async function fetchData(url: string, method: string = 'GET', body: any = null) {
  try {
    const options: RequestInit = {
      method,
      headers: {
        'Content-Type': 'application/json'
      },
    };
    
    if (body) {
      options.body = JSON.stringify(body);
    }
    
    const response = await fetch(url, options);
    
    if (!response.ok) {
      throw new Error('Network response was not ok.');
    }
    
    const data = await response.json();
    // Process the retrieved data
    return data;
  } catch (error) {
    console.error('Error:', error);
  }
}

const COLLECTION_URL_STUB = "http://localhost:8081/api/collections";

export const getAllCollections = async (): Promise<Exclude<Collection, 'description' | 'imageUrl'>[]> => fetchData(`${COLLECTION_URL_STUB}/all`);

const AUTH_URL_STUB = "http://localhost:8081/api/auth";

export const authUser = async (username: string, wallet: string): Promise<string> => fetchData(`${AUTH_URL_STUB}`, 'POST', { username, wallet });

export const createUser = async (username: string, wallet: string): Promise<string> => fetchData(`${AUTH_URL_STUB}/create`, 'POST', { username, wallet });

const PURCHASE_URL_STUB = "http://localhost:8081/api/purchase";

export const submitPurchase = async (cart: Cart, user: {username: string, wallet: string}): Promise<boolean> => fetchData(`${PURCHASE_URL_STUB}`, 'POST', { nfts: cart.items.map(item => item.nft), user });