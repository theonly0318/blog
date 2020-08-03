package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.PostTagService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.PostTagRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class PostTagServiceImpl implements PostTagService {

	@Autowired
	private PostTagRepository postTagRepository;

}
