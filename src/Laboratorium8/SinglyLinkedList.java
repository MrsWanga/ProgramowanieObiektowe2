package Laboratorium8;

public class SinglyLinkedList<E> implements List<E> {
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

        @Override
        public String toString() {
            return "Item{" +
                    "data=" + data +
                    '}';
        }
    }

    public SinglyLinkedList() {
        this.first = null;
        this.last = null;
        this.amount = 0;
    }

    @Override
    public boolean add(E element) {
        if(!Validator.getInstance().isNull(element)){
        Item nItem = new Item(element);
        if (this.amount==0) {
            this.first = nItem;
            this.last = nItem;
        }
        last.next = nItem;
        last = nItem;
        amount++;
        return true;
        }else{
            System.out.println("Element dodawany do listy jest pusty");
            return false;
        }
    }

    @Override
    public void add(int index, E element) {
        if(!Validator.getInstance().isNull(element)){
            Item item = this.first;
            Item nItem = new Item(element);
            for (int i=0; i<index; i++ ) {
                item=item.next;
            }
            nItem.next=item.next;
            item.next=nItem;
            if(index==0){
                this.first=nItem;
            }else if(index==this.amount){
                this.last=nItem;
            }
            this.amount++;
        }else{
            System.out.println("Element dodawany do listy jest pusty");
        }

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
        this.amount=0;
    }

    @Override
    public boolean contains(Object o) {
        Item item = this.first;
        for (int i=0; i<amount; i++) {
            if (item.data.equals(o)) {
                return true;
            }
            item=item.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        Item item = this.first;
        for (int i=0; i<index; i++) {
            item=item.next;
        }
        return item.data;
    }

    @Override
    public int indexOf(Object o) {
        if(!Validator.getInstance().isNull(o)) {
            Item item = this.first;
            int a = -1;
            for (int i = 0; i < amount; i++) {
                if (item.data.equals(o)) {
                    a = i;
                    break;
                }
                item = item.next;
            }
            return a;
        }else{
            System.out.println("Pr??bujesz wyszuka?? obiekt, kt??ry jest pusty");
            return -1;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.amount == 0;
    }

    @Override
    public boolean remove(int index) throws IndexOutOfBoundsException {
        try{
            Item item = this.first;
            if (index==0){
                this.first = this.first.next;
                return true;
            }
            for (int i=0; i<index-1; i++) {
                item=item.next;
            }
            item.next.data=null;
            item.next=item.next.next;
            this.amount--;
            return true;
        }catch (Exception e){
            System.out.println("Nie mo??na usun???? elementu z listy");
            return false;
        }
    }

    @Override
    public int size() {
        return amount;
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", amount=" + amount +
                '}';
    }
}
