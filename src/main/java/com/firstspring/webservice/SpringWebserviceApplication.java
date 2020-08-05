package com.firstspring.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  //JPA Auditing 활성화
@SpringBootApplication  //이것이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치
public class SpringWebserviceApplication {
    //프로젝트의 메인 클래스, 스프링부트의 자동설정, 스프링 Bean 일기기와 생성을 모두 자동으로 설정
    public static void main(String[] args) {
        SpringApplication.run(SpringWebserviceApplication.class, args);
    }

    //SpringApplication.run으로 인해 내장 WAS(Web Application Server)실행
    //>>내장 WAS : 별도의 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것
    //따라서 tomcat을 설치할 필요가 없음, 스프링부트로 만들어진 Jar파일로 실행행
    //>>Jar파일 : 실행가능한 Java 패키징 파일

}
