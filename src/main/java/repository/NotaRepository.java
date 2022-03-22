package repository;

import curent.domain.*;
import validation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NotaRepository extends AbstractCrudRepository<Long,Nota> {
    public NotaRepository(Validator<Nota> validator) {
        super(validator);
    }
}

