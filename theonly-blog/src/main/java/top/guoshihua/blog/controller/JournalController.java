package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.service.JournalService;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/journal")
public class JournalController {

	@Autowired
	private JournalService journalService;

}
