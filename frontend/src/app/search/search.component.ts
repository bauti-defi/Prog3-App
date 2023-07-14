import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit{

  @Output() childToParent = new EventEmitter<string>();

  searchTerm: string = "";
  constructor(){
  }

  ngOnInit(): void {
    
  }

  search(): void {
    if(this.searchTerm) this.childToParent.emit(this.searchTerm);
  }

}
