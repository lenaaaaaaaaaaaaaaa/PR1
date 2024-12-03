package ru.mirea.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.bodydiary.viewmodels.CatViewModel;
import ru.mirea.bodydiary.viewmodels.LoginViewModel;
import ru.mirea.bodydiary.viewmodels.MainViewModel;
import ru.mirea.bodydiary.viewmodels.MenuViewModel;
import ru.mirea.bodydiary.viewmodels.ProfileViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        DependenciesProvider provider = DependenciesProvider.getInstance(null);
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(
                    provider.getAuthRepository(),
                    provider.getRouter()
            );
        }
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(
                    provider.getUserRepository(),
                    provider.getSignInUseCase(),
                    provider.getSignUpUseCase(),
                    provider.getRouter()
            );
        }
        if (modelClass.isAssignableFrom(MenuViewModel.class)) {
            return (T) new MenuViewModel(
                    new LoginViewModel(
                            provider.getUserRepository(),
                            provider.getSignInUseCase(),
                            provider.getSignUpUseCase(),
                            provider.getRouter()
                    ),
                    provider.getRouter()
            );
        }
        if (modelClass.isAssignableFrom(ProfileViewModel.class)) {
            return (T) new ProfileViewModel(
                    provider.getAuthRepository(),
                    provider.getUserRepository()
            );
        }
        if (modelClass.isAssignableFrom(CatViewModel.class)) {
            return (T) new CatViewModel(
                    //provider.getRoomCatRepository()
                    provider.getRetrofitCatRepository()
            );
        }
        throw new IllegalArgumentException("Unknown viewmodel type: " + modelClass.getName());
    }
}
