package com.Desafio1.SocialMeli.Services;

import com.Desafio1.SocialMeli.DTOS.CreateUserDTO;
import com.Desafio1.SocialMeli.DTOS.FollowedListDTO;
import com.Desafio1.SocialMeli.DTOS.FollowerCountDTO;
import com.Desafio1.SocialMeli.DTOS.FollowerListDTO;
import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Exceptions.NotSellerException;
import com.Desafio1.SocialMeli.Exceptions.UserNotFoundException;
import com.Desafio1.SocialMeli.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Desafio1.SocialMeli.Repositories.IUserRepository;
import com.Desafio1.SocialMeli.Utils.Utils;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public List<User> newUser(CreateUserDTO createUserDTO) throws DuplicateIdException {
        List<User> userList;
        try {
            // Creo la lista de usuarios con el Dto que se paso en el RequestBody
            userList = iUserRepository.createUser(createUserDTO);
        } catch (DuplicateIdException ex) {
            throw ex;
        }
        return userList;
    }

    // Obtengo la lista completa de usuarios
    @Override
    public List<User> getUsers() {
        return iUserRepository.readUsers();
    }

    @Override
    public void followSeller(int userId, int userIdToFollow) throws UserNotFoundException, DuplicateIdException, NotSellerException {
        try {
            // Recupero los datos del seller
            User seller = iUserRepository.searchUserById(userIdToFollow);
            // Solo sigo a un usuario si es vendedor, sino tiro una excepcion
            if (seller.isSeller()) {
                // Recupero los datos del buyer
                User buyer = iUserRepository.searchUserById(userId);

                iUserRepository.followSeller(buyer, seller);
            } else {
                throw new NotSellerException("El usuario al que se quiere seguir no es un vendedor.");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void updateUser(User seller) {
        this.iUserRepository.updateUser(seller);
    }

    @Override
    public FollowerCountDTO getFollowersCount(int userID) throws UserNotFoundException {
        User seller;
        try {
            //Recupero datos del vendedor
            seller = iUserRepository.searchUserById(userID);
        } catch (Exception ex) {
            throw ex;
        }
        // Retorno los datos solicitados a traves del vendedor
        return new FollowerCountDTO(seller.getUserId(), seller.getUserName(), seller.getFollowers().size());
    }

    @Override
    public FollowerListDTO getFollowersByUserId(int userID, String sortBy) throws UserNotFoundException {
        User seller;
        try {
            seller = iUserRepository.searchUserById(userID); //Recupero los datos del venededor
            seller.getFollowers().sort((a, b)-> Utils.sortBy(a, b, sortBy)); //Ordeno los followers a criterio del usuario
        }
        catch (Exception ex){
            throw ex;
        }
        return new FollowerListDTO(seller.getUserId(), seller.getUserName(), seller.getFollowers());
    }

    @Override
    public FollowedListDTO getFollowedByUserId(int userID, String sortBy) throws UserNotFoundException {
        User buyer;
        try {
            buyer = iUserRepository.searchUserById(userID); //Recupero los datos del comprador
            buyer.getFollowed().sort((a, b)-> Utils.sortBy(a, b, sortBy)); //Ordeno los followed a criterio del usuario
        }
        catch (Exception ex){
            throw ex;
        }
        return new FollowedListDTO(buyer.getUserId(), buyer.getUserName(), buyer.getFollowed());
    }

    @Override
    public User searchUserById(int userId) throws UserNotFoundException {
        return this.iUserRepository.searchUserById(userId);
    }


}
