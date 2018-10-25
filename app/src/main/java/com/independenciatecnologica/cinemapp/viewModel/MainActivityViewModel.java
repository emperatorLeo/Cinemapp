package com.independenciatecnologica.cinemapp.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuItem;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.view.ContainerMovieFragment;
import com.independenciatecnologica.cinemapp.view.ContainerSeriesFragment;
import static com.independenciatecnologica.cinemapp.utils.Constants.TAG;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<String> query = new MutableLiveData<>();
    private MutableLiveData<String> querySearch = new MutableLiveData<>();
    private boolean focusable = false;
    private final SearchView.OnQueryTextListener onQueryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String s) {
            querySearch.setValue(s);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {
            query.setValue(s);

            return false;
        }
    };

    public boolean isFocusable() {
        return focusable;
    }

    public void setFocusable(boolean focusable) {
        this.focusable = focusable;
    }
    public void setQuery (String query){
        this.query.setValue(query);
    }

    public LiveData<String>getQuery(){
        return query;
    }

    public LiveData<String> getQuerySearch() {
        return querySearch;
    }

    public void setQuerySearch(MutableLiveData<String> querySearch) {
        this.querySearch = querySearch;
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {

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

    @BindingAdapter("queryTextListener")
    public static void onQueryTextListener(SearchView searchView,SearchView.OnQueryTextListener listener){
      searchView.setOnQueryTextListener(listener);
    }
    public SearchView.OnQueryTextListener getOnQueryTextListener(){
        return onQueryTextListener;
    }




}
