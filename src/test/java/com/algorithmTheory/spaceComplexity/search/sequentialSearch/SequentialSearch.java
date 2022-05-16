package com.algorithmTheory.spaceComplexity.search.sequentialSearch;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SequentialSearch {

    ArrayList<Integer> dataList = new ArrayList<Integer>(List.of(6,4,1,3,2,5));


    @Test
    @DisplayName("순차 탐색")
    void 순차_탐색() {
        log.info("extracted(dataList)={}",extracted(dataList));

    }

    private int extracted(ArrayList<Integer> dataList) {
        int searchData = 5;
        for (int index = 0; index < dataList.size(); index++) {
            if(dataList.get(index) == searchData) {
                return index;
            }
        }
        return -1;
    }
}
