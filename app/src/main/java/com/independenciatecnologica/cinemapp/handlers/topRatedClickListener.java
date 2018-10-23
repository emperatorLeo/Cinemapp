package com.independenciatecnologica.cinemapp.handlers;

import com.independenciatecnologica.cinemapp.model.MoviePopular;
import com.independenciatecnologica.cinemapp.model.MovieTopRated;

public interface topRatedClickListener {
    public void detailsTopRated(MovieTopRated item);
}
interface popular{
    public void detailsPopular(MoviePopular item);
}
