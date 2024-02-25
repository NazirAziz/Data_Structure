#include <iostream>
const int Max_Size = 10;
class Circular_Queue{
    int arr[Max_Size]{};
    int front = -1, end = -1;
public:
    bool isempty(){
        return (front == -1 && end == -1);
    }
    void push(int x){
        if ((end + 1) % Max_Size == front){
            std::cout << "Full\n";
            return;
        }
        if (isempty()){
            ++front; ++end;
        }else{
            end = (end + 1) % Max_Size;
        }
        arr[end] = x;
    }
    int Front(){
        return arr[front];
    }
    void pop(){
        if (isempty())
            return;
        front = (front + 1) % Max_Size;
    }
};

void test(){
    Circular_Queue cq;
    std::cout << cq.isempty() << '\n';
    cq.push(1);
    cq.push(2);
    cq.push(3);
    cq.push(4);
    cq.push(5);
    cq.push(6);
    cq.push(7);
    cq.push(8);
    cq.push(9);
    cq.push(10);
    cq.push(11);
    cq.push(12);
    std::cout << cq.Front() << '\n';
    cq.pop();
    cq.pop();
    cq.pop();
    std::cout << cq.Front() << '\n';
}
int main(){
    test();
}
