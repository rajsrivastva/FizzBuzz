import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { Post } from './post.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'FizzBuzz-webApp';
  displayedColumns: string[] = ['input', 'result'];
  loadedPosts: Post[] = [];
  numberArray: string[] = [];
  inputNumber: string = '';

  constructor(private http: HttpClient) {}

  ngOnInit() {

    // Added to demo quickly without adding, use clear Array to start new input
    this.numberArray.push('15');
    this.numberArray.push('17');
    this.numberArray.push('21');
  }

  onAddToArray(inputNumber:string){
    this.numberArray.push(inputNumber);
    this.inputNumber = '';
  }

  onEvaluate() {
    return this.invokePost();
  }

  onClearArray() {
    this.numberArray = [];
    this.loadedPosts = [];
  }

  private invokePost(){
    const postsArray: Post[] = [];
    for (const key in this.numberArray) {
      postsArray.push({'input':this.numberArray[key], 'result':['number found ' + this.numberArray[key],'Dividing ' + this.numberArray[key]]});
    }
    this.http
      .post<{ [key: number]: Post }>(
        '/api/fizzBuzz',
        this.numberArray
      )
      .pipe(
        map(responseData => {
          const postsArray: Post[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({ ...responseData[key] });
            }
          }
          return postsArray;
        })
      )
      .subscribe(posts => {
        this.loadedPosts = posts;
      });
    return postsArray;
  }
}
