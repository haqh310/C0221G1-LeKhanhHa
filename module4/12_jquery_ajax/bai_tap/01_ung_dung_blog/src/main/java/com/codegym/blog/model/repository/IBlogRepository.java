package com.codegym.blog.model.repository;


import com.codegym.blog.model.entity.Blog;
import com.codegym.blog.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findAllByCategory(Category category);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    @Query(value = "select * from blog b where b.title like %?1%", nativeQuery = true)
    List<Blog> findAllByTitleContaining(String title);

    @Query(value = "select * from blog b where b.title like %?1%", nativeQuery = true)
    Page<Blog> searchByTitle(String title, Pageable pageable);

    //        @Query(value = "select * from blog b order by b.date desc ", nativeQuery = true)
    @Query(value = "select id,content,date_format(`date`, '%e-%m-%Y') as `date`,title, category_id from blog ", nativeQuery = true)
    Page<Blog> sortByDate(Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO `blog` (`title`, `content`, `date`, `category_id`)" +
            "VALUES (:title, :content, curdate(),:category_id)", nativeQuery = true)
    void saveBlog(@Param("title") String title, @Param("content") String content, @Param("category_id") Long id);
}
