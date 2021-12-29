package africa.semicolon.BlogApplication.data.repository;

import africa.semicolon.BlogApplication.data.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {
    List<Post> posts = new ArrayList<>();

    @Override
    public Post save(Post post) {
        posts.add(post);
        return findPostByText(post.getText());
    }

    private Post findPostByText(String text) {
        for(Post post: posts){
            if(post.getText().equals(text)){
                return post;
            }
        }
        return null;
    }


    @Override
    public void deleteById(Long along) {

        posts.remove(posts);
    }


    @Override
    public Post findPostById(Post entity) {
       for(Post post: posts){
           if(post.getId().equals(entity)){
                return entity;
           }
       }
        return null ;
    }



    @Override
    public List<Post> findAll() {

        return posts;
    }
}

