package unit.mapper;

import com.meli.calculatorHouseSquareMeters.model.dao.model.Room;
import com.meli.calculatorHouseSquareMeters.model.dto.RoomResponseDTO;
import com.meli.calculatorHouseSquareMeters.model.mapper.RoomMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RoomMapperTest {

    @Test
    public void toRoomResponseDTOCorrectly() {
        //
        RoomResponseDTO expected = new RoomResponseDTO("Habitación 1", 100);

        Room room = new Room("Habitación 1", 10, 10);

        // Act
        RoomResponseDTO received = RoomMapper.toRoomResponseDTO(room);

        // Assert
        assertEquals(expected, received);
    }
}
