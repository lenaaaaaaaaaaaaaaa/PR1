package ru.mirea.nadezhkinaea.bodydiary.domain.usecases.parametrs;

import ru.mirea.nadezhkinaea.bodydiary.domain.models.Parametrs;

public class SaveParametrsToMyParametrsUseCase {
    public boolean execute(Parametrs parametrs){
        if (parametrs.getName().isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}
