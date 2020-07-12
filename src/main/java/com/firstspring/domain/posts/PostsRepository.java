package com.firstspring.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//ibatis, MyBatis에서 DAO라 불리는 DB layer, JPA에서 Repository라 부르며 인터페이스로 생성
public interface PostsRepository extends JpaRepository<Posts, Long> { //기본적인 CRUD 메소드가 자동생성됨
}
