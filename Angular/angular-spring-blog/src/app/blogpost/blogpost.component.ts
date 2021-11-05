import { Component, OnInit } from '@angular/core';
import {BlogPost} from '../models/BlogPost';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';
import {environment} from '../../environments/environment';

@Component({
  selector: 'app-blogpost',
  templateUrl: './blogpost.component.html',
  styleUrls: ['./blogpost.component.css']
})
export class BlogpostComponent implements OnInit {

  blogPost: BlogPost;

  constructor(private route: ActivatedRoute, private http: HttpClient) {
  }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.http.get(`${environment.BASE_API_URL}/blog/posts/${id}`).subscribe((blogPost: BlogPost) => {
      this.blogPost = blogPost;
    });
  }

}
