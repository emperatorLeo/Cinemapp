package com.independenciatecnologica.cinemapp.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.view.ContainerMovieFragment;
import com.independenciatecnologica.cinemapp.view.ContainerSeriesFragment;
import static com.independenciatecnologica.cinemapp.utils.Constants.TAG;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    public MainActivityViewModel(Application application) {
        super(application);

    }

    public boolean onNavigationItemSelected( MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.action_movies:
                Log.d(TAG,"Nav ItemSelected: movies");

              /*  transaction.replace(R.id.bigContainer,new ContainerMovieFragment());
                transaction.commit();*/
                break;

            case R.id.action_series:
               /* transaction2.replace(R.id.bigContainer,new ContainerSeriesFragment());
                transaction2.commit();*/
                Log.d(TAG,"Nav ItemSelected: series");
                break;
        }
        return true;
    }


}
