class Data{
    int data;
    int key;
}
class HashTable{
    private int size;
    private int numberOfData;
    private Data[] hashTable;
    private int hashing(int key){
        return key % size;
    }
    HashTable(int size){
        this.size = size * 2;
        hashTable = new Data[this.size];
    }
    public boolean insert(int key, int data){
        if (numberOfData == (size / 2))
            return false;
        Data d = new Data();
        d.key = key;
        d.data = data;

        int index = hashing(key);
        while (hashTable[index] != null && hashTable[index].data != -1){
            index = (index + 1) % size;
        }
        hashTable[index] = d;
        numberOfData++;
        return true;
    }
    public int search(int key){
        int index = hashing(key);
        while (hashTable[index] != null && hashTable[index].data != -1){
            if (hashTable[index].key == key)
                return hashTable[index].data;
            index = (index + 1) % size;
        }
        return -1;
    }
    public void delete(int key){
        int index = hashing(key);
        while (hashTable[index] != null && hashTable[index].data != -1){
            if (hashTable[index].key == key)
                hashTable[index].data = -1;
            index = (index + 1) % size;
        }
    }
}
public class HashTableDriver {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(3);
            hashTable.insert(5, 100);
            hashTable.insert(43, 10);
            hashTable.insert(6, 1);
            // System.out.println(hashTable.insert(7, 9));
            hashTable.delete(5);
            System.out.println(hashTable.search(5));
            System.out.println(hashTable.search(43));
            System.out.println(hashTable.search(6));
            System.out.println(hashTable.search(9));
    }
    
}
