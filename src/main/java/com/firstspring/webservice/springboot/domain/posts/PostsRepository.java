package com.firstspring.webservice.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//왜인지는 아직 모르지만 @Repository 추가할 필요없다고 함, 엔티티인 Posts와 같은 위치에 있어야함
//ibatis, MyBatis에서 DAO라 불리는 DB layer, JPA에서 Repository라 부르며 인터페이스로 생성

public interface PostsRepository extends JpaRepository<Posts, Long> { //기본적인 CRUD 메소드가 자동생성됨
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    //실제로는 SpringDataJpa에서 제골하는 기본메소드 만으로 해결 가능, 다만 @Query는 가독성이 좋다.
    List<Posts> findAllDesc();
}
