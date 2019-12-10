package sa.com.assembler;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RequiredArgsConstructor
public abstract class AbstractAssembler<ENTITY, DTO> implements Assembler<ENTITY, DTO> {

    private final Class<ENTITY> entityClass;
    private final Class<DTO> dtoClass;

    protected ModelMapper mapper = new ModelMapper();

    @Override
    public List<DTO> toDTOs(Iterable<ENTITY> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DTO toDTO(ENTITY entity) {
        return entity == null ? null : mapper.map(entity, dtoClass);
    }

    @Override
    public List<ENTITY> toEntities(Iterable<DTO> dtos) {
        return StreamSupport.stream(dtos.spliterator(), false)
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ENTITY toEntity(DTO dto) {
        return dto == null ? null : mapper.map(dto, entityClass);
    }

    @Override
    public ENTITY update(ENTITY entity, DTO dto) {
        mapper.map(dto, entity);
        return entity;
    }
}
