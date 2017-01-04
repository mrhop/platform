package cn.hopever.platform.cms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Donghui Huo on 2016/12/19.
 */

@Entity
@Table(name = "platform_cms_file_library")
@Data
@EqualsAndHashCode(of = {"id"})
public class FileLibraryTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "file_library_type_id")
    private FileLibraryTypeTable fileLibraryType;

    //用于下载的，这个使用mogilfs文件系统，存储后，并将url给予表中
    @Column(nullable = false)
    private String url;

    @Column(name = "is_published", nullable = false)
    private boolean isPublished = true;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "create_user")
    private String createUser;

    @ManyToOne
    @JoinColumn(name = "website_id", nullable = false)
    private WebsiteTable website;

}
