package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.api.TagApi;
import top.guoshihua.blog.common.response.PageResult;
import top.guoshihua.blog.common.response.ResponseResult;
import top.guoshihua.blog.entity.Tag;
import top.guoshihua.blog.service.TagService;

import java.util.List;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/tag")
public class TagController implements TagApi {

	@Autowired
	private TagService tagService;

	@Override
	@GetMapping("/list")
	public List<Tag> list() {
		return tagService.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Tag findById(@PathVariable("id") String id) {
		return tagService.findById(id);
	}

	@Override
	@GetMapping("/page")
	public PageResult<Tag> findByPage(@RequestParam(name = "page", defaultValue = "1") Integer page,
									  @RequestParam(name = "rows", defaultValue = "10") Integer rows,
									  @RequestParam(name = "sortBy", required = false) String sortBy,
									  @RequestParam(name = "desc", required = false) Boolean desc) {
		return tagService.findByPage(page, rows, sortBy, desc);
	}

	@Override
	@PostMapping("/")
	public ResponseResult save(Tag tag) {
		return tagService.save(tag);
	}

	@Override
	@PutMapping
	public ResponseResult update(Tag tag) {
		return tagService.update(tag);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseResult delete(@PathVariable("id") String id) {
		return tagService.delete(id);
	}
}
