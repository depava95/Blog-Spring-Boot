package ua.biedin.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.biedin.blog.entity.Comment;
import ua.biedin.blog.repository.CommentRepo;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepo commentRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }
}
