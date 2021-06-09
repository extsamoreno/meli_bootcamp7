package bootcamp.desafio.spring.service;

import bootcamp.desafio.spring.exception.DateException;
import bootcamp.desafio.spring.exception.PostUserNotFoundException;
import bootcamp.desafio.spring.model.Follow;
import bootcamp.desafio.spring.model.Post;
import bootcamp.desafio.spring.model.User;
import bootcamp.desafio.spring.model.id.PostId;
import bootcamp.desafio.spring.repository.IClientRepository;
import bootcamp.desafio.spring.repository.IFollowRepository;
import bootcamp.desafio.spring.repository.IPostRepository;
import bootcamp.desafio.spring.service.dto.PostDTO;
import bootcamp.desafio.spring.service.dto.PostRequestDTO;
import bootcamp.desafio.spring.service.dto.ProductFollowedDTO;
import bootcamp.desafio.spring.service.mapper.PostMapper;
import bootcamp.desafio.spring.service.mapper.PostRequestMapper;
import bootcamp.desafio.spring.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    IPostRepository iPostRepository;

    @Autowired
    IClientRepository iClientRepository;

    @Autowired
    IFollowRepository iFollowRepository;

    @Override
    public void addNewPost(PostRequestDTO postRequest) throws PostUserNotFoundException, DateException {
        Post post= PostRequestMapper.toPost(postRequest);
        Optional<User> user= iClientRepository.findById(post.getUserId());
        if(user.isPresent()){
            Optional<Post> postExist=iPostRepository.findById(new PostId(post.getUserId(),post.getIdPost()));
            if(postExist.isPresent()){
                ArrayList<Post> posts= user.get().getPosts();
                posts.remove(postExist.get());
            }
            iPostRepository.save(post);
            ArrayList<Post> newPost= user.get().getPosts();
            newPost.add(post);
            user.get().setPosts(newPost);
        }else{
            throw new PostUserNotFoundException(post.getUserId());
        }
    }

    @Override
    public ProductFollowedDTO getPostTheFollows(Long userId, String order) {
        ArrayList<PostDTO> result = new ArrayList<>();
        ArrayList<Follow> follows=iFollowRepository.findByIdFollowing(userId);
        for (Follow f: follows) {
            Optional<User> userOpt= iClientRepository.findById(f.getIdUserFollower());
            if(userOpt.isPresent()){
                for (Post post: userOpt.get().getPosts()
                 ) {
                    if(Utils.getDaysMinusNow(post.getDate())<14){
                        result.add(PostMapper.toDTO(post));
                    }
                }
            }
        }
        if(order.equals("")){
            result.sort((postX,postY) -> postY.getDate().compareTo(postX.getDate()));
        }else{
            result.sort((postX,postY) -> postX.getDate().compareTo(postY.getDate()));
        }

        return new ProductFollowedDTO(userId,result);
    }

    @Override
    public ArrayList<Post> getAll() {
        return iPostRepository.findAll();
    }

}
