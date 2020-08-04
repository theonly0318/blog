package top.guoshihua.blog.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import top.guoshihua.blog.entity.Link;

import java.util.List;

/**
 * @author guoshihua
 */
@CacheConfig(cacheNames = {"link"})
public interface LinkService {

    /**
     * 获取所有友情链接
     * @return List<Link>
     */
    List<Link> findAll();

    /**
     * 根据主键id获取友情链接信息
     * @param id 友情链接主键id
     * @return
     */
    @Cacheable(key = "#p0")
    Link findById(Integer id);

    /**
     * 分页获取所有友情链接
     * @param page 页码；默认值 1
     * @param rows 每页显示条数；默认值 10
     * @param sortBy 排序字段；默认 createTime
     * @param desc 是否降序；true：降序排序、false：升序排序
     * @return
     */
    Page<Link> findByPage(Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 新增
     * @param link
     * @return
     */
    Link save(Link link);

    /**
     * 修改
     * @param link
     * @return
     */
    Link update(Link link);

    void deleteById(Integer id);
}
