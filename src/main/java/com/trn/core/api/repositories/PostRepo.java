package com.trn.core.api.repositories;

import com.trn.core.api.entities.Category;
import com.trn.core.api.entities.Post;
import com.trn.core.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

}
