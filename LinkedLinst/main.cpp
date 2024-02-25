#include <iostream>
using std::cout;
struct Node{
    int data;
    Node *next;
};
Node *head;
class LinkedList{
public:
    LinkedList(){
        head = nullptr;
    }
    void add (int value){
        Node *temp = new Node;
        temp->data = value;
        temp->next = nullptr;
        temp->next = head;
        head = temp;
    }
    void add(int value, int postion){
        Node *temp = new Node;
        temp->data = value;
        temp->next = nullptr;
        Node *temp2 = head;
        for (int i = 0; i < postion - 2; ++i){
            temp2 = temp2->next;
        }
        temp->next = temp2->next;
        temp2->next = temp;
    }
    void remove(){
        Node *temp = head;
        while (temp->next->next != nullptr)
            temp = temp->next;
        Node *temp2 = temp->next;
        temp->next = nullptr;
        delete temp2;
    }
    void remove(int n){
        Node *temp = head;
        if (n == 1){
            head = temp->next;
            delete temp;
            return;
        }
        for (int i = 0; i < n-2; ++i)
            temp = temp->next;
        Node *temp2 = temp->next;
        temp->next = temp2->next;
        delete temp2;
    }
    void print(){
        Node *temp = head;
        while (temp != nullptr){
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << std::endl;
    }
    void reverse(Node *p){
        if (p->next == nullptr){
            head = p;
            return ;
        }
        reverse(p->next);
        Node *q = p->next;
        q->next = p;
        p->next = nullptr;
    }
    ~LinkedList(){
        Node *temp = head;
        while (temp != nullptr){
            delete temp;
            temp = temp->next;
        }
    }
};
int main(){
    LinkedList l;
    l.add(1);
    l.add(2);
    l.add(3);
    //l.print();
    l.add(4,3);

    //l.print();
    //l.remove(2);
    l.print();
    l.reverse(head);
    l.print();


    


}
