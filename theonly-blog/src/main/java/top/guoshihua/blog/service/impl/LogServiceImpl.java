package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.LogService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogRepository logRepository;

}
