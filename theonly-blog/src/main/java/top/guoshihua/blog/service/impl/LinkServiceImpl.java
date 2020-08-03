package top.guoshihua.blog.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.*;
import top.guoshihua.blog.entity.Link;
import top.guoshihua.blog.service.LinkService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author guoshihua
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkRepository linkRepository;

	@Override
	public List<Link> findAll() {
		return linkRepository.findAll();
	}

	@Override
	public Link findById(Integer id) {
		Optional<Link> optionalLink = linkRepository.findById(id);
		return optionalLink.get();
	}

	@Override
	public Page<Link> findByPage(Integer page, Integer rows, String sortBy, Boolean desc) {
		Pageable pageable = null;
		if (StringUtils.isNotBlank(sortBy)) {
			sortBy = "createTime";
		}
		if (desc == null) {
			desc = true;
		}
		page = page == null || page < 0 ? 0: page-1;
		if (desc) {
			pageable = PageRequest.of(page, rows,Sort.by(sortBy).descending());
		} else {
			pageable = PageRequest.of(page, rows,Sort.by(sortBy).ascending());
		}
		Page<Link> linkPage = linkRepository.findAll(pageable);
		return linkPage;
	}
}
