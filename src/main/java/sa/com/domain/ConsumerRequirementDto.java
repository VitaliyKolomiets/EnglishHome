package sa.com.domain;

import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ConsumerRequirementDto {

    Long countConsumer;
    Long price;


}
