#include <iostream>
class Node{
public:
    int data;
    Node *next = nullptr;
};
class Stack{
    Node *head = nullptr;
public:
    void push(int x){
        Node *temp = new Node;
        temp->data = x;
        if (head == nullptr)
            head = temp;
        else{
            temp->next = head;
            head = temp;
        }
    }
    int top(){
        if (head != nullptr)
            return head->data;
        return -1;    
    }
    void pop(){
        if (head != nullptr){
            Node *temp = head;
            head = temp->next;
            delete temp;
        }
    }
    bool isEmpty(){
        return head == nullptr;
    }
    ~Stack(){
        if (head != nullptr){
            Node *temp = head;
            Node *temp2 = nullptr;
            while (temp != nullptr)
            {
                temp2 = temp->next;
                delete temp;
                temp = temp2;
            }
        }
    }
};
void test(){
    Stack s;
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    std::cout << s.top() << '\n';
    s.pop();
    s.pop();
    std::cout << s.isEmpty() << '\n';
    std::cout << s.top() << '\n';
}
int main(){
    test();
}
