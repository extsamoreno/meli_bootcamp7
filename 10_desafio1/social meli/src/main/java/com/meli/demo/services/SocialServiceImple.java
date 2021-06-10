package com.meli.demo.services;


import com.meli.demo.dtos.*;
import com.meli.demo.exceptions.FollowException;
import com.meli.demo.exceptions.PostDiscountException;
import com.meli.demo.exceptions.PostException;
import com.meli.demo.repositories.SocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SocialServiceImple implements SocialService {


    @Autowired
    SocialRepository FollowRepository;

    @Override
    public String Follow(int userid, int usertofollow) throws FollowException {

        FollowRepository.cargarDatos();

        if(FollowRepository.Follow(userid,usertofollow)){
            return "ok";
        }
        else{
            throw new FollowException();
        }

    }

    @Override
    public CountUsersDTO countUsers(int userid) {
        return FollowRepository.countUsers(userid);
    }

    @Override
    public LisUsersResponseDTO listUsers(int iduser) {
        return FollowRepository.listUsers(iduser);
    }

    @Override
    public ListSellersResponseDTO listVendedores(int iduser) {
        return FollowRepository.listVendedores(iduser);
    }

    @Override
    public String newPost(PostDTO poubli) throws PostException {
        if(FollowRepository.newPost(poubli)){
            return "ok";
        }
        else{
            throw new PostException();
        }
    }

    @Override
    public ListSellersPostDTO listPostVendedors(int iduser) {
        ListSellersPostDTO lis= new ListSellersPostDTO();
        lis=FollowRepository.listPostVendedors(iduser);


        List<String> dateArray = new ArrayList<String>();
        ArrayList<PostDTO> post = new ArrayList<>();

        for (int i = 0; i < lis.getPublicacions().size(); i++) {

            dateArray.add(lis.getPublicacions().get(i).getDate());

        }
        Collections.sort(dateArray);

        for (int i = 0; i < dateArray.size(); i++) {

            for (int j = 0; j < lis.getPublicacions().size(); j++) {

                if(dateArray.get(i).equals(lis.getPublicacions().get(j).getDate())){
                    post.add(lis.getPublicacions().get(j));
                }

            }


        }
       lis.setPublicacions(post);
        return lis;
    }

    @Override
    public void unFollow(int userid, int usertofollow) throws FollowException {
        if(FollowRepository.unFollow(userid,usertofollow)){

        }
        else{
            throw new FollowException();
        }
    }

    @Override
    public ListSellersPostDTO orderDateAscDesc(int UserID, String order) {
        ListSellersPostDTO lis= new ListSellersPostDTO();
        lis=FollowRepository.listPostVendedors(UserID);


        return orderAscDescArrayDate(lis,order);
    }
    @Override
    public ListSellersPostDTO orderNameAscDesc(int UserID, String order) {
        ListSellersPostDTO lis= new ListSellersPostDTO();
        lis=FollowRepository.listPostVendedors(UserID);
        return orderAscDescArrayName(lis,order);
    }

    public static List<String> modifyDate( List<Date> dates1){
        List<String> dateArray2 = new ArrayList<String>();

        for (int i = 0; i <dates1.size() ; i++) {
            String[] dateSplit = dates1.get(i).toString().split(" ");

            switch (dateSplit[1].toString()){
                case"Jan":
                    dateArray2.add(dateSplit[2].toString()+"-"+"01"+"-"+dateSplit[5].toString());
                    break;
                case"Feb":
                    dateArray2.add(dateSplit[2].toString()+"-"+"02"+"-"+dateSplit[5].toString());
                    break;
                case"Mar":
                    dateArray2.add(dateSplit[2].toString()+"-"+"03"+"-"+dateSplit[5].toString());
                    break;
                case"Apr":
                    dateArray2.add(dateSplit[2].toString()+"-"+"04"+"-"+dateSplit[5].toString());
                    break;
                case"May":
                    dateArray2.add(dateSplit[2].toString()+"-"+"05"+"-"+dateSplit[5].toString());
                    break;
                case"Jun":
                    dateArray2.add(dateSplit[2].toString()+"-"+"06"+"-"+dateSplit[5].toString());
                    break;
                case"Jul":
                    dateArray2.add(dateSplit[2].toString()+"-"+"07"+"-"+dateSplit[5].toString());
                    break;
                case"Aug":
                    dateArray2.add(dateSplit[2].toString()+"-"+"08"+"-"+dateSplit[5].toString());
                    break;
                case"Sep":
                    dateArray2.add(dateSplit[2].toString()+"-"+"09"+"-"+dateSplit[5].toString());
                    break;
                case"Oct":
                    dateArray2.add(dateSplit[2].toString()+"-"+"10"+"-"+dateSplit[5].toString());
                    break;
                case"Nov":
                    dateArray2.add(dateSplit[2].toString()+"-"+"11"+"-"+dateSplit[5].toString());
                    break;
                default:
                    dateArray2.add(dateSplit[2].toString()+"-"+"12"+"-"+dateSplit[5].toString());

            }
        }
        return dateArray2;
    }


    public ListSellersPostDTO orderAscDescArrayDate(ListSellersPostDTO list, String order){

        ListSellersPostDTO lis= new ListSellersPostDTO();

        List<String> dateArray = new ArrayList<String>();
        List<String> dateArray2 = new ArrayList<String>();
        Calendar date = new Calendar.Builder().build();
        List<Date> dates = new ArrayList<>();
        List<Date> dates1 = new ArrayList<Date>();
        ArrayList<PostDTO> post = new ArrayList<>();
        if(order.equals("date_desc")){

            for (int i = 0; i < list.getPublicacions().size(); i++) {

                dateArray.add(list.getPublicacions().get(i).getDate());
            }

            for (int i = 0; i <dateArray.size() ; i++) {
                String[] parts = dateArray.get(i).split("-");
                date.set(Integer.parseInt(parts[2]), (Integer.parseInt(parts[1])-1), Integer.parseInt(parts[0]));
                dates.add(date.getTime());
            }
            dates1 =dates.stream().sorted().collect(Collectors.toList());
            dateArray2=modifyDate(dates1);

            for (int i = 0; i < dateArray2.size(); i++) {
                for (int j = 0; j < list.getPublicacions().size(); j++) {
                    if(dateArray2.get(i).equals(list.getPublicacions().get(j).getDate())){
                        post.add(list.getPublicacions().get(j));

                    }

                }
            }
            lis.setPublicacions(post);

        }else{


            for (int i = 0; i < list.getPublicacions().size(); i++) {

                dateArray.add(list.getPublicacions().get(i).getDate());

            }
            for (int i = 0; i <dateArray.size() ; i++) {
                String[] parts = dateArray.get(i).split("-");
                date.set(Integer.parseInt(parts[2]), (Integer.parseInt(parts[1])-1), Integer.parseInt(parts[0]));
                dates.add(date.getTime());
            }
            dates1 =dates.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            dateArray2=modifyDate(dates1);
            for (int i = 0; i < dateArray2.size(); i++) {

                for (int j = 0; j < list.getPublicacions().size(); j++) {

                    if(dateArray2.get(i).equals(list.getPublicacions().get(j).getDate())){
                        post.add(list.getPublicacions().get(j));
                    }
                }
            }
            lis.setPublicacions(post);
        }

        return lis;

    }

    public ListSellersPostDTO orderAscDescArrayName(ListSellersPostDTO list, String order){

        ListSellersPostDTO lis= new ListSellersPostDTO();

        List<String> nameArray = new ArrayList<String>();
        ArrayList<PostDTO> post = new ArrayList<>();

        lis.setId(list.getId());
        if(order.equals("name_desc")){
            for (int i = 0; i < list.getPublicacions().size(); i++) {

                nameArray.add(list.getPublicacions().get(i).getDetail().getProductName());

            }
            Collections.sort(nameArray);


            for (int i = 0; i < nameArray.size(); i++) {
                for (int j = 0; j < list.getPublicacions().size(); j++) {
                    if(nameArray.get(i).equals(list.getPublicacions().get(j).getDetail().getProductName())){
                        post.add(list.getPublicacions().get(j));
                    }
                }
            }
            lis.setPublicacions(post);


        }else{


            for (int i = 0; i < list.getPublicacions().size(); i++) {

                nameArray.add(list.getPublicacions().get(i).getDetail().getProductName());

            }
            Collections.sort(nameArray);
            Collections.sort(nameArray, Collections.reverseOrder());

            for (int i = 0; i < nameArray.size(); i++) {

                for (int j = 0; j < list.getPublicacions().size(); j++) {

                    if(nameArray.get(i).equals(list.getPublicacions().get(j).getDetail().getProductName())){
                        post.add(list.getPublicacions().get(j));
                    }

                }


            }
            lis.setPublicacions(post);

        }

        return lis;

    }

    @Override
    public String newPostDiscount(PostDiscountDTO poubli) throws PostDiscountException {

        if(FollowRepository.newPostDiscount(poubli)){
            return "ok";
        }
        else{
            throw new PostDiscountException();
        }
    }

    @Override
    public CountDiscountSelleDTO countDiscount(int idUser) {

        CountDiscountSelleDTO count = new CountDiscountSelleDTO();
        SellerDTO vendedor = new SellerDTO();
        vendedor=FollowRepository.getVendedor(idUser);
        count.setUserId(vendedor.getId());
        count.setUserName(vendedor.getNombre());
        count.setPromoproducts_count(vendedor.getPostDto().size());

        return count;
    }

    @Override
    public ListDiscountDTO listDiscount(int iduser) {
        ListDiscountDTO list = new ListDiscountDTO();
        SellerDTO vendedor = new SellerDTO();
        vendedor=FollowRepository.getVendedor(iduser);
        list.setId(vendedor.getId());
        list.setUserName(vendedor.getNombre());
        list.setPosts(vendedor.getPostDto());

        return list;
    }

    @Override
    public ListDiscountDTO orderDtoNameDesc(int UserID, String order) {
        ListDiscountDTO list = new ListDiscountDTO();
        list=listDiscount(UserID);
        return orderDtoNameDesc(list,order);
    }

    public ListDiscountDTO orderDtoNameDesc(ListDiscountDTO list, String order){

        ListDiscountDTO lis= new ListDiscountDTO();

        List<String> nameArray = new ArrayList<>();
        ArrayList<PostDiscountDTO> post = new ArrayList<>();

        lis.setUserName(list.getUserName());
        lis.setId(list.getId());
        if(order.equals("name_desc")){

            for (int i = 0; i < list.getPosts().size(); i++) {

                nameArray.add(list.getPosts().get(i).getDetail().getProductName());

            }
            Collections.sort(nameArray);

            for (int i = 0; i < nameArray.size(); i++) {

                for (int j = 0; j < list.getPosts().size(); j++) {

                    if(nameArray.get(i).equals(list.getPosts().get(j).getDetail().getProductName())){
                        post.add(list.getPosts().get(j));
                    }

                }


            }

            lis.setPosts(post);


        }else{


            for (int i = 0; i < list.getPosts().size(); i++) {

                nameArray.add(list.getPosts().get(i).getDetail().getProductName());

            }
            Collections.sort(nameArray);
            Collections.sort(nameArray, Collections.reverseOrder());

            for (int i = 0; i < nameArray.size(); i++) {

                for (int j = 0; j < list.getPosts().size(); j++) {

                    if(nameArray.get(i).equals(list.getPosts().get(j).getDetail().getProductName())){
                        post.add(list.getPosts().get(j));
                    }

                }


            }
            lis.setPosts(post);

        }

        return lis;

    }


}
