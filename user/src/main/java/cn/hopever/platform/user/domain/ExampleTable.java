package cn.hopever.platform.user.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
@Entity
@Table(name = "platform_user_example")
@Data
@EqualsAndHashCode(exclude={"id"})
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
}
