package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name = "comments")
@NamedQueries({
    @NamedQuery(name = "Comment.deleteAllRows", query = "DELETE from Comment"),
    @NamedQuery(name = "Comment.getAllRows", query = "SELECT c from Comment c")})

public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "user_comment", columnDefinition = "VARCHAR(250)")
    private String comment;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastEdited; 

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
    
    private String rocketID;
    
    public Comment(String comment, String rocketID) {
        this.comment = comment;
        this.created = new Date();
        this.lastEdited = new Date();
        this.rocketID = rocketID;
    }
    
    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(Date lastEdited) {
        this.lastEdited = lastEdited;
    }

    public String getRocketID() {
        return rocketID;
    }

    public void setRocketID(String rocketID) {
        this.rocketID = rocketID;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", comment=" + comment + ", created=" + created + ", lastEdited=" + lastEdited + ", user=" + user + ", rocketID=" + rocketID + '}';
    }
       
}
