package com.fp.easybuy.pojo.easybuy;

import javax.persistence.*;

/**
 * 新闻表
 */
@Entity
@Table(name = "easybuy_news")
public class News {
    /*id主鍵*/
    @Id
    @GeneratedValue
    private Long id;
    /*標題*/
    @Column(nullable = false)
    private String title;
    /*內容*/
    @Column(nullable = false)
    private String content;
    /*創建時間*/
    @Column(nullable = false)
    private String createTime;

    @Override
    public String toString() {
        return super.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
