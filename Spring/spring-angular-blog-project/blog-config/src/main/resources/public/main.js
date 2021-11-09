(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"], {

    /***/ 0:
    /*!***************************!*\
      !*** multi ./src/main.ts ***!
      \***************************/
    /*! no static exports found */
    /***/ (function (module, exports, __webpack_require__) {

        module.exports = __webpack_require__(/*! C:\Spring\Personal-Projects\Angular\angular-spring-blog\src\main.ts */"zUnb");


        /***/
    }),

    /***/ "9vUh":
    /*!****************************************!*\
      !*** ./src/app/home/home.component.ts ***!
      \****************************************/
    /*! exports provided: HomeComponent */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "HomeComponent", function () {
            return HomeComponent;
        });
        /* harmony import */
        var _environments_environment__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../environments/environment */ "AytR");
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "fXoL");
        /* harmony import */
        var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "tk/3");
        /* harmony import */
        var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "tyNb");
        /* harmony import */
        var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ "ofXK");


        function HomeComponent_article_108_Template(rf, ctx) {
            if (rf & 1) {
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "article");
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](1, "div", 88);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](2, "h2");
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](3, "a", 89);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](4);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](5, "div", 90);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](6, "div", 91);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](7, "a", 92);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](8, "Read More ");
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](9, "i", 93);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
            }
            if (rf & 2) {
                const blog_r6 = ctx.$implicit;
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](3);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpropertyInterpolate1"]("routerLink", "/blogPost/", blog_r6.id, "");
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate"](blog_r6.title);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("innerHTML", blog_r6.preview, _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵsanitizeHtml"]);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](2);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpropertyInterpolate1"]("routerLink", "/blogPost/", blog_r6.id, "");
            }
        }

        const _c0 = function () {
            return {page: 1};
        };

        function HomeComponent_li_112_Template(rf, ctx) {
            if (rf & 1) {
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "li");
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](1, "a", 94);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](2, "First");
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
            }
            if (rf & 2) {
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("queryParams", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpureFunction0"](1, _c0));
            }
        }

        const _c1 = function (a0) {
            return {page: a0};
        };

        function HomeComponent_li_113_Template(rf, ctx) {
            if (rf & 1) {
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "li");
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](1, "a", 94);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](2, "Previous");
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
            }
            if (rf & 2) {
                const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("queryParams", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpureFunction1"](1, _c1, ctx_r2.pagination.currentPage));
            }
        }

        const _c2 = function (a0) {
            return {active: a0};
        };

        function HomeComponent_li_114_Template(rf, ctx) {
            if (rf & 1) {
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "li", 95);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](1, "a", 94);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](2);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
            }
            if (rf & 2) {
                const page_r7 = ctx.$implicit;
                const ctx_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpureFunction1"](3, _c2, ctx_r3.pagination.currentPage === page_r7));
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("queryParams", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpureFunction1"](5, _c1, page_r7 + 1));
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate"](page_r7 + 1);
            }
        }

        function HomeComponent_li_115_Template(rf, ctx) {
            if (rf & 1) {
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "li");
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](1, "a", 94);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](2, "Next");
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
            }
            if (rf & 2) {
                const ctx_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("queryParams", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpureFunction1"](1, _c1, ctx_r4.pagination.currentPage + 2));
            }
        }

        function HomeComponent_li_116_Template(rf, ctx) {
            if (rf & 1) {
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "li");
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](1, "a", 94);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](2, "Last");
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
            }
            if (rf & 2) {
                const ctx_r5 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
                _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("queryParams", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpureFunction1"](1, _c1, ctx_r5.pagination.totalPages));
            }
        }

        class HomeComponent {
            constructor(http, route) {
                this.http = http;
                this.route = route;
            }

            ngOnInit() {
                // - Subscribe to any url changes, if so, load new page using page # from url or 1st page if no page # present
                this.route.queryParams.subscribe(x => this.loadPage(x.page || 1));
            }

            loadPage(page) {
                this.http.get(`${_environments_environment__WEBPACK_IMPORTED_MODULE_0__["environment"].BASE_API_URL}/blog/posts?page=${page}`).subscribe(x => {
                    this.pagination = x.pagination; // - Grabbing pagination object from Spring backend
                    this.blogPosts = x.blogPosts; // - Grabbing blog post objects from Spring backend
                });
            }
        }

        HomeComponent.ɵfac = function HomeComponent_Factory(t) {
            return new (t || HomeComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"]));
        };
        HomeComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineComponent"]({
            type: HomeComponent,
            selectors: [["app-home"]],
            decls: 281,
            vars: 6,
            consts: [[1, "header"], [1, "header-top-area"], [1, "container"], [1, "row"], [1, "col-sm-6"], [1, "header-left-menu"], ["href", "index.html"], ["href", "about-me.html"], ["href", "contact-me.html"], [1, "social-icon"], ["target", "_blank", "href", "http://facebook.com"], [1, "fa", "fa-facebook"], ["target", "_blank", "href", "http://twitter.com"], [1, "fa", "fa-twitter"], ["target", "_blank", "href", "http://plus.google.com"], [1, "fa", "fa-google-plus"], ["target", "_blank", "href", "http://linkedin.com"], [1, "fa", "fa-linkedin"], ["target", "_blank", "href", "http://instagram.com"], [1, "fa", "fa-instagram"], ["target", "_blank", "href", "http://dribble.com"], [1, "fa", "fa-dribbble"], ["target", "_blank", "href", "http://behance.com"], [1, "fa", "fa-behance"], ["action", "index.html", "method", "get", "role", "search", 1, "search-form"], ["type", "search", "title", "Search for:", "name", "s", "value", "", "placeholder", "Search ...", 1, "search-field"], ["type", "submit", "value", "Search", 1, "search-submit"], [1, "header-bottom"], [1, "col-md-3"], [1, "logo"], [1, "navbar-header"], ["type", "button", "data-toggle", "collapse", "data-target", ".navbar-collapse", 1, "navbar-toggle"], [1, "sr-only"], [1, "icon-bar"], [1, "col-md-9"], [1, "navbar-collapse", "collapse"], [1, "nav", "navbar-nav", "navbar-right"], [1, "active"], [1, "dropdown"], ["data-toggle", "dropdown", "href", "#"], [1, "caret"], [1, "dropdown-menu"], ["href", "blog-left-sidebar.html"], ["href", "two-column-grid.html"], ["href", "three-column-grid.html"], ["href", "archive.html"], ["href", "single-post.html"], ["href", "404.html"], [2, "clear", "both"], [1, "page-content"], [1, "col-md-12"], [1, "page-title"], [1, "col-md-8"], [4, "ngFor", "ngForOf"], [1, "post-navigation"], [1, "pagination"], [4, "ngIf"], ["class", "page-item number-item", 3, "ngClass", 4, "ngFor", "ngForOf"], [1, "col-md-4"], [1, "right-sidebar"], [1, "widget"], ["src", "assets/img/photo.jpg", "alt", "", 1, "about-photo"], [1, "widget-title"], [1, "social-profiles"], ["href", "http://facebook.com", "target", "_blank"], ["href", "http://twitter.com", "target", "_blank"], ["href", "http://plus.google.com", "target", "_blank"], ["href", "http://pinterest.com", "target", "_blank"], [1, "fa", "fa-pinterest"], [1, "single-wid-post"], ["src", "assets/img/post-thumb.jpg", "alt", "", 1, "alignleft"], [1, "fa", "fa-clock-o"], ["src", "assets/img/post-thumb-2.jpg", "alt", "", 1, "alignleft"], ["src", "assets/img/post-thumb-3.jpg", "alt", "", 1, "alignleft"], ["src", "assets/img/post-thumb-4.jpg", "alt", "", 1, "alignleft"], ["src", "assets/img/post-thumb-5.jpg", "alt", "", 1, "alignleft"], [1, "tag-cloud"], [1, "footer"], [1, "col-md-4", "col-sm-4"], [1, "footer-widget"], [1, "footer-wid-title"], ["src", "assets/img/post-thumb-6.jpg", "alt", "", 1, "alignleft"], ["src", "assets/img/post-thumb-7.jpg", "alt", "", 1, "alignleft"], ["id", "tweet"], ["id", "instafeed"], [1, "col-md-6", "col-md-offset-3", "text-center"], [1, "footer-menu"], [1, "footer-copyright"], [1, "post-content"], ["href", "index.html", 3, "routerLink"], [1, "post-excerpt", 3, "innerHTML"], [1, "post-content-bottom"], ["href", "index.html", 1, "readmore", 3, "routerLink"], [1, "fa", "fa-long-arrow-right"], ["routerLink", "", 1, "page-link", 3, "queryParams"], [1, "page-item", "number-item", 3, "ngClass"]],
            template: function HomeComponent_Template(rf, ctx) {
                if (rf & 1) {
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "header", 0);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](1, "div", 1);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](2, "div", 2);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](3, "div", 3);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](4, "div", 4);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](5, "div", 5);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](6, "ul");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](7, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](8, "a", 6);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](9, "Home");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](10, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](11, "a", 7);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](12, "About me");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](13, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](14, "a", 8);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](15, "Contact me");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](16, "div", 4);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](17, "div", 9);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](18, "a", 10);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](19, "i", 11);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](20, "a", 12);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](21, "i", 13);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](22, "a", 14);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](23, "i", 15);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](24, "a", 16);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](25, "i", 17);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](26, "a", 18);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](27, "i", 19);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](28, "a", 20);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](29, "i", 21);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](30, "a", 22);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](31, "i", 23);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](32, "form", 24);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](33, "input", 25);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](34, "input", 26);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](35, "div", 27);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](36, "div", 2);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](37, "div", 3);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](38, "div", 28);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](39, "div", 29);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](40, "h1");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](41, "a", 6);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](42, "Din");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](43, "span");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](44, "Lipi");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](45, "div", 30);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](46, "button", 31);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](47, "span", 32);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](48, "Toggle navigation");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](49, "span", 33);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](50, "span", 33);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](51, "span", 33);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](52, "div", 34);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](53, "div", 35);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](54, "ul", 36);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](55, "li", 37);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](56, "a", 6);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](57, "Home");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](58, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](59, "a", 7);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](60, "About");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](61, "li", 38);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](62, "a", 39);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](63, "Other pages ");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](64, "span", 40);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](65, "ul", 41);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](66, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](67, "a", 42);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](68, "Home left sidebar");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](69, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](70, "a", 43);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](71, "Home 2 column masonry");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](72, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](73, "a", 44);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](74, "Home 3 column masonry");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](75, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](76, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](77, "Post Archives");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](78, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](79, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](80, "Single post");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](81, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](82, "a", 47);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](83, "404 not found");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](84, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](85, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](86, "Movie");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](87, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](88, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](89, "Sports");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](90, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](91, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](92, "Travel");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](93, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](94, "a", 8);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](95, "Contact me");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](96, "div", 48);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](97, "section", 49);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](98, "div", 2);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](99, "div", 3);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](100, "div", 50);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](101, "div", 51);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](102, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](103, "Archive for ");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](104, "span");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](105, "Videos");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](106, "div", 3);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](107, "div", 52);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](108, HomeComponent_article_108_Template, 10, 4, "article", 53);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](109, "div", 54);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](110, "nav");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](111, "ul", 55);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](112, HomeComponent_li_112_Template, 3, 2, "li", 56);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](113, HomeComponent_li_113_Template, 3, 3, "li", 56);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](114, HomeComponent_li_114_Template, 3, 7, "li", 57);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](115, HomeComponent_li_115_Template, 3, 3, "li", 56);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](116, HomeComponent_li_116_Template, 3, 3, "li", 56);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](117, "div", 58);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](118, "div", 59);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](119, "div", 60);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](120, "img", 61);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](121, "h2", 62);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](122, "ABOUT ME");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](123, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](124, "Welcome to Wayne's World.");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](125, "br");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](126, " My name is Clayton Wayne Gilbert - Software Engineer living in the O-H-I-O.");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](127, "p", 63);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](128, "Join me: ");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](129, "a", 64);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](130, "i", 11);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](131, "a", 65);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](132, "i", 13);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](133, "a", 66);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](134, "i", 15);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](135, "a", 67);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](136, "i", 68);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](137, "div", 60);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](138, "h2", 62);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](139, "Categories");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](140, "ul");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](141, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](142, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](143, "Entertainment");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](144, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](145, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](146, "Sports");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](147, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](148, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](149, "Travel");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](150, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](151, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](152, "Lifestyle");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](153, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](154, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](155, "Jobs");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](156, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](157, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](158, "Movies");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](159, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](160, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](161, "Music");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](162, "div", 60);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](163, "h2", 62);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](164, "Recent Posts");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](165, "div", 69);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](166, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](167, "img", 70);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](168, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](169, "The story of a colorful life");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](170, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](171, "i", 71);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](172, " 15 Oct, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](173, "div", 69);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](174, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](175, "img", 72);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](176, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](177, "Into the Backpack of a Photographer");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](178, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](179, "i", 71);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](180, " 21 Sep, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](181, "div", 69);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](182, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](183, "img", 73);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](184, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](185, "The Light of Future");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](186, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](187, "i", 71);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](188, " 19 Sep, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](189, "div", 69);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](190, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](191, "img", 74);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](192, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](193, "Some Speed Art Works, Will Amaze You");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](194, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](195, "i", 71);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](196, " 6 Jun, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](197, "div", 69);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](198, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](199, "img", 75);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](200, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](201, "Meaning of Freedom!");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](202, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](203, "i", 71);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](204, " 29 may, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](205, "div", 60);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](206, "h2", 62);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](207, "Tags");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](208, "div", 76);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](209, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](210, "Entertainment");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](211, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](212, "Sports");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](213, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](214, "Travel");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](215, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](216, "Lifestyle");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](217, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](218, "Movies");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](219, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](220, "Music");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](221, "footer", 77);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](222, "div", 2);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](223, "div", 3);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](224, "div", 78);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](225, "div", 79);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](226, "h2", 80);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](227, "Popular Posts");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](228, "div", 69);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](229, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](230, "img", 73);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](231, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](232, "The Light of Future");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](233, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](234, "i", 71);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](235, " 19 Sep, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](236, "div", 69);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](237, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](238, "img", 81);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](239, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](240, "Lives after the Sunset");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](241, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](242, "i", 71);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](243, " 15 Oct, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](244, "div", 69);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](245, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](246, "img", 82);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](247, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](248, "Top 10 Manupulated Photos of All time");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](249, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](250, "i", 71);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](251, " 15 Oct, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](252, "div", 78);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](253, "div", 79);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](254, "h2", 80);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](255, "Latest Tweets");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](256, "div", 83);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](257, "div", 78);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](258, "div", 79);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](259, "h2", 80);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](260, "Instagram");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](261, "div", 84);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](262, "div", 3);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](263, "div", 85);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](264, "div", 86);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](265, "ul");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](266, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](267, "a", 6);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](268, "Home");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](269, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](270, "a", 7);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](271, "About");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](272, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](273, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](274, "Archives");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](275, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](276, "a", 8);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](277, "Contact me");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](278, "div", 87);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](279, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](280, "\u00A9 2015 - All Rights Reserved.");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                }
                if (rf & 2) {
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](108);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngForOf", ctx.blogPosts);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](4);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx.pagination.currentPage > 0);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx.pagination.currentPage > 0);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngForOf", ctx.pagination.pages);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx.pagination.currentPage + 1 < ctx.pagination.totalPages);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx.pagination.currentPage + 1 < ctx.pagination.totalPages);
                }
            },
            directives: [_angular_common__WEBPACK_IMPORTED_MODULE_4__["NgForOf"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgIf"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterLinkWithHref"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgClass"]],
            styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJob21lLmNvbXBvbmVudC5jc3MifQ== */"]
        });


        /***/
    }),

    /***/ "AytR":
    /*!*****************************************!*\
      !*** ./src/environments/environment.ts ***!
      \*****************************************/
    /*! exports provided: environment */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "environment", function () {
            return environment;
        });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
        const environment = {
            production: false,
            BASE_API_URL: 'http://localhost:8081'
        };
        /*
         * For easier debugging in development mode, you can import the following file
         * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
         *
         * This import should be commented out in production mode because it will have a negative impact
         * on performance if an error is thrown.
         */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


        /***/
    }),

    /***/ "Il+L":
    /*!************************************************!*\
      !*** ./src/app/blogpost/blogpost.component.ts ***!
      \************************************************/
    /*! exports provided: BlogpostComponent */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "BlogpostComponent", function () {
            return BlogpostComponent;
        });
        /* harmony import */
        var _environments_environment__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../environments/environment */ "AytR");
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "fXoL");
        /* harmony import */
        var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "tyNb");
        /* harmony import */
        var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "tk/3");


        class BlogpostComponent {
            constructor(route, http) {
                this.route = route;
                this.http = http;
            }

            ngOnInit() {
                const id = this.route.snapshot.paramMap.get('id');
                this.http.get(`${_environments_environment__WEBPACK_IMPORTED_MODULE_0__["environment"].BASE_API_URL}/blog/posts/${id}`).subscribe((blogPost) => {
                    this.blogPost = blogPost;
                });
            }
        }

        BlogpostComponent.ɵfac = function BlogpostComponent_Factory(t) {
            return new (t || BlogpostComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"]));
        };
        BlogpostComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineComponent"]({
            type: BlogpostComponent,
            selectors: [["app-blogpost"]],
            decls: 278,
            vars: 2,
            consts: [[1, "header"], [1, "header-top-area"], [1, "container"], [1, "row"], [1, "col-sm-6"], [1, "header-left-menu"], ["href", "index.html"], ["href", "about-me.html"], ["href", "contact-me.html"], [1, "social-icon"], ["target", "_blank", "href", "http://facebook.com"], [1, "fa", "fa-facebook"], ["target", "_blank", "href", "http://twitter.com"], [1, "fa", "fa-twitter"], ["target", "_blank", "href", "http://plus.google.com"], [1, "fa", "fa-google-plus"], ["target", "_blank", "href", "http://linkedin.com"], [1, "fa", "fa-linkedin"], ["target", "_blank", "href", "http://instagram.com"], [1, "fa", "fa-instagram"], ["target", "_blank", "href", "http://dribble.com"], [1, "fa", "fa-dribbble"], ["target", "_blank", "href", "http://behance.com"], [1, "fa", "fa-behance"], ["action", "index.html", "method", "get", "role", "search", 1, "search-form"], ["type", "search", "title", "Search for:", "name", "s", "value", "", "placeholder", "Search ...", 1, "search-field"], ["type", "submit", "value", "Search", 1, "search-submit"], [1, "header-bottom"], [1, "col-md-3"], [1, "logo"], [1, "navbar-header"], ["type", "button", "data-toggle", "collapse", "data-target", ".navbar-collapse", 1, "navbar-toggle"], [1, "sr-only"], [1, "icon-bar"], [1, "col-md-9"], [1, "navbar-collapse", "collapse"], [1, "nav", "navbar-nav", "navbar-right"], [1, "active"], [1, "dropdown"], ["data-toggle", "dropdown", "href", "#"], [1, "caret"], [1, "dropdown-menu"], ["href", "blog-left-sidebar.html"], ["href", "two-column-grid.html"], ["href", "three-column-grid.html"], ["href", "archive.html"], ["href", "single-post.html"], ["href", "404.html"], [2, "clear", "both"], [1, "page-content"], [1, "col-md-12"], [1, "page-title"], [1, "col-md-8"], [1, "post-content"], [1, "post-excerpt", 3, "innerHTML"], [1, "col-md-4"], [1, "right-sidebar"], [1, "widget"], ["src", "assets/img/photo.jpg", "alt", "", 1, "about-photo"], [1, "widget-title"], [1, "social-profiles"], ["href", "http://facebook.com", "target", "_blank"], ["href", "http://twitter.com", "target", "_blank"], ["href", "http://plus.google.com", "target", "_blank"], ["href", "http://pinterest.com", "target", "_blank"], [1, "fa", "fa-pinterest"], [1, "single-wid-post"], ["src", "assets/img/post-thumb.jpg", "alt", "", 1, "alignleft"], [1, "fa", "fa-clock-o"], ["src", "assets/img/post-thumb-2.jpg", "alt", "", 1, "alignleft"], ["src", "assets/img/post-thumb-3.jpg", "alt", "", 1, "alignleft"], ["src", "assets/img/post-thumb-4.jpg", "alt", "", 1, "alignleft"], ["src", "assets/img/post-thumb-5.jpg", "alt", "", 1, "alignleft"], [1, "tag-cloud"], [1, "footer"], [1, "col-md-4", "col-sm-4"], [1, "footer-widget"], [1, "footer-wid-title"], ["src", "assets/img/post-thumb-6.jpg", "alt", "", 1, "alignleft"], ["src", "assets/img/post-thumb-7.jpg", "alt", "", 1, "alignleft"], ["id", "tweet"], ["id", "instafeed"], [1, "col-md-6", "col-md-offset-3", "text-center"], [1, "footer-menu"], [1, "footer-copyright"]],
            template: function BlogpostComponent_Template(rf, ctx) {
                if (rf & 1) {
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "header", 0);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](1, "div", 1);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](2, "div", 2);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](3, "div", 3);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](4, "div", 4);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](5, "div", 5);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](6, "ul");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](7, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](8, "a", 6);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](9, "Home");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](10, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](11, "a", 7);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](12, "About me");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](13, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](14, "a", 8);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](15, "Contact me");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](16, "div", 4);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](17, "div", 9);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](18, "a", 10);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](19, "i", 11);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](20, "a", 12);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](21, "i", 13);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](22, "a", 14);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](23, "i", 15);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](24, "a", 16);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](25, "i", 17);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](26, "a", 18);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](27, "i", 19);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](28, "a", 20);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](29, "i", 21);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](30, "a", 22);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](31, "i", 23);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](32, "form", 24);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](33, "input", 25);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](34, "input", 26);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](35, "div", 27);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](36, "div", 2);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](37, "div", 3);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](38, "div", 28);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](39, "div", 29);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](40, "h1");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](41, "a", 6);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](42, "Din");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](43, "span");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](44, "Lipi");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](45, "div", 30);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](46, "button", 31);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](47, "span", 32);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](48, "Toggle navigation");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](49, "span", 33);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](50, "span", 33);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](51, "span", 33);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](52, "div", 34);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](53, "div", 35);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](54, "ul", 36);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](55, "li", 37);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](56, "a", 6);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](57, "Home");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](58, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](59, "a", 7);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](60, "About");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](61, "li", 38);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](62, "a", 39);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](63, "Other pages ");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](64, "span", 40);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](65, "ul", 41);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](66, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](67, "a", 42);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](68, "Home left sidebar");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](69, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](70, "a", 43);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](71, "Home 2 column masonry");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](72, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](73, "a", 44);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](74, "Home 3 column masonry");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](75, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](76, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](77, "Post Archives");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](78, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](79, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](80, "Single post");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](81, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](82, "a", 47);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](83, "404 not found");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](84, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](85, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](86, "Movie");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](87, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](88, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](89, "Sports");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](90, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](91, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](92, "Travel");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](93, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](94, "a", 8);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](95, "Contact me");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](96, "div", 48);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](97, "section", 49);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](98, "div", 2);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](99, "div", 3);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](100, "div", 50);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](101, "div", 51);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](102, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](103, "Archive for ");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](104, "span");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](105, "Videos");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](106, "div", 3);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](107, "div", 52);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](108, "article");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](109, "div", 53);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](110, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](111, "a", 6);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](112);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](113, "div", 54);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](114, "div", 55);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](115, "div", 56);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](116, "div", 57);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](117, "img", 58);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](118, "h2", 59);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](119, "ABOUT ME");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](120, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](121, "Welcome to Wayne's World.");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](122, "br");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](123, " My name is Clayton Wayne Gilbert - Software Engineer living in the O-H-I-O.");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](124, "p", 60);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](125, "Join me: ");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](126, "a", 61);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](127, "i", 11);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](128, "a", 62);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](129, "i", 13);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](130, "a", 63);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](131, "i", 15);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](132, "a", 64);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](133, "i", 65);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](134, "div", 57);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](135, "h2", 59);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](136, "Categories");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](137, "ul");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](138, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](139, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](140, "Entertainment");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](141, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](142, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](143, "Sports");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](144, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](145, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](146, "Travel");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](147, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](148, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](149, "Lifestyle");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](150, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](151, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](152, "Jobs");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](153, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](154, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](155, "Movies");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](156, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](157, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](158, "Music");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](159, "div", 57);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](160, "h2", 59);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](161, "Recent Posts");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](162, "div", 66);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](163, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](164, "img", 67);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](165, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](166, "The story of a colorful life");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](167, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](168, "i", 68);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](169, " 15 Oct, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](170, "div", 66);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](171, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](172, "img", 69);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](173, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](174, "Into the Backpack of a Photographer");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](175, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](176, "i", 68);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](177, " 21 Sep, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](178, "div", 66);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](179, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](180, "img", 70);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](181, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](182, "The Light of Future");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](183, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](184, "i", 68);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](185, " 19 Sep, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](186, "div", 66);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](187, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](188, "img", 71);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](189, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](190, "Some Speed Art Works, Will Amaze You");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](191, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](192, "i", 68);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](193, " 6 Jun, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](194, "div", 66);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](195, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](196, "img", 72);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](197, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](198, "Meaning of Freedom!");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](199, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](200, "i", 68);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](201, " 29 may, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](202, "div", 57);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](203, "h2", 59);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](204, "Tags");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](205, "div", 73);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](206, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](207, "Entertainment");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](208, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](209, "Sports");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](210, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](211, "Travel");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](212, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](213, "Lifestyle");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](214, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](215, "Movies");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](216, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](217, "Music");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](218, "footer", 74);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](219, "div", 2);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](220, "div", 3);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](221, "div", 75);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](222, "div", 76);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](223, "h2", 77);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](224, "Popular Posts");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](225, "div", 66);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](226, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](227, "img", 70);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](228, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](229, "The Light of Future");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](230, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](231, "i", 68);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](232, " 19 Sep, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](233, "div", 66);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](234, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](235, "img", 78);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](236, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](237, "Lives after the Sunset");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](238, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](239, "i", 68);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](240, " 15 Oct, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](241, "div", 66);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](242, "a", 46);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](243, "img", 79);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](244, "h2");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](245, "Top 10 Manupulated Photos of All time");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](246, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](247, "i", 68);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](248, " 15 Oct, 2015");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](249, "div", 75);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](250, "div", 76);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](251, "h2", 77);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](252, "Latest Tweets");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](253, "div", 80);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](254, "div", 75);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](255, "div", 76);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](256, "h2", 77);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](257, "Instagram");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](258, "div", 81);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](259, "div", 3);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](260, "div", 82);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](261, "div", 83);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](262, "ul");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](263, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](264, "a", 6);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](265, "Home");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](266, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](267, "a", 7);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](268, "About");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](269, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](270, "a", 45);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](271, "Archives");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](272, "li");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](273, "a", 8);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](274, "Contact me");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](275, "div", 84);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](276, "p");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](277, "\u00A9 2021 - All Rights Reserved.");
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
                }
                if (rf & 2) {
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](112);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate"](ctx.blogPost.title);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
                    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("innerHTML", ctx.blogPost.content, _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵsanitizeHtml"]);
                }
            },
            styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJibG9ncG9zdC5jb21wb25lbnQuY3NzIn0= */"]
        });


        /***/
    }),

    /***/ "Sy1n":
    /*!**********************************!*\
      !*** ./src/app/app.component.ts ***!
      \**********************************/
    /*! exports provided: AppComponent */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "AppComponent", function () {
            return AppComponent;
        });
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
        /* harmony import */
        var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "tyNb");


        class AppComponent {
            constructor() {
                this.title = 'angular-spring-blog';
            }
        }

        AppComponent.ɵfac = function AppComponent_Factory(t) {
            return new (t || AppComponent)();
        };
        AppComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
            type: AppComponent,
            selectors: [["app-root"]],
            decls: 1,
            vars: 0,
            template: function AppComponent_Template(rf, ctx) {
                if (rf & 1) {
                    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "router-outlet");
                }
            },
            directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterOutlet"]],
            styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAuY29tcG9uZW50LmNzcyJ9 */"]
        });


        /***/
    }),

    /***/ "ZAI4":
    /*!*******************************!*\
      !*** ./src/app/app.module.ts ***!
      \*******************************/
    /*! exports provided: AppModule */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "AppModule", function () {
            return AppModule;
        });
        /* harmony import */
        var _angular_common_http__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/common/http */ "tk/3");
        /* harmony import */
        var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "jhN1");
        /* harmony import */
        var _app_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app-routing.module */ "vY5A");
        /* harmony import */
        var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app.component */ "Sy1n");
        /* harmony import */
        var _blogpost_blogpost_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./blogpost/blogpost.component */ "Il+L");
        /* harmony import */
        var _home_home_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./home/home.component */ "9vUh");
        /* harmony import */
        var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "1kSV");
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/core */ "fXoL");


        class AppModule {
        }

        AppModule.ɵfac = function AppModule_Factory(t) {
            return new (t || AppModule)();
        };
        AppModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineNgModule"]({
            type: AppModule,
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
        });
        AppModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineInjector"]({
            providers: [], imports: [[
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_0__["HttpClientModule"],
                _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_6__["NgbModule"]
            ]]
        });
        (function () {
            (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵsetNgModuleScope"](AppModule, {
                declarations: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"],
                    _home_home_component__WEBPACK_IMPORTED_MODULE_5__["HomeComponent"],
                    _blogpost_blogpost_component__WEBPACK_IMPORTED_MODULE_4__["BlogpostComponent"]],
                imports: [_angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                    _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"],
                    _angular_common_http__WEBPACK_IMPORTED_MODULE_0__["HttpClientModule"],
                    _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_6__["NgbModule"]]
            });
        })();


        /***/
    }),

    /***/ "vY5A":
    /*!***************************************!*\
      !*** ./src/app/app-routing.module.ts ***!
      \***************************************/
    /*! exports provided: AppRoutingModule */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */
        __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function () {
            return AppRoutingModule;
        });
        /* harmony import */
        var _angular_router__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/router */ "tyNb");
        /* harmony import */
        var _blogpost_blogpost_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./blogpost/blogpost.component */ "Il+L");
        /* harmony import */
        var _home_home_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./home/home.component */ "9vUh");
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ "fXoL");


        const routes = [
            {path: '', component: _home_home_component__WEBPACK_IMPORTED_MODULE_2__["HomeComponent"]},
            {
                path: 'blogPost/:id',
                component: _blogpost_blogpost_component__WEBPACK_IMPORTED_MODULE_1__["BlogpostComponent"]
            }
        ];

        class AppRoutingModule {
        }

        AppRoutingModule.ɵfac = function AppRoutingModule_Factory(t) {
            return new (t || AppRoutingModule)();
        };
        AppRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineNgModule"]({type: AppRoutingModule});
        AppRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineInjector"]({imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"].forRoot(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"]]});
        (function () {
            (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsetNgModuleScope"](AppRoutingModule, {
                imports: [_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"]],
                exports: [_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"]]
            });
        })();


        /***/
    }),

    /***/ "zUnb":
    /*!*********************!*\
      !*** ./src/main.ts ***!
      \*********************/
    /*! no exports provided */
    /***/ (function (module, __webpack_exports__, __webpack_require__) {

        "use strict";
        __webpack_require__.r(__webpack_exports__);
        /* harmony import */
        var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "jhN1");
        /* harmony import */
        var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "fXoL");
        /* harmony import */
        var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "ZAI4");
        /* harmony import */
        var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "AytR");


        if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
            Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["enableProdMode"])();
        }
        _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["platformBrowser"]().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
            .catch(err => console.error(err));


        /***/
    }),

    /***/ "zn8P":
    /*!******************************************************!*\
      !*** ./$$_lazy_route_resource lazy namespace object ***!
      \******************************************************/
    /*! no static exports found */
    /***/ (function (module, exports) {

        function webpackEmptyAsyncContext(req) {
            // Here Promise.resolve().then() is used instead of new Promise() to prevent
            // uncaught exception popping up in devtools
            return Promise.resolve().then(function () {
                var e = new Error("Cannot find module '" + req + "'");
                e.code = 'MODULE_NOT_FOUND';
                throw e;
            });
        }

        webpackEmptyAsyncContext.keys = function () {
            return [];
        };
        webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
        module.exports = webpackEmptyAsyncContext;
        webpackEmptyAsyncContext.id = "zn8P";

        /***/
    })

}, [[0, "runtime", "vendor"]]]);
//# sourceMappingURL=main.js.map