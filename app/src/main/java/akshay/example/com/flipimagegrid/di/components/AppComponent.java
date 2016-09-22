package akshay.example.com.flipimagegrid.di.components;

import javax.inject.Singleton;

import akshay.example.com.flipimagegrid.di.modules.AppModule;
import akshay.example.com.flipimagegrid.rest.IRetrofitClient;
import akshay.example.com.flipimagegrid.view.activities.MainActivity;
import dagger.Component;

/**
 * Created by akshay on 21/09/16.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject (MainActivity mainActivity);
    IRetrofitClient client();
}
