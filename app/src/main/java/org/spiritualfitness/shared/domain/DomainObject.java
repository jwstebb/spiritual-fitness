package org.spiritualfitness.shared.domain;

public abstract class DomainObject {
    private final String id;

    protected DomainObject(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object that){
        if (this == that) {
            return true;
        } else if (this.getClass() != that.getClass()) {
            return false;
        }

        return this.id == ((DomainObject) that).id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
