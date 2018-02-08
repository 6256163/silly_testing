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

    public void setId(String id) {
        if (id.equals(""));
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
//    @Override
//    public boolean equals(Object obj) {
//
//        if (this == obj) {
//            return true;
//        }
//
//        if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
//            return false;
//        }
//
//        AbstractEntity that = (AbstractEntity) obj;
//
//        return this.id.equals(that.getId());
//    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
//    @Override
//    public int hashCode() {
//        return id == null ? 0 : id.hashCode();
//    }
}