package com.jonatasleon.bears;

/**
 * Created by jonatasleon on 25/06/16.
 */
public class Bear {

    private String _id;
    private String name;
    private int __v;

    public Bear() {}

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    @Override
    public String toString() {
        return getName();
    }
}
