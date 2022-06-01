import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { SignIn } from '../SignIn';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;

  constructor(private service: AppService) { }

  ngOnInit(): void {
  }

  authenticate() {
    this.service.authenticate(new SignIn(this.username, this.password));

  }

}
