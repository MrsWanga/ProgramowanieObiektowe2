package Lab8;

public class SinglyLinkedList<E> implements List<E>{
    Item first;
    Item last;
    int amount;
    class Item {
        E data;
        Item next;

        public Item(E data) {
            this.data = data;
            this.next = null;
        }
    }
    @Override
    public boolean add(E element) {

        try {
            Item nItem = new Item(element);
            if (this.amount==0) {
                this.first = nItem;
            }
            last.next = nItem;
            last = nItem;
            amount++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void add(int index, E element) {
        Item item = this.first;
        Item nItem = new Item(element);
        for (int i=0; i<index-1; i++ ) {
            item=item.next;
        }
        nItem.next=item.next;
        item.next=nItem;
        amount++;
    }

    @Override
    public void clear() {
        Item item = this.first;
        Item tmp;
        for (int i=0; i<amount; i++) {
        item.data=null;
        tmp=item.next;
        item.next=null;
        item=tmp;
        }
    }

    @Override
    public boolean contains(Object o) {
        Item item = this.first;
        for (int i=0; i<amount; i++) {
            boolean isContains = item.data.equals(o);
        }
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(int index) throws IndexOutOfBoundsException {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
    }

