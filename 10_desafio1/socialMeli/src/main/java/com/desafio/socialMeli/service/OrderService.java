package com.desafio.socialMeli.service;

import com.desafio.socialMeli.service.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;


@Service
class OrderService implements IOrderService{



    /* ACLARACION:
    * Este metodo ordena por date. No me alcanzo el tiempo para implementar el punto 9, pero es un metodo get que usa esta funcion la cual esta
    * funcionando correctamente para la fecha en ambos ordenes.
    * Respecto al ordenamiento para ver las ultimas dos semanas, no me funciono. Me falto parsear el date nuevamente a string y luego compararlo.
    * Tuve problemas con las librerias de Date.
    * */
    @Override
    public List <PostDTO> orderPostByDate(List<PostDTO> postDTOS, String order){

        HashMap <Integer, PostDTO> mapPostDTO = new HashMap<>();
        ArrayList<PostDTO> arrayListPostDTO = new ArrayList<PostDTO>();
        ArrayList<String> stringArrayList = new ArrayList<String>();
        ArrayList<String> stringArrayListAux = new ArrayList<String>();

        int index = 0;

        for(index = 0; index< postDTOS.size(); index++) stringArrayList.add(postDTOS.get(index).getDate());

        Collections.sort(stringArrayList);

        if(order.equals("date_asc")) Collections.reverse(stringArrayList);


        if (order.equals("date_asc_2W")) {

            Date dateBeforeTwoWeeks = getDateBeforeTwoWeeks();
            System.out.println("la fecha de hace dos semanas es: " +dateBeforeTwoWeeks);

            ArrayList<Date> dates = new ArrayList<Date>();
            ArrayList<Date> datesAux = new ArrayList<Date>();

            for(PostDTO p: postDTOS)  dates.add(p.stringToDate(p.getDate()));


            for(Date date : dates) {
                if(date.compareTo(dateBeforeTwoWeeks) > 0) {
                    System.out.println("La fecha" + date + "es mayor que " + dateBeforeTwoWeeks);
                    datesAux.add(date);
                }
            }

            for(int i = 0; i<datesAux.size();i++)
                stringArrayListAux.add(dateToString(datesAux.get(i)));


            stringArrayList.clear();
            stringArrayList.addAll(stringArrayListAux);
            Collections.reverse(stringArrayList);

        }


        for(PostDTO p : postDTOS) {
            for (String date : stringArrayList) {
                System.out.println("el date es:" +date);
                System.out.println("el date es:" +p.getDate());
                if (p.getDate().equals(date)){
                    mapPostDTO.put(stringArrayList.indexOf(p.getDate()) , p);
                    System.out.println("Hubo match ");
                    System.out.println("Lo que estoy cargando es: " + mapPostDTO.get(date.indexOf(p.getDate())));
                }
            }
        }

        System.out.println("el orden ess: " + stringArrayList);

        for(int i = 0; i<mapPostDTO.size(); i++) arrayListPostDTO.add(mapPostDTO.get(i));

        return arrayListPostDTO;
    }

    private String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    private static Date getDateBeforeTwoWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14);
        return calendar.getTime();
    }

}
