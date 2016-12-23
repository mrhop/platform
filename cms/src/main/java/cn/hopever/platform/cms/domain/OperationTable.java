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

    @Column(name = "related_table", nullable = false)
    private String relatedTable;

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
