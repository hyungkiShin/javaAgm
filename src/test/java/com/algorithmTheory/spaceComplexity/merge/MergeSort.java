package com.algorithmTheory.spaceComplexity.merge;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
class MergeSort {


  @Test
  @DisplayName("배열을 앞뒤 두 배열로 자르는 코드 작성하기")
  void 배열을_앞뒤_두_배열로_자르는_코드_작성하기() {

      final ArrayList<Integer> dataList = new ArrayList<>(Arrays.asList(8,7,6,5,4,3,2,1));
      final ArrayList<Integer> integers = mergeSplitFunc(dataList);
      log.info("integers={}",integers);

  }

  ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
      if (dataList.size() <= 1) {
          return dataList;
      }
      int medium = dataList.size() / 2;
      System.out.println("medium = " + medium);

      ArrayList<Integer> leftArr = new ArrayList<Integer>();
      ArrayList<Integer> rightArr = new ArrayList<Integer>();

      leftArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));
      rightArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));

      return mergeFunc(leftArr, rightArr);
  }

    public static ArrayList<Integer> mergeFunc(final ArrayList<Integer> leftList, final ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE1: left/right 둘 다 있을 때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint += 1;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint += 1;
            }
        }

        // CASE2: right 데이터가 없을 때
        while (leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint += 1;
        }

        // CASE3: left 데이터가 없을 때
        while (rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint += 1;
        }

        return mergedList;
    }

}
