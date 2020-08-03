package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.JournalService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class JournalServiceImpl implements JournalService {

	@Autowired
	private JournalRepository journalRepository;
}
