package top.guoshihua.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.AttachmentRepository;
import top.guoshihua.blog.service.AttachmentService;

/**
 * @author guoshihua
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	private AttachmentRepository attachmentRepository;

}
