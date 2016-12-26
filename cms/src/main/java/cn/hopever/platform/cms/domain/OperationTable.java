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
@Table(name = "platform_cms_operation")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"website"})
public class OperationTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //这个操作指向性相关联的enmu采用property 来列举
    @Column(name = "related_operation", nullable = false)
    private String relatedOperation;

    @Column(name = "related_id", nullable = false)
    private long relatedId;

    @Column(nullable = false)
    private String ip;

    @Column(name = "operation_user", nullable = false)
    private String operationUser;

    @Column(name = "operation_date", nullable = false)
    private Date operationDate = new Date();

    @ManyToOne
    @JoinColumn(name = "website_id", nullable = false)
    private WebsiteTable website;

}
