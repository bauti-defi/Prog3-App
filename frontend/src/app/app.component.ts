import { Component, OnDestroy } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy {

  constructor(private cookieService: CookieService) {}

  ngOnDestroy(): void {
    this.cookieService.delete('session');
  }
  
  title = 'Nft Marketplace';
}
