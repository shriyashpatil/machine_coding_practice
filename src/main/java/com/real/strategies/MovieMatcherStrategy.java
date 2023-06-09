package com.real.strategies;

import com.real.matcher.Matcher;

import java.util.List;

public interface MovieMatcherStrategy {

     List<Matcher.IdMapping> matchMovie(Matcher.CsvStream finderData);

}
