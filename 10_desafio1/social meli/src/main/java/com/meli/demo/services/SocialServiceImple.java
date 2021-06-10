package com.meli.demo.services;


import com.meli.demo.dtos.*;
import com.meli.demo.exceptions.FollowException;
import com.meli.demo.exceptions.PostDiscountException;
import com.meli.demo.exceptions.PostException;
import com.meli.demo.models.Post;
import com.meli.demo.models.Seller;
import com.meli.demo.repositories.SocialRepository;
import com.meli.demo.services.mappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
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
            return "todo OK";
        }
        else{
            throw new FollowException();
        }

    }

    @Override
    public CountUsersDTO countUsers(int userid) {
        return CountUserMapper.toDTO(FollowRepository.countUsers(userid));
    }

    @Override
    public LisUsersResponseDTO listUsers(int iduser) {
        Seller Sellers = new Seller();
        Sellers=FollowRepository.listUsers(iduser);
        LisUsersResponseDTO list=  new LisUsersResponseDTO();
        list.setUserId(Sellers.getId());
        list.setUserName(Sellers.getNombre());
        list.setFollowers(Sellers.getUsuarios());
        return list;
    }

    @Override
    public ListSellersResponseDTO listVendedores(int iduser) {
        return ListSellerMapper.toDTO(FollowRepository.listVendedores(iduser));
    }

    @Override
    public String newPost(PostResponseDTO publi) throws PostException {

        ;
        if(FollowRepository.newPost(PostMapper.ResponsetoDTOPost(publi))){
            return "todo OK";
        }
        else{
            throw new PostException();
        }
    }
    public static String formatearCalendar(Calendar c) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
        return df.format(c.getTime());
    }

    @Override
    public ListSellersPostDTO listPostVendedors(int iduser) {
        ListSellersPostDTO lis= new ListSellersPostDTO();
        lis= ListSellerPostMapper.toDTO(FollowRepository.getListPostVendedors(iduser));
        List<String> dateArray = new ArrayList<String>();
        List<String> dateArray2 = new ArrayList<String>();
        Calendar date = new Calendar.Builder().build();
        List<Date> dates = new ArrayList<>();
        List<Date> dates1 = new ArrayList<Date>();
        List<Date> dates2 = new ArrayList<Date>();
        ArrayList<PostResponseDTO> post = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        Date Today=c.getTime();
        c.add(Calendar.DAY_OF_YEAR, -14);
        Date TwoWeeks=c.getTime();
        Date test2=c.getTime();

        for (int i = 0; i < lis.getPosts().size(); i++) {

            dateArray.add(lis.getPosts().get(i).getDate());

        }
        for (int i = 0; i <dateArray.size() ; i++) {
            String[] parts = dateArray.get(i).split("-");
            date.set(Integer.parseInt(parts[2]), (Integer.parseInt(parts[1])-1), Integer.parseInt(parts[0]));
            dates.add(date.getTime());
        }


        for (int i = 0; i < dates.size(); i++) {
            if(Today.compareTo(dates.get(i)) * dates.get(i).compareTo(TwoWeeks) >= 0){
                dates2.add(dates.get(i));
            }
        }

        dates1 =dates2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        dateArray2=modifyDate(dates1);

        for (int i = 0; i < dateArray2.size(); i++) {

            for (int j = 0; j < lis.getPosts().size(); j++) {

                if(dateArray2.get(i).equals(lis.getPosts().get(j).getDate())){
                    post.add(lis.getPosts().get(j));
                }

            }
        }
       lis.setPosts(post);
        return lis;
    }

    @Override
    public String unFollow(int userid, int usertofollow) throws FollowException {
        if(FollowRepository.unFollow(userid,usertofollow)){
            return "todo OK";
        }
        else{
            throw new FollowException();
        }
    }

    @Override
    public ListSellersPostDTO orderDateAscDesc(int UserID, String order) {
        ListSellersPostDTO lis= new ListSellersPostDTO();
        lis=ListSellerPostMapper.toDTO(FollowRepository.getListPostVendedors(UserID));


        return orderAscDescArrayDate(lis,order);
    }
    @Override
    public ListSellersPostDTO orderNameAscDesc(int UserID, String order) {
        ListSellersPostDTO lis= new ListSellersPostDTO();
        lis=ListSellerPostMapper.toDTO(FollowRepository.getListPostVendedors(UserID));
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
        ArrayList<PostResponseDTO> post = new ArrayList<>();
        if(order.equals("date_desc")){

            for (int i = 0; i < list.getPosts().size(); i++) {

                dateArray.add(list.getPosts().get(i).getDate());
            }

            for (int i = 0; i <dateArray.size() ; i++) {
                String[] parts = dateArray.get(i).split("-");
                date.set(Integer.parseInt(parts[2]), (Integer.parseInt(parts[1])-1), Integer.parseInt(parts[0]));
                dates.add(date.getTime());
            }
            dates1 =dates.stream().sorted().collect(Collectors.toList());
            dateArray2=modifyDate(dates1);

            for (int i = 0; i < dateArray2.size(); i++) {
                for (int j = 0; j < list.getPosts().size(); j++) {
                    if(dateArray2.get(i).equals(list.getPosts().get(j).getDate())){
                        post.add(list.getPosts().get(j));

                    }

                }
            }
            lis.setPosts(post);

        }else{


            for (int i = 0; i < list.getPosts().size(); i++) {

                dateArray.add(list.getPosts().get(i).getDate());

            }
            for (int i = 0; i <dateArray.size() ; i++) {
                String[] parts = dateArray.get(i).split("-");
                date.set(Integer.parseInt(parts[2]), (Integer.parseInt(parts[1])-1), Integer.parseInt(parts[0]));
                dates.add(date.getTime());
            }
            dates1 =dates.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            dateArray2=modifyDate(dates1);
            for (int i = 0; i < dateArray2.size(); i++) {

                for (int j = 0; j < list.getPosts().size(); j++) {

                    if(dateArray2.get(i).equals(list.getPosts().get(j).getDate())){
                        post.add(list.getPosts().get(j));
                    }
                }
            }
            lis.setPosts(post);
        }

        return lis;

    }

    public ListSellersPostDTO orderAscDescArrayName(ListSellersPostDTO list, String order){

        ListSellersPostDTO lis= new ListSellersPostDTO();

        List<String> nameArray = new ArrayList<String>();
        ArrayList<PostResponseDTO> post = new ArrayList<>();

        lis.setUserId(list.getUserId());
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

    @Override
    public String newPostDiscount(PostDTO poubli) throws PostDiscountException {

        if(FollowRepository.newPostDiscount(PostMapper.toPostDiscount(poubli))){
            return "ok";
        }
        else{
            throw new PostDiscountException();
        }
    }

    @Override
    public CountDiscountSelleDTO countDiscount(int idUser) {

        CountDiscountSelleDTO count = new CountDiscountSelleDTO();
        Seller vendedor = new Seller();
        vendedor=FollowRepository.getVendedor(idUser);
        count.setUserId(vendedor.getId());
        count.setUserName(vendedor.getNombre());
        Integer contador =0;
        for (int i = 0; i < vendedor.getPublicacions().size(); i++) {
            if(vendedor.getPublicacions().get(i).isHasPromo()){
                contador+=1;
            }
        }
        count.setPromoproducts_count(contador);

        return count;
    }

    @Override
    public ListDiscountDTO listDiscount(int iduser) {
        ListDiscountDTO list = new ListDiscountDTO();
        ArrayList<PostDTO> postDiscount = new ArrayList<>();
        SellerDTO vendedor = new SellerDTO();
        vendedor= SellerMapper.toDTO(FollowRepository.getVendedor(iduser));
        list.setId(vendedor.getId());
        list.setUserName(vendedor.getNombre());

        for (int i = 0; i < vendedor.getPublicacions().size(); i++) {
            if(vendedor.getPublicacions().get(i).isHasPromo()){
                postDiscount.add(vendedor.getPublicacions().get(i));
            }
        }
        list.setPosts(postDiscount);

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
        ArrayList<PostDTO> post = new ArrayList<>();

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
