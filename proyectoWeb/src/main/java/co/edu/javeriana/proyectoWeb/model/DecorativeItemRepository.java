package co.edu.javeriana.proyectoWeb.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecorativeItemRepository extends CrudRepository<DecorativeItem, Long>
{
    
}
