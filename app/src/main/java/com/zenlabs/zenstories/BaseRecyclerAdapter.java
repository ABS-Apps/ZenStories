package com.zenlabs.zenstories;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class BaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> implements View.OnClickListener {

    protected Context mContext;
    protected List<T> mObjects;
    protected OnRecyclerViewInteractionListener mRecyclerViewInteractionListener;
    private Bundle mArguments;
    protected Typeface rupee = null;

    public BaseRecyclerAdapter(Context context, final List<T> objects) {
        mContext = context;
        mObjects = objects;
    }

    public BaseRecyclerAdapter(Context context, final List<T> objects, OnRecyclerViewInteractionListener listener) {
        this(context, objects);
        mRecyclerViewInteractionListener = listener;
    }

    public Bundle getArguments() {
        return mArguments;
    }

    public void setArguments(Bundle arguments) {
        this.mArguments = arguments;
    }

    public void addArgument(String key, String value) {
        if (mArguments == null) mArguments = new Bundle();
        mArguments.putString(key, value);
    }

    /**
     * Adds the specified object at the end of the array.
     *
     * @param object The object to add at the end of the array.
     */
    public void add(final T object) {
        mObjects.add(object);
        notifyItemInserted(getItemCount() - 1);
    }

    /**
     * Remove all elements from the list.
     */
    public void clear() {
        final int size = getItemCount();
        mObjects.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void set(List<T> objectsList) {
        this.mObjects = objectsList;
    }

    @Override
    public int getItemCount() {
        return (null != mObjects ? mObjects.size() : 0);
    }

    public T getItem(final int position) {
        return mObjects.get(position);
    }

    public long getItemId(final int position) {
        return position;
    }

    /**
     * Returns the position of the specified item in the array.
     *
     * @param item The item to retrieve the position of.
     * @return The position of the specified item.
     */
    public int getPosition(final T item) {
        return mObjects.indexOf(item);
    }

    /**
     * Inserts the specified object at the specified index in the array.
     *
     * @param object The object to insert into the array.
     * @param index  The index at which the object must be inserted.
     */
    public void insert(final T object, int index) {
        mObjects.add(index, object);
        notifyItemInserted(index);
    }

    /**
     * Removes the specified object from the array.
     *
     * @param object The object to remove.
     */
    public void remove(T object) {
        final int position = getPosition(object);
        mObjects.remove(object);
        notifyItemRemoved(position);
    }

    /**
     * Sorts the content of this adapter using the specified comparator.
     *
     * @param comparator The comparator used to sort the objects contained in this adapter.
     */
    public void sort(Comparator<? super T> comparator) {
        Collections.sort(mObjects, comparator);
        notifyItemRangeChanged(0, getItemCount());
    }

    @Override
    public void onClick(View v) {
        if (mRecyclerViewInteractionListener != null) {
            mRecyclerViewInteractionListener.onClick(v);
        }
    }

    public void setRecyclerViewInteractionListener(OnRecyclerViewInteractionListener recyclerViewInteractionListener) {
        this.mRecyclerViewInteractionListener = recyclerViewInteractionListener;
    }


    public interface OnRecyclerViewInteractionListener {
        void onClick(View view);
    }


}

