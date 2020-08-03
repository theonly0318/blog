package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.PhotoService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoRepository photoRepository;

}
