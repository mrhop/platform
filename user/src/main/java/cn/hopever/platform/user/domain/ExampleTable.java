package cn.hopever.platform.user.domain;

import javax.persistence.*;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
@Entity
@Table(name = "example_table")
public class ExampleTable {

    public ExampleTable(){}
    public ExampleTable(String userName){
        this.userName = userName;
    }
    public ExampleTable(Integer id, String userName){
        this.id = id;
        this.userName = userName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name",nullable = false, length=32)
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
