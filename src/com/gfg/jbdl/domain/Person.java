package com.gfg.jbdl.domain;

import java.io.Serializable;

public class Person implements Serializable {
    /**
     *OOPS
     * 1. Data encapsulation
     * 2. Data Hiding
     * 3. Inheritance
     * 4. Polymorphism
     * */


    /**
     * Data encapsulation
     * 4 access modifiers
     * 1. Private
     * 2. Protected
     * 3. Public
     * 4. Default( none specified)
     * */

    private String name;
    private String lastname;
    private Integer age;
    private boolean isAdult; //if age > 18 isAdult=true else false
    private String gender;

    //getters and setters
    public void setAge(Integer age){
        if(age<0 || age > 110){
            return;
        }
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", isAdult=" + isAdult +
                ", gender='" + gender + '\'' +
                '}';
    }

    /**
     * Notes:
     *  If no user-defined constructor then default blank constructor will be added.
     * */

}
