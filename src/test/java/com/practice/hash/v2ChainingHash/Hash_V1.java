package com.practice.hash.v2ChainingHash;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hash_V1 {
    public Slot[] hashTable;

    public Hash_V1(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot next;

        public Slot(final String key, final String value, final String next) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // 인덱스 제조기
    public Integer hashFunction(String key) {
        return (int) key.charAt(0) % this.hashTable.length;
    }

    // 해당 인덱스에 정보를 저장한다.
    public void saveHash(String key, String value) {
        Integer address = hashFunction(key);
        extracted(key, value, address);
    }

    private void extracted(final String key, final String value, final Integer address) {
        if (hashTable[address] != null) {
            Slot triggerSlot = this.hashTable[address];
            Slot saveSlot = this.hashTable[address];
            while (triggerSlot != null) {
                if(triggerSlot.key == key) {
                    triggerSlot.value = value;
                    return;
                } else {
                    saveSlot = triggerSlot;
                    triggerSlot = triggerSlot.next;
                }
            }
            saveSlot.next = new Slot(key, value, null);
            log.info("this.hashTable[address]={}", this.hashTable[address]);
        } else {
            log.info("key={}, value={}, this.hashTable[address]={}", key, value, this.hashTable[address]);
            this.hashTable[address] = new Slot(key, value, null);
        }
    }

    // 해쉬테이블 key 에 접근후, 해당하는 값을 가져온다
    public String getDataFunction(String key) {
        Integer address = hashFunction(key);
        if(hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            while (findSlot != null) {
                if(findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
        }
        return "No Data";
    }
}
