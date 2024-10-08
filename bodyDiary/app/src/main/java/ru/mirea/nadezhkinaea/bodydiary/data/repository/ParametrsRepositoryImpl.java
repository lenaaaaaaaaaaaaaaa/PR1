package ru.mirea.nadezhkinaea.bodydiary.data.repository;

import ru.mirea.nadezhkinaea.bodydiary.domain.models.Parametrs;
import ru.mirea.nadezhkinaea.bodydiary.domain.repository.ParametrsRepository;

public class ParametrsRepositoryImpl implements ParametrsRepository {

    @Override
    public boolean saveParametrs(Parametrs parametrs) {
        return false;
    }

    @Override
    public Parametrs getParametrs(){
        return new Parametrs(1, "lalal");
    }
}
