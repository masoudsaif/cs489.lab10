package com.cs489.taskmanagement.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs489.taskmanagement.model.Comment;
import com.cs489.taskmanagement.repositories.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(int commentId) {
        return commentRepository.findById(commentId);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(int commentId, Comment updatedComment) {
        return commentRepository.findById(commentId)
                .map(existingComment -> {
                    existingComment.setUser(updatedComment.getUser());
                    existingComment.setTask(updatedComment.getTask());
                    existingComment.setContent(updatedComment.getContent());
                    existingComment.setTimestamp(updatedComment.getTimestamp());
                    return commentRepository.save(existingComment);
                })
                .orElse(null);
    }

    public void deleteComment(int commentId) {
        commentRepository.deleteById(commentId);
    }
}