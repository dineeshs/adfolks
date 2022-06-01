export class SignIn {
    private username: string;
    private password: string;

    constructor(username:string, password:string) {
        this.username = username;
        this.password = password;
    }

    public setUsername(username: string) {
        this.username = username;
    }

    public getUserName(): string {
        return this.username;
    }

    public setPassword(password: string) {
        this.password = password;
    }
    public getPassword(): string {
        return this.password;
    }
}