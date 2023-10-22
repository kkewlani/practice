import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HT<K,V> {

    List<Entry<K,V>>[] table = new List[100];

    boolean put(K key, V value) {
        boolean isAdded=false;
        try{
            Entry entry = new Entry<>(key,value);
            int kIndex = generateIndex(key);
            List list = table[kIndex];
            if(!(list==null)) {
                list.add(entry);
            } else {
                list = new ArrayList<Entry<K,V>>();
                list.add(entry);
                table[kIndex] = list;
            }
            isAdded = true;
        }
        finally{
            return isAdded;
        }
    }

    V get(K key ) {
        int kIndex = generateIndex(key);
        //override contains by having a custom List
        Entry entry = new Entry<>(key,null);
        if(!table[kIndex].isEmpty() && table[kIndex].contains(entry)) {
            return table[kIndex].stream()
                    .filter(e->e.equals(entry))
                    .map(Entry::getValue)
                    .findAny()
                    .orElse(null);
        }
        return null;
    }

    private int generateIndex(K key) {
        return 0;
    }

    class Entry<K,V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}
