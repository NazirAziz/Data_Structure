class Heap{
    private int[] array;
    private int current;
    public Heap(int size){
        this.array = new int[size];
        this.current = 0;
    }
    public boolean insert(int num){
        if (current == array.length)
            return false;
        array[current] = num;
        takeItUp(current++);
        return true;
    }
    private void takeItUp(int loc){
        int temp = array[loc];
        int parent = (loc - 1) / 2;
        while (loc > 0 && array[parent] < temp){
            array[loc] = array[parent];
            loc = parent;
            parent = (loc - 1) / 2;
        }
        array[loc] = temp;
    }
    public int pop(){
        int temp = array[0];
        array[0] = array[--current];
        takeItDown(0);
        return temp;
    }
    private void takeItDown(int loc){
        int largerChild;
        int top = array[loc];

        while (loc < current / 2){
            int leftChild = 2 * loc + 1;
            int rightChild = leftChild + 1;

            if (rightChild < current && array[leftChild] < array[rightChild])
                largerChild = rightChild;
            else
                largerChild = leftChild;

            if (top >= array[largerChild])
                break;
            array[loc] = array[largerChild];
            loc = largerChild;
        }
        array[loc] = top;
    }
    public void display(){
        for (int i = 0; i < current; ++i){
            System.out.print(array[i] + " ");
        }
        System.out.println( );
    }
}


class HeapDriver{
    public static void main(String[] args) {
        Heap heap = new Heap(7);
        heap.insert(100);
        heap.insert(50);
        heap.insert(80);
        heap.insert(25);
        heap.insert(30);
        heap.insert(45);
        heap.insert(190);
        heap.display();
        heap.pop();
        heap.display();
        heap.pop();
        heap.display();
        heap.pop();
        heap.display();
        heap.pop();
        heap.display();
        heap.pop();

    }
}
