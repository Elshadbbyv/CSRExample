package csr.example.csrexample.dao.repository;

import csr.example.csrexample.dao.entity.CardEntity;
import csr.example.csrexample.dao.entity.PersonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity,Long> {
    @Override
    Optional<PersonEntity> findById(Long id);

    @Query(value = "select * from group_j4.person", nativeQuery = true)
    List<PersonEntity> getAll();

    @Query(value = "select * from group_j4.person where id =:id", nativeQuery = true)
    Optional<PersonEntity> findByIdCustom(@Param("id") Long id);
}
