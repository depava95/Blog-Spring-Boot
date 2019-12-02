package ua.biedin.blog.service.interfaces;

import ua.biedin.blog.repository.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

}
