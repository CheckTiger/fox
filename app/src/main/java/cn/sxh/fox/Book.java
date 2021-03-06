package cn.sxh.fox;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @package-name: cn.sxh.fox.aidl
 * @auther:snowFox
 * @Email:snowTigersong@gmail.com
 * @time: 2019/1/15 0015 : 10 :13
 * @project-name: fox
 */

public class Book implements Parcelable{

    public int bookId;
    public String bookName;

    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    protected Book(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookId);
        dest.writeString(bookName);
    }
}
