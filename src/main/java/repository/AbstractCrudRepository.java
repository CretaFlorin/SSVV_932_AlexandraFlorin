package repository;

import curent.domain.BaseEntity;
import validation.ValidationException;
import validation.Validator;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCrudRepository <ID, E extends BaseEntity<ID>> implements CrudRepository<ID, E> {
    private Map<ID, E> entities;
    Validator<E> validator;


    /**
     * Class constructor
     */
    AbstractCrudRepository(Validator validator){
        this.entities = new HashMap<>();
        this.validator = validator;

    }

    /**
     *
     * @param id -the id of the entity to be returned
     * id must not be null
     * @return obiectul cu id-ul respectiv sau null daca obiectul nu exista
     */
    @Override
    public E findOne(ID id) {
        return this.entities.get(id);
    }

    /**
     *
     * @return toate obiectele
     */
    @Override
    public Iterable<E> findAll() {
        return this.entities.values();
    }

    /**
     * Salveaza un obiect in memorie
     * @param entity - obiectul pe care il salveaza
     * entity must be not null
     * @return null daca obiectul a fost salvat sau obiectul daca acesta exista deja
     */
    @Override
    public E save(E entity)
      throws ValidationException {
            try {
                validator.validate(entity);
                return entities.putIfAbsent(entity.getId(), entity);
            }
            catch (ValidationException ve) {
                System.out.println("Entitatea nu este valida! \n");
                return null;
            }
        }



    /**
     * sterge un obiect din memorie
     * @param id - id-ul obiectului
     * id must be not null
     * @return obiectul sters
     */
    @Override
    public E delete(ID id) {
        return this.entities.remove(id);
    }

    /**
     * modifica un obiect
     * @param entity - noul obiect
     * entity must not be null
     * @return null daca obiectul a fost modificat sau obiectul daca acesta nu exista in memorie
     */
    @Override
    public E update(E entity) {
        if(this.entities.get(entity.getId()) == null){
            return entity;
        }
        this.entities.replace(entity.getId(), entity);
        return null;
    }
}
