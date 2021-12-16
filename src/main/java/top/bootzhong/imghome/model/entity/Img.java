package top.bootzhong.imghome.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * img
 * @author 
 */
@Data
public class Img implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 原文件名称
     */
    private String orginName;

    /**
     * 现在的名称
     */
    private String name;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 文件类型
     */
    private String type;

    /**
     * 文件本地路径
     */
    private String localPath;

    /**
     * 文件云路径
     */
    private String cloudPath;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createDate;

    private static final long serialVersionUID = 1L;
}