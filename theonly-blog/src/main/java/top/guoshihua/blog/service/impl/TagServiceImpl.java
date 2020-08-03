package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.TagService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagRepository tagRepository;

}
