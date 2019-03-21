package cn.sxh.fox;
import cn.sxh.fox.Book;

interface IBookManager{
        List<Book> getBookList();
        void addBook(in Book book);
}