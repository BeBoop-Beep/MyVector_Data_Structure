public class MyVector<E> extends MyAbstractList<E> {
    private E[] myList;
    private int size;
    private int capacityIncrement = 5;
    ;


    @SuppressWarnings("unchecked")
    public MyVector() {
        myList = (E[]) new Object[10];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyVector(int initCapacity) {
        myList = (E[]) new Object[initCapacity];

    }


    @SuppressWarnings("unchecked")
    public MyVector(int initCapacity, int capacityIncrement){
        this.capacityIncrement = capacityIncrement;
        myList = (E[]) new Object[initCapacity];
    }


    public int getCapacity(){
        return myList.length;
    }


    public int getIncrement(){
        return capacityIncrement;
    }

    @SuppressWarnings("unchecked")
    public boolean add(E data) {
        if (myList.length == size) {
            E[] tempList = myList;
            myList = (E[]) new Object[myList.length + capacityIncrement];
            for(int i = 0; i < tempList.length; i++){
                myList[i] = tempList[i];
            }
        }
        myList[size] = data;
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public boolean add(int index, E data) throws IndexOutOfBoundsException {
        try {
            if (myList.length == size) {
                E[] tempList = myList;
                myList = (E[]) new Object[myList.length + capacityIncrement];

                for (int i = 0; i < tempList.length; i++) {
                    myList[i] = tempList[i];
                }
            }
            E[] tempList = myList;
            for(int i= 0; i < index; i++) {
               myList[i] = tempList[i];
            }

            myList[index]= data;
            size++;

            for(int i = index + 1; i < myList.length; i++){
               myList[i] = tempList[i -1];
            }
        }
        catch(IndexOutOfBoundsException error){
            System.out.println("The Index selected is not within the array capacity. Please try again");
        }
        return true;
    }


    @SuppressWarnings("unchecked")
    public void clear(){
        myList = (E[]) new Object[myList.length];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) throws IndexOutOfBoundsException{
        try {
            for (int i = 0; i < myList.length; i++) {
                if (i == index) {
                    return myList[i];
                }
            }
        }
        catch(IndexOutOfBoundsException error) {
                System.out.println("The Index selected is not within the array capacity. Please try again");
            }
        return myList[index];
    }


    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) throws IndexOutOfBoundsException {
        try {
            E removedElement = myList[index];
            E[] tempList = myList;

            for (int i = 0; i < myList.length-1; i++) {
                if (i < index) {
                    myList[i] = tempList[i];
                }
                else {
                    myList[i] = tempList[i + 1];
                    size--;
                }
            }
            return removedElement;
        }
        catch(IndexOutOfBoundsException error){
            System.out.println("The Index selected is not within the array capacity. Please try again");
        }
        return myList[index];
    }

    @SuppressWarnings("unchecked")
    public void trimToSize(){
        E[] tempList = myList;
        myList = (E[]) new Object[size];
        for(int i = 0; i < size; i++){
            myList[i] = tempList[i];
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString(){
        String returnedString = "[";
        for (int i = 0; i < size; i++){
            if(i == size - 1){
                returnedString += myList[i];
            }
            else {
                returnedString += myList[i] + ", ";
            }
        }
        return returnedString + "]";
    }
}


