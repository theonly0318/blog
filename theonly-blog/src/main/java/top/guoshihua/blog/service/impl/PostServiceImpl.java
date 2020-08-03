package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.PostService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

}
