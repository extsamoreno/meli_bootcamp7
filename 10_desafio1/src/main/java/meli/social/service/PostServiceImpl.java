package meli.social.service;

import meli.social.exception.UserIdNotFoundException;
import meli.social.model.PostModel;
import meli.social.model.UserModel;
import meli.social.repository.DataRepository;
import meli.social.service.dto.PostDTO;
import meli.social.service.dto.PostListUserDTO;
import meli.social.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.sql.Date;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    DataRepository dataRepository;

    @Override
    public List<PostModel> getAllPosts() {
        return dataRepository.getPostsDb();
    }

    @Override
    public void addPost(PostModel post) throws UserIdNotFoundException {
        int userId = post.getUserId();
        dataRepository.findUserById(userId);
        dataRepository.savePostDb(post);
    }

    @Override
    public PostListUserDTO getPostsOfFollowed(int id, String order) throws UserIdNotFoundException, ParseException {
        UserModel user = dataRepository.findUserById(id);
        List<PostModel> allPosts = dataRepository.getPostsDb();

        // Recolectando todos los posts de los seguidores
        List<PostDTO> postsFoundDTO = new ArrayList<>();
        for (int i = 0; i < user.getFollowed().size(); i++) {
            for (PostModel post: allPosts) {
                if(post.getUserId() == user.getFollowed().get(i)) {
                    postsFoundDTO.add(PostMapper.toPostDTO(post));
                }
            }
        }

        // Ordenando la lista por fecha ascendente y descendente
        Comparator<PostDTO> dateComparator = Comparator.comparing(p -> p.getDate());
        if (order.equals("date_asc")) postsFoundDTO.sort(dateComparator);
        postsFoundDTO.sort(dateComparator.reversed());

        // Filtrando por últimas dos semanas
        Date twoWeeks = Date.valueOf(LocalDate.now().minusWeeks(2));
        List<PostDTO> postsFoundDTOByDate = postsFoundDTO.stream().filter(postDTO -> postDTO.getDate()
                .after(twoWeeks)).collect(Collectors.toList());

        // Armando la lista de posteos de seguidores
        PostListUserDTO postsListOfFollowed = new PostListUserDTO();
        postsListOfFollowed.setUserId(id);
        postsListOfFollowed.setPosts(postsFoundDTOByDate);

        return postsListOfFollowed;
    }
}
