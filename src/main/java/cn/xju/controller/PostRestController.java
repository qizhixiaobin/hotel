package cn.xju.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xju.dto.JsonResult;
import cn.xju.entity.Post;
import cn.xju.service.PostService;



@RestController
public class PostRestController {
    @Autowired
    PostService postService;

    @PostMapping("/admin/post/save")
    public JsonResult postSave(@RequestParam("postTitle") String postTitle,@RequestParam("postStatus") Integer postStatus,@RequestParam("postContent") String postContent,@RequestParam("cateId") Long cateId,@RequestParam("postThumbnail") String postThumbnail,@RequestParam("price") Integer price,@RequestParam("number")String number,@RequestParam("postEditor") String postEditor,HttpServletRequest request) {
        Long id = null;
        Post post = new Post();
        if(request.getParameter("id")!=null){
            id = Long.parseLong(request.getParameter("id"));
            post.setId(id);
        }
        post.setPostTitle(postTitle);
        post.setPostStatus(postStatus);
        post.setPostContent(postContent);
        post.setPostThumbnail(postThumbnail);
        post.setCateId(cateId);
        post.setPostEditor(postEditor);
        post.setNumber(number);
        post.setPostTitle(postTitle);
        post.setPrice(price);
        postService.insertOrUpdate(post);
        return JsonResult.success();
    }
    @PostMapping("/admin/post/revert")
    public JsonResult revert(@RequestParam("id") Long id) {
        Post post = postService.get(id);
        post.setPostStatus(2);
        postService.insertOrUpdate(post);
        return JsonResult.success();
    }

    @PostMapping("/admin/post/throw")
    public JsonResult Postthrow(@RequestParam("id") Long id) {
        Post post = postService.get(id);
        post.setPostStatus(0);
        postService.insertOrUpdate(post);
        return JsonResult.success();
    }
    @PostMapping("admin/post/delete")
    public JsonResult Postdelete(@RequestParam("id") Long id) {
        postService.delete(id);
        return JsonResult.success();
    }
    @PostMapping("/admin/post/batchDelete")
    public JsonResult PostbatchDelete(@RequestParam("ids") List<Long> ids) {
        postService.batchDelete(ids);
        return JsonResult.success();
    }
    

}
