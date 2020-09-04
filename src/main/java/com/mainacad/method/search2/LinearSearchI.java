package com.mainacad.method.search2;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LinearSearchI {
    private List<Integer> list;

    public LinearSearchI(List<Integer> list) {
        this.list = list;
    }

    public Integer findOneSimilarTo(Integer criterion) {
        Optional<Integer> res = list.stream()
                .filter(x -> x.equals(criterion)).findFirst();
        if (res.isPresent()) {
            return res.get();
        }
        return null;
    }

    public List<Integer> findAllSimilarTo(Integer criterion) {
        List<Integer> result = null;

        List<Integer> finded = list.stream()
                .filter(x -> x.equals(criterion))
                .collect(Collectors.toList());
        if (!list.isEmpty()) result = finded;

        return result;
    }
}
