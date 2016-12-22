package cn.hopever.platform.cms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Donghui Huo on 2016/12/19.
 */
@Entity
@Table(name = "platform_cms_news")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"newsType"})
public class NewsTable {
    //id, title, content, create_date, create_user, publish_date, is_published,click_times, subtitle, news_type，website
    //返回到news或者news list的template是一个json的包含数据-然后前端进行组装
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String subtitle;

    @Column(nullable = false,columnDefinition="TEXT")
    private String content;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "click_times")
    private int clickTimes;

    @Column(name = "is_published",nullable = false)
    private boolean isPublished = true;

    @Column(name = "publish_date")
    private Date publishDate;

    @ManyToOne
    @JoinColumn(name = "news_type_id")
    private NewsTypeTable newsType;

}
