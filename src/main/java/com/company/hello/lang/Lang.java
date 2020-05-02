package com.company.hello.lang;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "LANGUAGES" )
 public class Lang {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "_id")
    private Integer id;
    @Column(name = "welcome_msg")
     private String welcomeMsg;
     private String code;

    /**
     * Hibernate (JPA) needs it.
     */
    @SuppressWarnings("unused")
     Lang(){
     }

     public Lang(Integer id, String welcomeMsg, String code) {
         this.id = id;
         this.welcomeMsg = welcomeMsg;
         this.code = code;
     }

     public Integer getId() {
         return id;
     }

     public String getWelcomeMsg() {
         return welcomeMsg;
     }

     public void setWelcomeMsg(String welcomeMsg) {
         this.welcomeMsg = welcomeMsg;
     }

     public String getCode() {
         return code;
     }

     public void setCode(String code) {
         this.code = code;
     }
 }
