package sa.com.repository.jpa;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
@Transactional(readOnly = true)
public interface SoftDeleteRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    @Override
    @Query("select e from #{#entityName} e where e.deleted = false")
    List<T> findAll(Sort sort);

    @Override
    @Query("select e from #{#entityName} e where e.deleted = false")
    Page<T> findAll(Pageable pageable);

    @Override
    @Query("select e from #{#entityName} e where e.deleted = false")
    List<T> findAll();

    @Override
    @Query("select e from #{#entityName} e where e.deleted = false and e.id in :ids")
    List<T> findAllById(Iterable<ID> ids);

    @Override
    @Query("select e from #{#entityName} e where e.deleted = false and e.id = :id")
    T getOne(ID id);

    @Override
    @Query("select e from #{#entityName} e where e.deleted = false and e.id = :id")
    Optional<T> findById(ID id);

    @Override
    @Query("select "
            + "case when count(e)>0 then true else false end "
            + "from #{#entityName} e where e.deleted = false and e.id = :id")
    boolean existsById(ID id);

    @Override
    @Query("select count(e) from #{#entityName} e where e.deleted = false")
    long count();

    /**
     * Softly delete entity by id by setting deleted = true
     */
    @Modifying
    @Transactional
    @Query("update #{#entityName} set deleted = true where id = :id")
    void softDelete(ID id);

    /**
     * Softly delete entities by id by setting deleted = true
     */
    @Modifying
    @Transactional
    @Query("update #{#entityName} set deleted = true where id in :ids")
    void softDeleteAll(Iterable<ID> ids);

    /**
     * @return list of softly deleted entities
     */
    @Query("select e from #{#entityName} e where e.deleted = true")
    List<T> findAllDeleted();

    /**
     * @param id entity id
     * @return softly deleted entity
     */
    @Query("select e from #{#entityName} e where e.deleted = true and e.id = :id")
    T findDeleted(ID id);

    default T mergeIgnoreFields(T source, T target, String[] ignoreFields) {
        BeanUtils.copyProperties(source, target, ignoreFields);
        return save(target);
    }

}
