package com.frame.silly.com.frame.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base class to derive entity classes from.
 *
 * @author Oliver Gierke
 */
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Returns the identifier of the entity.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id=id;
    }

}