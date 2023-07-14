import { Component, OnInit } from '@angular/core';
import { NftService } from '../services/nft.service';
import { Nft } from '../models/Nft';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-collection',
  templateUrl: './collection.component.html',
  styleUrls: ['./collection.component.css']
})
export class CollectionComponent implements OnInit {

  collectionAddress: string = "";
  collection: Nft[] = [];
  nftsToShow: Nft[] = [];
  constructor(
    private nftService: NftService,
    private activatedRoute:ActivatedRoute,
    ) {
      activatedRoute.params.subscribe(async ({address}) => {
        this.collectionAddress = address;
      })
    }

  async ngOnInit(): Promise<void> {
    const nfts = await this.nftService.getNfts({address: this.collectionAddress, pageSize: 100});
    this.nftsToShow = nfts;
    this.collection = nfts;
  }

  public searchName($event: any): void {
    if($event === "") {
      this.nftsToShow = this.collection;
      return;
    }

    this.nftsToShow = this.collection.filter((nft: Nft) => nft.name.toLowerCase().includes($event.toLowerCase()) || nft.tokenId.toString().includes($event));
  }

}
