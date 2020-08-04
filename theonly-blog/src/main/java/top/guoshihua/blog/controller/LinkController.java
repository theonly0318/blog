package top.guoshihua.blog.controller;

import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.api.LinkApi;
import top.guoshihua.blog.entity.Link;
import top.guoshihua.blog.service.LinkService;

import java.util.List;

/**
 * @author guoshihua
 */
@Api(value = "友情链接API")
@RestController
@RequestMapping("/link")
public class LinkController implements LinkApi {

	@Autowired
	private LinkService linkService;

	@Override
	@GetMapping("/list")
	public List<Link> list() {
		return linkService.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Link findById(@PathVariable("id") Integer id) {
		return linkService.findById(id);
	}

	@Override
	@GetMapping("/page")
	public Page<Link> findByPage(
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "rows", defaultValue = "10") Integer rows,
			@RequestParam(name = "sortBy", required = false) String sortBy,
			@RequestParam(name = "desc", required = false) Boolean desc) {
		return linkService.findByPage(page, rows, sortBy, desc);
	}

	@Override
	@PostMapping("/save")
	public void save(Link link) {
		linkService.save(link);
	}

	@Override
	@PutMapping("/update")
	public void update(Link link) {
		linkService.update(link);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		linkService.deleteById(id);
	}
}
