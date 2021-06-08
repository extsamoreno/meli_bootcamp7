package desafio1.demo.Service;

import desafio1.demo.Exception.DuplicatePostIDException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.DTO.NewPostDTO;
import desafio1.demo.Model.Entity.Post;
import desafio1.demo.Repository.IRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    IRepository iRepository;
    ModelMapper modelMapper;

    public ProductService(IRepository iRepository, ModelMapper modelMapper) {
        this.iRepository = iRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addNewPost(NewPostDTO newPostDTO) throws DuplicatePostIDException, UserNotFoundException {
        var post = modelMapper.map(newPostDTO, Post.class);
        iRepository.addNewPost(post);
    }
}
