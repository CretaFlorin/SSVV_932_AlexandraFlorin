package repository;

import curent.domain.Tema;
import validation.*;

public class TemaRepository extends AbstractCrudRepository<Long, Tema> {
    public TemaRepository(Validator<Tema> validator) {
        super(validator);
    }
}
