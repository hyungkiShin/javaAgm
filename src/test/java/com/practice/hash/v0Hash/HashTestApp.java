package com.practice.hash.v0Hash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HashTestApp {

    Hash hash = new Hash(20);

    public Integer hashFunc(String key) {
        return (int)(key.charAt(0)) % hash.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = hashFunc(key);
        if (hash.hashTable[address] != null) {
            hash.hashTable[address].value = value;
        } else {
            hash.hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        System.out.println("key = " + key);
        Integer address = hashFunc(key);
        if(hash.hashTable[address] != null) {
            return hash.hashTable[address].value;
        } else {
            return null;
        }
    }

    /**
     * key 가 문자열일때, 문자열의 앞 글자를 숫자로 변환해서, Division 기법을 사용하여, key 에 대한 주소(인덱스 번호) 계산
     *  * Division 기법: 가장 간단한 해쉬 함수 중 하나로, 나누기를 통해, 나머지 값을 사용하는 기법
     */
    @Test
    @DisplayName("초간단 해쉬 함수1")
    void 초간단_해쉬_함수1() {
        String name = "David gudrl";
        int hihi = name.charAt(0) % 20; // Division 기법
        System.out.println("hihi = " + hihi);
    }

    @Test
    @DisplayName("초간단 해쉬 함수2")
    void 초간단_해쉬_함수2() {
        String name = "David gudrl";
        int ASCII_CODE = (int) name.charAt(0);
        System.out.println("ASCII_CODE = " + ASCII_CODE);
        Integer result = hashFunc(name);
        System.out.println("result = " + result);
    }

    @Test
    @DisplayName("해쉬 충돌(Hash Collision)")
    void Division_기법으로_데이터의_충돌이_나야_한다() {
        saveData("DaveLee", "01022223333");
        saveData("fun-coding", "01033334444");
        saveData("David", "01044445555");
        String daveLee = getData("DaveLee");
        System.out.println("fewfew = " + daveLee);
    }



}
