package iloveyouboss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Criteria implements Iterable<Criterion> {
    private ArrayList<Criterion> criteria;

    public Criteria() { this(new ArrayList<>()); }
    public Criteria(ArrayList<Criterion> criteria) { this.criteria = criteria; }

    public void add(Criterion criterion) { criteria.add(criterion); }

    public Iterator<Criterion> iterator() { return new MyIterator(); }

    class MyIterator implements Iterator<Criterion> {

        private int index = 0;

        public boolean hasNext() { return index < criteria.size(); }

        public Criterion next() {
            if (index == criteria.size()) {
                throw new NoSuchElementException();
            }
            return criteria.get(index++);
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported yet");
        }
    }
}
