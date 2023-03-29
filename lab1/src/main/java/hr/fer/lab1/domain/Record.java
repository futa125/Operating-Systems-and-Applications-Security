package hr.fer.lab1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue
    private Long id;

    private String recordName;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date recordDate;

    private String recordOrigin;
    private String recordValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordOrigin() {
        return recordOrigin;
    }

    public void setRecordOrigin(String recordOrigin) {
        this.recordOrigin = recordOrigin;
    }

    public String getRecordValue() {
        return recordValue;
    }

    public void setRecordValue(String recordValue) {
        this.recordValue = recordValue;
    }
}
