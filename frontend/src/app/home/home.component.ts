import { Component, OnInit } from '@angular/core';
import { NftService } from '../services/nft.service';
import { Nft } from '../models/Nft';
import { Collection } from '../models/Collection';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  collections: Collection[] = [];
 
  constructor(private nftService: NftService) { }
  
  async ngOnInit(): Promise<void> {
    this.collections = await this.nftService.getCollections();
  }

}
