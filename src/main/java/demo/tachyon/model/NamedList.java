package demo.tachyon.model;

import demo.tachyon.dto.CreateNamedListDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "lists")
public class NamedList {

    @Id
    private String id;

    private String name;
    private String ownerId;

    private List<Task> tasks = new ArrayList<>();

    public static NamedList from(CreateNamedListDTO dto) {
        NamedList namedList = new NamedList();
        namedList.setName(dto.getName());
        namedList.setOwnerId(dto.getOwnerId());
        return namedList;
    }
}
