package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.OptionService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class OptionServiceImpl implements OptionService {

	@Autowired
	private OptionRepository optionRepository;

}
