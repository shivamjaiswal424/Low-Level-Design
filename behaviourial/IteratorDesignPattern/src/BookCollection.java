public interface BookCollection {
    Iterator<Book> createIterator();
    Iterator<Book> createReverseIterator();
}
