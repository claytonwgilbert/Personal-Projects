import { Component, OnInit } from '@angular/core';
import {Pagination} from '../models/Pagination';
import {BlogPost} from '../models/BlogPost';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';
import {environment} from '../../environments/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  pagination: Pagination;
  blogPosts: BlogPost[];

  constructor(private http: HttpClient, private route: ActivatedRoute) {
  }

  ngOnInit() {
    // - Subscribe to any url changes, if so, load new page using page # from url or 1st page if no page # present
    this.route.queryParams.subscribe(x => this.loadPage(x.page || 1));
  }

  private loadPage(page) {
    this.http.get<any>(`${environment.BASE_API_URL}/blog/posts?page=${page}`).subscribe(x => {
      this.pagination = x.pagination; // - Grabbing pagination object from Spring backend
      this.blogPosts = x.blogPosts; // - Grabbing blog post objects from Spring backend
    });
  }

}
