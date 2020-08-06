package top.guoshihua.blog.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import top.guoshihua.blog.dao.LinkMapper;
import top.guoshihua.blog.entity.Link;
import top.guoshihua.blog.service.LinkService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.util.UuidUtil;

import java.util.List;
import java.util.Optional;

/**
 * @author guoshihua
 */
@Service("linkService")
@Transactional
public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkRepository linkRepository;
	@Autowired
	private LinkMapper linkMapper;

	@Override
	public List<Link> findAll() {
		return linkRepository.findAll();
	}

	@Override
	public Link findById(String id) {
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

	@Override
	public Link save(Link link) {
		Link c = linkRepository.findFirstByName(link.getName());
		if (c != null) {
			return null;
		}
		String id = UuidUtil.getUUIDStr();
		link.setId(id);
		linkMapper.insertSelective(link);
		return linkRepository.findById(id).get();
	}

	@Override
	public Link update(Link link) {
		return linkRepository.save(link);
	}

	@Override
	public void deleteById(String id) {
		linkRepository.deleteById(id);
	}
}
