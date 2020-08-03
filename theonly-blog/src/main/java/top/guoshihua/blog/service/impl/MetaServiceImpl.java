package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.MetaService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class MetaServiceImpl implements MetaService {

	@Autowired
	private MetaRepository metaRepository;

}
