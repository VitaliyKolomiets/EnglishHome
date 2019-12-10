package sa.com.assembler;

import java.util.List;

public interface Assembler<ENTITY, DTO> {

    List<DTO> toDTOs(Iterable<ENTITY> entities);

    DTO toDTO(ENTITY entity);

    List<ENTITY> toEntities(Iterable<DTO> dtos);

    ENTITY toEntity(DTO dto);

    ENTITY update(ENTITY entity, DTO dto);
}
