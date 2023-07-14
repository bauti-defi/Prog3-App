import { Injectable } from '@angular/core';
import { Network, Alchemy, NftContractNftsResponse, Nft as AlchemyNft, NftContract } from 'alchemy-sdk';
import { Nft } from '../models/Nft';
import { Collection } from '../models/Collection';
import { getAllCollections } from './api.service';

const settings = {
    // go ahead and steal this key, doesnt matter
    apiKey: "xdu4NwAH-ZTxtn6Vrv8007etOYfBLV5q",
    network: Network.ETH_MAINNET,
};

const UNDEFINED_NAME = "no name";

const parseNft = (nft: AlchemyNft): Nft => ({
  name: nft.title.length > 0 ? nft.title : nft.contract.name || UNDEFINED_NAME,
  description: nft.description,
  imageUrl: nft.media.length > 0 ? nft.media[0].gateway : '',
  tokenId: nft.tokenId,
  contractAddress: nft.contract.address,
  price: 10
});


@Injectable({
  providedIn: 'root'
})
export class NftService {

  private alchemyClient: Alchemy;
  private nftPageKeys = new Map<string, string>();

  constructor() {
    this.alchemyClient = new Alchemy(settings);
  }

  async getCollections(): Promise<Collection[]> {
    const collections: Exclude<Collection, 'description' | 'imageUrl'>[] = await getAllCollections();

    const responses: NftContract[] = await this.alchemyClient.nft.getContractMetadataBatch(collections.map(({address}) => address));

    return responses.map((response: NftContract) => ({
      name: response.openSea?.collectionName?.trim() || UNDEFINED_NAME,
      address: response.address,
      description: response.openSea?.description?.trim() || 'no description',
      imageUrl: response.openSea?.imageUrl || 'https://nayemdevs.com/wp-content/uploads/2020/03/default-product-image.png'
    }))
  }

  async getNft({address, tokenId}: {address: string, tokenId: string}): Promise<Nft> {
    return this.alchemyClient.nft.getNftMetadata(address, tokenId).then(parseNft);
  }

  async getNfts({
    address,
    name,
    pageKey,
    pageSize
  }:{
    address: string, 
    name?: string,
    pageKey?: string,
    pageSize?: number
  }): Promise<Nft[]> {
    if(pageSize && pageSize > 100) throw new Error("Page size cannot be greater than 100")

    const response = await this.alchemyClient.nft.getNftsForContract(address, {pageKey, pageSize});

    if(response.nfts.length == 0) return [];

    response.pageKey && this.nftPageKeys.set(address, response.pageKey);

    const nameFilter = (name: string) => (nft: Nft) => nft.name != UNDEFINED_NAME && nft.name.toLowerCase().includes(name.toLowerCase());

    if(name) response.nfts.map(parseNft).filter(nameFilter(name));

    return response.nfts.map(parseNft);
  }
}
