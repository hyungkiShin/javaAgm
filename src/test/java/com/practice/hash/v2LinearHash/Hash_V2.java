package com.practice.hash.v2LinearHash;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hash_V2 {
    public Slot[] hashTable;

    public Hash_V2(Integer size) {
        this.hashTable = new Slot[size];
    }

    public static class Slot {
        String key;
        String value;

        public Slot(final String key, final String value) {
            this.key = key;
            this.value = value;
        }
    }

    // 인덱스 제조기
    public Integer hashFunction(String key) {
        return (int) key.charAt(0) % this.hashTable.length;
    }

    // 해당 인덱스에 정보를 저장한다.
    public void saveHashes(String key, String value) {
        Integer address = hashFunction(key);
        extracted(key, value, address);
    }

    private void extracted(final String key, final String value, final Integer address) {
        if (hashTable[address] != null) {
            if(hashTable[address].key.equals(key)) {
                hashTable[address].value = value;
            } else {
                int currAddress = address + 1;
                while (hashTable[currAddress] != null) {
                    if (hashTable[currAddress].key == key) {
                        hashTable[currAddress].value = value;
                        return;
                    } else {
                        currAddress ++;
                        if(currAddress >= hashTable.length) {
                            return;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
    }

    // 해쉬테이블 key 에 접근후, 해당하는 값을 가져온다
    public String getDataFunction(String key) {
        Integer address = hashFunction(key);
        if(hashTable[address] != null) {
            if(hashTable[address].key.equals(key)) {
                return hashTable[address].value;
            } else {
                Integer currAddress = address + 1;
                while (hashTable[currAddress] != null) {
                    if(hashTable[currAddress].key == key) {
                        return hashTable[currAddress].value;
                    } else {
                        currAddress ++;
                        if(currAddress >= hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        }
        return "No Data";
    }
}
