package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.CommentService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

}
