package ru.mirea.nadezhkinaea.bodydiary.domain.usecases.parametrs;

import ru.mirea.nadezhkinaea.bodydiary.domain.models.Parametrs;

public class GetMyParametrsUseCase {
    public Parametrs execute(){
        return new Parametrs(3, "Ваш вес - 55 кг");
    }
}
