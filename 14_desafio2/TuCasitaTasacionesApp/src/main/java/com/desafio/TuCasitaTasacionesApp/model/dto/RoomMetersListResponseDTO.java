package com.desafio.TuCasitaTasacionesApp.model.dto;

import java.util.ArrayList;

public class RoomMetersListResponseDTO {

    private ArrayList<RoomMetersResponseDTO> roomMetersResponseDTOList;

    public RoomMetersListResponseDTO() {
        roomMetersResponseDTOList = new ArrayList<>();
    }

    public void add(RoomMetersResponseDTO roomMetersResponseDTO) {
        roomMetersResponseDTOList.add(roomMetersResponseDTO);
    }

    public void setRoomMetersResponseDTOList(ArrayList<RoomMetersResponseDTO> roomMetersResponseDTOList) {
        this.roomMetersResponseDTOList = roomMetersResponseDTOList;
    }

    public ArrayList<RoomMetersResponseDTO> getList() {
        return this.roomMetersResponseDTOList;
    }
}
