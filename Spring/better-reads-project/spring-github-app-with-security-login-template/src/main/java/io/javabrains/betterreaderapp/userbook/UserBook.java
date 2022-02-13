package io.javabrains.betterreaderapp.userbook;
import org.springframework.data.cassandra.core.mapping.*;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import java.time.LocalDate;

@Table(value = "book_by_user_and_bookid")
public class UserBook {
    @PrimaryKey
    private UserBooksPrimaryKey key;
    @Column(value = "reading_status")
    @CassandraType(type = Name.TEXT)
    private String readingStatus;
    @Column(value = "started_date")
    @CassandraType(type = Name.DATE)
    private LocalDate startedDate;
    @Column(value = "completed_date")
    @CassandraType(type = Name.DATE)
    private LocalDate completedDate;
    @Column(value = "rating")
    @CassandraType(type = Name.INT)
    private int rating;

    public UserBooksPrimaryKey getKey() {
        return key;
    }

    public void setKey(UserBooksPrimaryKey key) {
        this.key = key;
    }

    public String getReadingStatus() {
        return readingStatus;
    }

    public void setReadingStatus(String readingStatus) {
        this.readingStatus = readingStatus;
    }

    public LocalDate getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(LocalDate startedDate) {
        this.startedDate = startedDate;
    }

    public LocalDate getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDate completedDate) {
        this.completedDate = completedDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
