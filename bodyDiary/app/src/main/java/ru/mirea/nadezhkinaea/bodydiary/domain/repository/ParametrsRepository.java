package ru.mirea.nadezhkinaea.bodydiary.domain.repository;

import ru.mirea.nadezhkinaea.bodydiary.domain.models.Parametrs;

public interface ParametrsRepository {
    public boolean saveParametrs(Parametrs parametrs);
    public Parametrs getParametrs();
}
