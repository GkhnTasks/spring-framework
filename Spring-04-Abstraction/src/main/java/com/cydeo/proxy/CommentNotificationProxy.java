package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.stereotype.Component;

@Component
public interface CommentNotificationProxy {

    void sendComment(Comment comment);
}
