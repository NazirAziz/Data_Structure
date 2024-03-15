#include <iostream>
using namespace std;
class Vector
{
private:
	int index = -1;
	int arr [100];
public:
	// to get value
	void insert (int a)
	{
		if (index == 99)
			cout << "Vector is full" << '\n';
		else
		{
			index++;
			arr[index] = a;
		}
	}
	// to check if our vector is empty
	bool isEmpty ()
	{
		return (index == -1);
	}
	// return the value at a specific position
	int at(int a)
	{
		if (a > 99 || a < 0)
			cout << "Invalid" << '\n';
		else
			return arr[a];
		return -1;
	}
	// returns the number of elements in the vector
	int count ()
	{
		return index + 1;  
	}
};
void testVector()
{
	Vector v;
	v.insert(0);
	v.insert(1);
	v.insert(2);
	v.insert(3);
	v.insert(4);
	v.insert(5);
	v.insert(6);
	v.insert(7);
	v.insert(8);
	v.insert(9);
	v.insert(10);
	for (int i = 0; i < v.count(); ++i)
		cout << v.at(i) << " ";
}
void testVector2()
{
	Vector v;
	for (int i = 0; i <= 100; ++i)
		v.insert(i);
	
}
int main() 
{
	testVector2();
	
	return 0;
}
