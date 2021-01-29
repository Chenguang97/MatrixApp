package com.lai.matrix;

public class Item {
    private int drawable_id;
    private String drawable_label;

    public Item(String label, int id) {
        this.drawable_id = id;
        this.drawable_label = label;
    }

    public int getDrawable_id() {
        return drawable_id;
    }

    public void setDrawable_id(int drawable_id) {
        this.drawable_id = drawable_id;
    }

    public String getDrawable_label() {
        return drawable_label;
    }

    public void setDrawable_label(String drawable_label) {
        this.drawable_label = drawable_label;
    }

}
