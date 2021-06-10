package com.desafio.socialMeli.service;

import com.desafio.socialMeli.service.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;


@Service
class OrderService implements IOrderService{

    @Override
    public List <PostDTO> orderPostByDate(List<PostDTO> postDTOS, String order){

        HashMap <Integer, PostDTO> mapPostDTO = new HashMap<>();
        ArrayList<PostDTO> arrayListPostDTO = new ArrayList<PostDTO>();
        ArrayList<String> stringArrayList = new ArrayList<String>();

        int index = 0;

        for(index = 0; index< postDTOS.size(); index++) stringArrayList.add(postDTOS.get(index).getDate());

        Collections.sort(stringArrayList);

        if(order.equals("date_asc")) Collections.reverse(stringArrayList);
        if (order.equals("date_asc_2W")) {

            Date calendario = getDateBeforeTwoWeeks();
            System.out.println("la fecha de hace dos semanas es: " +calendario);

            Calendar fecha2 = new GregorianCalendar(2016,7,5);

            ArrayList<Calendar> fechaAux = new ArrayList<Calendar>();

            ArrayList<String> stringArrayListAux = new ArrayList<String>();
            for(String e : stringArrayList) {
                stringArrayListAux.add(e);
                if (e.equals(calendario)) {
                    break;
                }
            }
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

    private static Date getDateBeforeTwoWeeks() {
/*        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDateTime calendar = LocalDateTime.now().minusDays(14);
        //String formatter = formmat1.format(calendar);
        return calendar;
    }
*/

        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14);
        return calendar.getTime();
    }

}

