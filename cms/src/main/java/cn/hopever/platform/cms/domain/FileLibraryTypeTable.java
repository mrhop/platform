package cn.hopever.platform.cms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/12/19.
 */

@Entity
@Table(name = "platform_cms_file_library_type")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"website"})
public class FileLibraryTypeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "fileLibraryType")
    private List<FileLibraryTable> fileLibrarys;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    private TemplateTable template;

    @ManyToOne
    @JoinColumn(name = "website_id", nullable = false)
    private WebsiteTable website;

}
