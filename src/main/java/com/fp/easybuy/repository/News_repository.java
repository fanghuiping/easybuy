package com.fp.easybuy.repository;

import com.fp.easybuy.pojo.easybuy.News;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface News_repository extends JpaRepository<News, Long> {
    /*查询新闻类并排序*/
    List<News> findAll(Sort sort);
}
