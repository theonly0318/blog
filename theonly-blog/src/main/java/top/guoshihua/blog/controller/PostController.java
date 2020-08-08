package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.api.PostApi;
import top.guoshihua.blog.common.response.PageResult;
import top.guoshihua.blog.common.response.ResponseResult;
import top.guoshihua.blog.entity.Post;
import top.guoshihua.blog.service.PostService;

import java.util.List;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/post")
public class PostController implements PostApi {

	@Autowired
	private PostService postService;

	@Override
	@GetMapping("/list")
	public List<Post> list() {
		return postService.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Post findById(@PathVariable String id) {
		return postService.findById(id);
	}

	@Override
	@GetMapping("/page")
	public PageResult<Post> findByPage(@RequestParam(name = "page", defaultValue = "1") Integer page,
									   @RequestParam(name = "rows", defaultValue = "10") Integer rows,
									   @RequestParam(name = "sortBy", required = false) String sortBy,
									   @RequestParam(name = "desc", required = false) Boolean desc) {
		return postService.findByPage(page, rows, sortBy, desc);
	}

	@Override
	@PostMapping("/")
	public ResponseResult save(Post post) {
		return postService.save(post);
	}

	@Override
	@PutMapping("/")
	public ResponseResult update(Post post) {
		return postService.update(post);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseResult delete(@PathVariable String id) {
		return postService.delete(id);
	}

	@Override
	@PutMapping("/type/{id}")
	public ResponseResult updateTypeById(@PathVariable String id) {
		return postService.updateTypeById(id);
	}

	@Override
	@PutMapping("/status/{id}")
	public ResponseResult updateStatusById(@PathVariable String id,
										   @RequestParam(name = "status") Integer status) {
		return postService.updateStatusById(id, status);
	}

	@Override
	@PutMapping("/priority/{id}")
	public ResponseResult updateTopById(@PathVariable String id, @RequestParam(name = "priority") Integer priority) {
		return postService.updatePriorityById(id, priority);
	}

	@Override
	@PatchMapping("/password/{id}")
	public ResponseResult updatePasswordById(@PathVariable String id, String password) {
		return postService.updatePasswordById(id, password);
	}

}
