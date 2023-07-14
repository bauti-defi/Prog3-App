import { Injectable} from "@angular/core";
import { CookieService } from "ngx-cookie-service";
import { BehaviorSubject, Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class SessionService{

    private hasSessionObservable: BehaviorSubject<boolean>;
    constructor(
        private cookieService: CookieService
    ) {
        this.hasSessionObservable = new BehaviorSubject<boolean>(this.cookieService.check('session'));
    }
    
    getHasSessionObservable(): Observable<boolean> {
        return this.hasSessionObservable.asObservable();
    }

    public getUser(): {username: string, wallet: string} | undefined {
        if(this.hasSession()){
            return JSON.parse(this.cookieService.get('session'));
        }
        return undefined;
    }

    public hasSession(): boolean {
        return this.cookieService.check('session'); 
    }

    public closeSession(): void {
        this.cookieService.delete('session');
        this.hasSessionObservable.next(false);
    }

    public startSession(username: string, wallet:string): void {
        console.log("session started")
        let expiration = new Date();
        expiration.setTime(expiration.getTime() + (60 * 60 * 1000)); // 1 hour expiration
        this.cookieService.set('session', JSON.stringify({username: username, wallet: wallet}), expiration);
        this.hasSessionObservable.next(true);
    }
    
}