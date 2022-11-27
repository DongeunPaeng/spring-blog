# Hello World!

### Project Description

This project has two purposes:

- Build scalable and stable backend for my personal [blog](https://www.dongeunpaeng.com)
- Learn how to play around with Spring Boot
  - CI/CD using AWS CodeDeploy and GitHub Actions
  - Based on the book "스프링 부트와 AWS로 혼자 구현하는 웹 서비스" ([링크](https://product.kyobobook.co.kr/detail/S000001019679))

### Additional Links

Check out my [blog](https://www.dongeunpaeng.com) here!

### Extra Miles

#### SSL

- You cannot use Google/Naver login without SSL setup
- Sample codes in the book does not include setting up SSL
- Applying SSL requires AWS ACM, Route53, ELB, and some work on Spring Boot

#### Security

- Spring security has been updated several times after the book is published
- You can refer to my repository instead

#### CI/CD

- Travis CI is a bit obsolete; need to migrate to GitHub Actions
- Continuous Delivery using Nginx can be overridden with Blue/Green deployments provided by AWS
