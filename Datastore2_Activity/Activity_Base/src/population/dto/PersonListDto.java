package population.dto;

import java.util.ArrayList;
import java.util.List;

public class PersonListDto extends BaseDto {

    private List<PersonDto> persons = new ArrayList<PersonDto>();

    public List<PersonDto> getEntries() {
        return persons;
    }

    public void setEntries(List<PersonDto> persons) {
        this.persons = persons;
    }

}