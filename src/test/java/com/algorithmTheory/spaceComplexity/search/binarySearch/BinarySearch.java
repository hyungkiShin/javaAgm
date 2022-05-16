package com.algorithmTheory.spaceComplexity.search.binarySearch;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class BinarySearch {

    ArrayList<Integer> dataList = new ArrayList<Integer>();

    @BeforeEach
    void init() {
        // given
        for (int index = 0; index < 100; index++) {
            dataList.add((int) (Math.random() * 10));
        }
        dataList = (ArrayList<Integer>) dataList.stream().distinct().collect(Collectors.toList());

        log.info("dataList={}",dataList);
    }

    @Test
    @DisplayName("이진 탐색")
    void 이진_탐색() {
        log.info("data={}",searchFunc(dataList, 5) );
    }
    public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        if(dataList.size() == 1 && searchItem.equals(dataList.get(0))) {
            return true;
        }
        if(dataList.size() == 1 && !searchItem.equals(dataList.get(0))) {
            return false;
        }
        if(dataList.size() == 0) {
            return false;
        }

        int medium = dataList.size() / 2;

        if(searchItem.equals(dataList.get(medium))) {
            return true;
        } else {
            if(searchItem < dataList.get(medium)) {
                return this.searchFunc(new ArrayList<Integer>(dataList.subList(0, medium)), searchItem);
            } else {
                return this.searchFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())), searchItem);
            }
        }
    }
}
