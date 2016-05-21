package com.javarush.test.level28.lesson15.big01.view;


import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by alexander on 16.05.16.
 */
public interface View
{

    void update(List<Vacancy> vacancies);
}

